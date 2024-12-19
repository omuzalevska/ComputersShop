package dev.omuzalevska.computersshop;

import java.util.ArrayList;

public class StoreView {

    public void showMenu() {
        System.out.println("Choose an option:");
        System.out.println("1. Add a computer");
        System.out.println("2. Remove a computer");
        System.out.println("3. Search for a computer");
        System.out.println("4. List all computers");
        System.out.println("5. Exit");        
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showComputers(ArrayList<Computer> computers) {
        if (computers.isEmpty()) {
            System.out.println("No computers available.");
        } else {
            System.out.println("List of computers:");
            for (Computer computer : computers) {
                System.out.println(computer); // toString 
            }
        }
    }
}