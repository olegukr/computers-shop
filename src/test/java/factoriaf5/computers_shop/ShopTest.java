package factoriaf5.computers_shop;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ShopTest {

    @Test
    public void testShopConstructorAndGetters() {
        Shop shop = new Shop("Tech Store", "John Doe", "123456789");

        assertEquals("Tech Store", shop.getName());
        assertEquals("John Doe", shop.getOwner());
        assertEquals("123456789", shop.getTaxId());
    }

    @Test
    public void testSetComputers() {
        Shop shop = new Shop("Tech Store", "John Doe", "123456789");
        List<Computer> computers = new ArrayList<>();
        Computer computer1 = new Computer();
        Computer computer2 = new Computer();
        computers.add(computer1);
        computers.add(computer2);

        shop.setComputers(computers);

        assertEquals(2, shop.getComputers().size());
        assertTrue(shop.getComputers().contains(computer1));
        assertTrue(shop.getComputers().contains(computer2));
    }

    @Test
    public void testGetId() {
        Shop shop = new Shop("Tech Store", "John Doe", "123456789");
        assertNull(shop.getId()); // ID should be null before persisting
    }

    @Test
    public void testSetName() {
        Shop shop = new Shop("Tech Store", "John Doe", "123456789");
        shop.setName("New Tech Store");
        assertEquals("New Tech Store", shop.getName());
    }

    @Test
    public void testSetId() {
        Shop shop = new Shop("Tech Store", "John Doe", "123456789");
        shop.setId(1L);
        assertEquals(1L, shop.getId());
    }
}
