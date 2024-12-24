
package factoriaf5.computers_shop;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;





public class ShopServiceTest {

    @Mock
    private ShopRepository shopRepository;

    @Mock
    private ComputerRepository computerRepository;

    @InjectMocks
    private ShopService shopService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddShop() {
        Shop shop = new Shop();
        when(shopRepository.save(shop)).thenReturn(shop);

        Shop result = shopService.addShop(shop);

        assertEquals(shop, result);
        verify(shopRepository, times(1)).save(shop);
    }

    @Test
    public void testAddComputerToShop() {
        Long shopId = 1L;
        Shop shop = new Shop();
        Computer computer = new Computer();
        when(shopRepository.findById(shopId)).thenReturn(Optional.of(shop));
        when(computerRepository.save(computer)).thenReturn(computer);

        Computer result = shopService.addComputerToShop(shopId, computer);

        assertEquals(computer, result);
        assertEquals(shop, computer.getShop());
        verify(shopRepository, times(1)).findById(shopId);
        verify(computerRepository, times(1)).save(computer);
    }

    @Test
    public void testAddComputerToShop_ShopNotFound() {
        Long shopId = 1L;
        Computer computer = new Computer();
        when(shopRepository.findById(shopId)).thenReturn(Optional.empty());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            shopService.addComputerToShop(shopId, computer);
        });

        assertEquals("Shop not found", exception.getMessage());
        verify(shopRepository, times(1)).findById(shopId);
        verify(computerRepository, times(0)).save(computer);
    }

    @Test
    public void testGetComputersByShop() {
        Long shopId = 1L;
        Shop shop = new Shop();
        List<Computer> computers = Arrays.asList(new Computer(), new Computer());
        shop.setComputers(computers);
        when(shopRepository.findById(shopId)).thenReturn(Optional.of(shop));

        List<Computer> result = shopService.getComputersByShop(shopId);

        assertEquals(computers, result);
        verify(shopRepository, times(1)).findById(shopId);
    }

    @Test
    public void testGetComputersByShop_ShopNotFound() {
        Long shopId = 1L;
        when(shopRepository.findById(shopId)).thenReturn(Optional.empty());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            shopService.getComputersByShop(shopId);
        });

        assertEquals("Shop not found", exception.getMessage());
        verify(shopRepository, times(1)).findById(shopId);
    }
}