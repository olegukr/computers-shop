package factoriaf5.computers_shop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ComputerTest {

    @Test
    public void testComputerConstructorAndGetters() {
        Shop shop = new Shop(); // Assuming Shop class has a default constructor
        Computer computer = new Computer("Dell", 16, "Intel i7", "Windows 10", 1200.00, 10, shop);

        assertEquals("Dell", computer.getBrand());
        assertEquals(16, computer.getMemory());
        assertEquals("Intel i7", computer.getProcessorFeatures());
        assertEquals("Windows 10", computer.getOperatingSystem());
        assertEquals(1200.00, computer.getPrice());
        assertEquals(10, computer.getQuantity());
        assertEquals(shop, computer.getShop());
    }

    @Test
    public void testSetQuantity() {
        Computer computer = new Computer();
        computer.setQuantity(20);
        assertEquals(20, computer.getQuantity());
    }

    @Test
    public void testSetShop() {
        Computer computer = new Computer();
        Shop shop = new Shop(); // Assuming Shop class has a default constructor
        computer.setShop(shop);
        assertEquals(shop, computer.getShop());
    }

    @Test
    public void testSetBrand() {
        Computer computer = new Computer();
        computer.setBrand("HP");
        assertEquals("HP", computer.getBrand());
    }

    @Test
    public void testSetId() {
        Computer computer = new Computer();
        computer.setId(1L);
        assertEquals(1L, computer.getId());
    }
}
