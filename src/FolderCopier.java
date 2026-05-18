import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FolderCopier {

    public static void copyDirectory(String sourceDirectoryLocation,
                                     String destinationDirectoryLocation) throws IOException {

        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Future<?>> futures = new ArrayList<>();

        try {
            Files.walk(Paths.get(sourceDirectoryLocation))
                    .forEach(source -> {
                        Path destination = Paths.get(
                                destinationDirectoryLocation,
                                source.toString().substring(sourceDirectoryLocation.length())
                        );

                        Runnable copyTask = () -> {
                            try {
                                if (Files.isDirectory(source)) {
                                    Files.createDirectories(destination);
                                } else {
                                    Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        };

                        Future<?> future = executor.submit(copyTask);
                        futures.add(future);
                    });

            for (Future<?> future : futures) {
                future.get();
            }
        } catch (Exception e) {
            throw new IOException("Failed to copy directory", e);
        } finally {
            executor.shutdown();
        }
    }
}