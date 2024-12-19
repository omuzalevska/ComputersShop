package dev.omuzalevska.computersshop;

public class Computer {
    private String brand;
    private int memory;
    private String processor;
    private String operatingSystem;
    private double price;

    public Computer(String brand, int memory, String processor, String operatingSystem, double price) {
        this.brand = brand;
        this.memory = memory;
        this.processor = processor;
        this.operatingSystem = operatingSystem;
        this.price = price;
    }

    @Override
    public String toString() {
    return "Computer: " +
            "Brand='" + brand + '\'' +
            ", Memory=" + memory + "Gb" +
            ", Processor='" + processor + '\'' +
            ", OS='" + operatingSystem + '\'' +
            ", Price=" + price +
            '$';
}
    public String getBrand() {
        return brand;
    }

    public int getMemory() {
        return memory;
    }

    public String getProcessor() {
        return processor;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public double getPrice() {
        return price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    


}
