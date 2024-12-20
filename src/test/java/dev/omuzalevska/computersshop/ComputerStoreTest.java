package dev.omuzalevska.computersshop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class ComputerStoreTest {

    @Test
    public void testAddComputer() {
        ComputerStore store = new ComputerStore("Tech World", "Alice", "123456789");
        Computer computer = new Computer("Dell", 16, "Intel i7", "Windows 10", 1200.0);

        store.addComputer(computer);

        assertEquals(1, store.getComputers().size());
        assertEquals("Dell", store.getComputers().get(0).getBrand());
    }

    @Test
    public void testRemoveComputer() {
        ComputerStore store = new ComputerStore("Tech World", "Alice", "123456789");
        Computer computer1 = new Computer("Dell", 16, "Intel i7", "Windows 10", 1200.0);
        Computer computer2 = new Computer("HP", 8, "AMD Ryzen 5", "Windows 11", 800.0);

        store.addComputer(computer1);
        store.addComputer(computer2);

        store.removeComputer("Dell");

        assertEquals(1, store.getComputers().size());
        assertEquals("HP", store.getComputers().get(0).getBrand());
    }

    @Test
    public void testRemoveNonExistentComputer() {
        ComputerStore store = new ComputerStore("Tech World", "Alice", "123456789");
        Computer computer = new Computer("Dell", 16, "Intel i7", "Windows 10", 1200.0);

        store.addComputer(computer);

        store.removeComputer("HP");

        assertEquals(1, store.getComputers().size());
    }

    @Test
    public void testSearchComputersByBrand() {
        ComputerStore store = new ComputerStore("Tech World", "Alice", "123456789");
        Computer computer1 = new Computer("Dell", 16, "Intel i7", "Windows 10", 1200.0);
        Computer computer2 = new Computer("HP", 8, "AMD Ryzen 5", "Windows 11", 800.0);
        Computer computer3 = new Computer("Dell", 32, "Intel i9", "Windows 11", 2000.0);

        store.addComputer(computer1);
        store.addComputer(computer2);
        store.addComputer(computer3);

        ArrayList<Computer> result = store.searchComputersByBrand("Dell");

        assertEquals(2, result.size());
    }

    @Test
    public void testListComputers() {
        ComputerStore store = new ComputerStore("Tech World", "Alice", "123456789");
        Computer computer1 = new Computer("Dell", 16, "Intel i7", "Windows 10", 1200.0);
        Computer computer2 = new Computer("HP", 8, "AMD Ryzen 5", "Windows 11", 800.0);

        store.addComputer(computer1);
        store.addComputer(computer2);

        ArrayList<Computer> computers = store.listComputers();

        assertEquals(2, computers.size());
    }

    @Test
    public void testSettersAndGetters() {
        ComputerStore store = new ComputerStore("Tech World", "Alice", "123456789");

        store.setStoreName("Gadget Hub");
        store.setOwner("Bob");
        store.setTaxId("987654321");

        assertEquals("Gadget Hub", store.getStoreName());
        assertEquals("Bob", store.getOwner());
        assertEquals("987654321", store.getTaxId());
    }
}