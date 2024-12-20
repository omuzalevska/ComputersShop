package dev.omuzalevska.computersshop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class StoreControllerTest {

    private static class TestStoreView extends StoreView {
        private String lastMessage;
        private ArrayList<Computer> lastComputers;

        @Override
        public void showMessage(String message) {
            this.lastMessage = message;
        }

        @Override
        public void showComputers(ArrayList<Computer> computers) {
            this.lastComputers = computers;
        }

        public String getLastMessage() {
            return lastMessage;
        }

        public ArrayList<Computer> getLastComputers() {
            return lastComputers;
        }
    }

    @Test
    public void testAddComputer() {
        ComputerStore store = new ComputerStore("Test Store", "Owner", "123456789");
        TestStoreView view = new TestStoreView();
        StoreController controller = new StoreController(store, view);

        controller.addComputer("Dell", 16, "Intel i7", "Windows 10", 1200.0);

        assertEquals(1, store.getComputers().size());
        assertEquals("Dell", store.getComputers().get(0).getBrand());
        assertEquals("Computer added successfully!", view.getLastMessage());
    }

    @Test
    public void testRemoveComputer() {
        ComputerStore store = new ComputerStore("Test Store", "Owner", "123456789");
        store.addComputer(new Computer("Dell", 16, "Intel i7", "Windows 10", 1200.0));
        TestStoreView view = new TestStoreView();
        StoreController controller = new StoreController(store, view);

        controller.removeComputer("Dell");

        assertTrue(store.getComputers().isEmpty());
    }

    @Test
    public void testSearchComputerFound() {
        ComputerStore store = new ComputerStore("Test Store", "Owner", "123456789");
        Computer dell = new Computer("Dell", 16, "Intel i7", "Windows 10", 1200.0);
        store.addComputer(dell);
        TestStoreView view = new TestStoreView();
        StoreController controller = new StoreController(store, view);

        controller.searchComputer("Dell");

        assertEquals(1, view.getLastComputers().size());
        assertEquals(dell, view.getLastComputers().get(0));
    }

    @Test
    public void testSearchComputerNotFound() {
        ComputerStore store = new ComputerStore("Test Store", "Owner", "123456789");
        TestStoreView view = new TestStoreView();
        StoreController controller = new StoreController(store, view);

        controller.searchComputer("HP");

        assertEquals("No computers found for brand: HP", view.getLastMessage());
    }

    @Test
    public void testListComputers() {
        ComputerStore store = new ComputerStore("Test Store", "Owner", "123456789");
        Computer dell = new Computer("Dell", 16, "Intel i7", "Windows 10", 1200.0);
        Computer hp = new Computer("HP", 8, "AMD Ryzen 5", "Windows 11", 800.0);
        store.addComputer(dell);
        store.addComputer(hp);
        TestStoreView view = new TestStoreView();
        StoreController controller = new StoreController(store, view);

        controller.listComputers();

        assertEquals(2, view.getLastComputers().size());
        assertTrue(view.getLastComputers().contains(dell));
        assertTrue(view.getLastComputers().contains(hp));
    }
}
