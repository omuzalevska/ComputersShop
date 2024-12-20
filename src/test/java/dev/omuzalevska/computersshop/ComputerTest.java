package dev.omuzalevska.computersshop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComputerTest {

    @Test
    public void testConstructorAndGetters() {
        Computer computer = new Computer("Dell", 16, "Intel i7", "Windows 10", 1200.0);

        assertEquals("Dell", computer.getBrand());
        assertEquals(16, computer.getMemory());
        assertEquals("Intel i7", computer.getProcessor());
        assertEquals("Windows 10", computer.getOperatingSystem());
        assertEquals(1200.0, computer.getPrice());
    }

    @Test
    public void testSetters() {
        Computer computer = new Computer("Dell", 16, "Intel i7", "Windows 10", 1200.0);

        computer.setBrand("HP");
        computer.setMemory(32);
        computer.setProcessor("AMD Ryzen 9");
        computer.setOperatingSystem("Linux");
        computer.setPrice(1500.0);

        assertEquals("HP", computer.getBrand());
        assertEquals(32, computer.getMemory());
        assertEquals("AMD Ryzen 9", computer.getProcessor());
        assertEquals("Linux", computer.getOperatingSystem());
        assertEquals(1500.0, computer.getPrice());
    }

    @Test
    public void testToString() {
        Computer computer = new Computer("Dell", 16, "Intel i7", "Windows 10", 1200.0);
        String expected = "Computer: Brand='Dell', Memory=16Gb, Processor='Intel i7', OS='Windows 10', Price=1200.0$";
        assertEquals(expected, computer.toString());
    }
}
