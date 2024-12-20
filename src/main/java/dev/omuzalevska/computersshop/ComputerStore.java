package dev.omuzalevska.computersshop;

import java.util.ArrayList;

public class ComputerStore {
    private String storeName;
    private String owner;
    private String taxId;
    private ArrayList<Computer> computers;

    public ComputerStore(String storeName, String owner, String taxId) {
        this.storeName = storeName;
        this.owner = owner;
        this.taxId = taxId;
        this.computers = new ArrayList<>();
    } 

    public void addComputer(Computer computer) {
        computers.add(computer);
        System.out.println("Computer added successfully!");
    }
    
    public void removeComputer(String brand) {
        for (int i = 0; i < computers.size(); i++) {
            if (computers.get(i).getBrand().equalsIgnoreCase(brand)) {
                computers.remove(i);
                System.out.println("Computer removed successfully!");
                return;
            }
        }
        System.out.println("No computer found with the brand: " + brand);
    }

    public ArrayList<Computer> searchComputersByBrand(String brand) {
        ArrayList<Computer> matchingComputers = new ArrayList<>();
        for (Computer computer : computers) {
            if (computer.getBrand().equalsIgnoreCase(brand)) {
                matchingComputers.add(computer);
            }
        }
        return matchingComputers; 
    }

    public ArrayList<Computer> listComputers() {
        return computers;
    }
    
    public String getStoreName() {
        return storeName;
    }

    public String getOwner() {
        return owner;
    }

    public String getTaxId() {
        return taxId;
    }

    public ArrayList<Computer> getComputers() {
        return computers;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public void setComputers(ArrayList<Computer> computers) {
        this.computers = computers;
    }

    
}
