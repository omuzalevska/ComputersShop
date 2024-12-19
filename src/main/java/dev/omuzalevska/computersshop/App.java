package dev.omuzalevska.computersshop;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ComputerStore store = new ComputerStore("Tech World", "Alica", "123456789");
        StoreView view = new StoreView();
        StoreController controller = new StoreController(store, view);

        while (true) {
            view.showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Enter brand:");
                    String brand = scanner.nextLine();
                    System.out.println("Enter memory (Gb):");
                    int memory = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter processor:");
                    String processor = scanner.nextLine();
                    System.out.println("Enter operating system:");
                    String os = scanner.nextLine();
                    System.out.println("Enter price:");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    controller.addComputer(brand, memory, processor, os, price);
                    break;

                case 2:
                    System.out.println("Enter the brand of the computer to remove:");
                    String removeBrand = scanner.nextLine();
                    controller.removeComputer(removeBrand);
                    break;

                case 3:
                    System.out.println("Enter the brand of the computer to search for:");
                    String searchBrand = scanner.nextLine();
                    controller.searchComputer(searchBrand);
                    break;

                case 4:
                    controller.listComputers();
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
