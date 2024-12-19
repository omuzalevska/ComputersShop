package dev.omuzalevska.computersshop;

import java.util.ArrayList;

public class StoreController {
        private ComputerStore model;
        private StoreView view;
    
        public StoreController(ComputerStore model, StoreView view) {
            this.model = model;
            this.view = view;
        }
    
        public void addComputer(String brand, int memory, String processor, String os, double price) {
            Computer computer = new Computer(brand, memory, processor, os, price);
            model.addComputer(computer);
            view.showMessage("Computer added successfully!");
        }
    
        public void removeComputer(String brand) {
            model.removeComputer(brand);
        }
    
        // public void searchComputer(String brand) {
        //     view.showMessage("Searching for a computer...");
        //     model.searchComputer(brand);
        // }
        public void searchComputer(String brand) {
            ArrayList<Computer> matchingComputers = model.searchComputersByBrand(brand);
            if (matchingComputers.isEmpty()) {
                view.showMessage("No computers found for brand: " + brand);
            } else {
                view.showComputers(matchingComputers); // список знайдених
            }
        }
        // public void listComputers() {
        //     view.showComputers(model.listComputers());
        // }
        public void listComputers() {
            ArrayList<Computer> computers = model.listComputers(); // список із моделі
            view.showComputers(computers); //  у View для відображення
        }
    }
