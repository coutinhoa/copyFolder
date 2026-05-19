import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);

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

        scanner.close();*/

        /*Scanner scanner = new Scanner(System.in);
        System.out.print("Enter target concentration (between 0 and 1): ");
        double targetConcentration = scanner.nextDouble();

        ChemicalBath chemicalBath = new ChemicalBath("1", 10, 0.4);
        double refillRequired = chemicalBath.calculateRefillLiters(targetConcentration, chemicalBath.getCurrentConcentration(), chemicalBath.getCurrentVolume());
        System.out.printf("Refill needed: %.2f Liters.%n", refillRequired);
        scanner.close();*/


        Scanner scanner2 = new Scanner(System.in);
        boolean running = true;
        System.out.print("Enter position: ");


        while (running) {
            int index = scanner2.nextInt();

            if (index == -1) {
                System.out.println("Exiting...");
                running = false;
            } else {
                ProcessArray processArray = new ProcessArray();
                System.out.println(processArray);

                processArray.heat(index);
                System.out.print("Processed array: " + processArray);


            }
        }
        scanner2.close();
    }
}

