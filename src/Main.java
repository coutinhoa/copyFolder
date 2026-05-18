import java.io.IOException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter source folder: ");
        String source = scanner.nextLine();

        System.out.print("Enter destination folder: ");
        String destination = scanner.nextLine();

        try {
            FolderCopier.copyDirectory(source, destination);
            System.out.println("Copy finished.");
        } catch (IOException e) {
            System.err.println("Copy failed: " + e.getMessage());
        }

        scanner.close();
    }
}

