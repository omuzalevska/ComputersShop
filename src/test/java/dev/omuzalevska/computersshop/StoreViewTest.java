package dev.omuzalevska.computersshop;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class StoreViewTest {

    private static class TestStoreView extends StoreView {
        private StringBuilder output = new StringBuilder();

        @Override
        public void showMessage(String message) {
            output.append(message).append("\n");
        }

        @Override
        public void showComputers(ArrayList<Computer> computers) {
            if (computers.isEmpty()) {
                output.append("No computers available.\n");
            } else {
                output.append("List of computers:\n");
                for (Computer computer : computers) {
                    output.append(computer.toString()).append("\n");
                }
            }
        }

        public String getOutput() {
            return output.toString();
        }

    }

    @Test
    public void testShowComputersWithItems() {
        TestStoreView view = new TestStoreView();
        ArrayList<Computer> computers = new ArrayList<>();
        computers.add(new Computer("Dell", 16, "Intel i7", "Windows 10", 1200.0));
        computers.add(new Computer("HP", 8, "AMD Ryzen 5", "Windows 11", 800.0));

        view.showComputers(computers);

        String expectedOutput = "List of computers:\n" +
                "Computer: Brand='Dell', Memory=16Gb, Processor='Intel i7', OS='Windows 10', Price=1200.0$\n" +
                "Computer: Brand='HP', Memory=8Gb, Processor='AMD Ryzen 5', OS='Windows 11', Price=800.0$\n";
        assertEquals(expectedOutput, view.getOutput());
    }

    @Test
    public void testShowMessage() {

        StoreView view = new StoreView();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String testMessage = "Test message for showMessage method.";
        view.showMessage(testMessage);

        String output = outputStream.toString().trim();
        assertEquals(testMessage, output);
    }

    @Test
    public void testShowComputersEmptyList() {

        StoreView view = new StoreView();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ArrayList<Computer> emptyList = new ArrayList<>();
        view.showComputers(emptyList);

        String expectedOutput = "No computers available.";
        String actualOutput = outputStream.toString().trim();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testShowComputersNonEmptyList() {

        StoreView view = new StoreView();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ArrayList<Computer> computerList = new ArrayList<>();
        computerList.add(new Computer("Dell", 16, "Intel i7", "Windows 10", 1200.0));
        computerList.add(new Computer("HP", 8, "AMD Ryzen 5", "Windows 11", 900.0));

        view.showComputers(computerList);

        String expectedOutput = "List of computers:" + System.lineSeparator() +
                "Computer: Brand='Dell', Memory=16Gb, Processor='Intel i7', OS='Windows 10', Price=1200.0$"
                + System.lineSeparator() +
                "Computer: Brand='HP', Memory=8Gb, Processor='AMD Ryzen 5', OS='Windows 11', Price=900.0$"
                + System.lineSeparator();

        String actualOutput = outputStream.toString();

        assertEquals(expectedOutput, actualOutput);
    }

}
