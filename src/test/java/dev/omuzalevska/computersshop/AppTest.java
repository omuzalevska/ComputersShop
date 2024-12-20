package dev.omuzalevska.computersshop;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    // @Test
    // public void testAddAndListComputers() {

    //     String simulatedInput = "1\nDell\n16\nIntel i7\nWindows 10\n1200.0\n4\n5\n";
    //     System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

    //     ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    //     System.setOut(new PrintStream(outputStream));

    //     App.main(new String[]{});

    //     String output = outputStream.toString();
    //     assertTrue(output.contains("Computer added successfully!"));
    //     assertTrue(output.contains("List of computers:"));
    //     assertTrue(output.contains("Brand='Dell', Memory=16Gb, Processor='Intel i7', OS='Windows 10', Price=1200.0$"));
    // }

    @Test
    public void testInvalidOption() {

        String simulatedInput = "10\n5\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
    
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        App.main(new String[]{});

        String output = outputStream.toString();
        assertTrue(output.contains("Invalid choice. Please try again."));
    }

    @Test
    public void testExit() {
    
        String simulatedInput = "5\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        App.main(new String[]{});

        String output = outputStream.toString();
        assertTrue(output.contains("Goodbye!"));
    }
}
