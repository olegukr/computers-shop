package factoriaf5.computers_shop;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShopService {

    private final ShopRepository shopRepository;
    private final ComputerRepository computerRepository;

    public ShopService(ShopRepository shopRepository, ComputerRepository computerRepository) {
        this.shopRepository = shopRepository;
        this.computerRepository = computerRepository;
    }

    public Shop addShop(Shop shop) {
        return shopRepository.save(shop);
    }

    public Computer addComputerToShop(Long shopId, Computer computer) {
        Shop shop = shopRepository.findById(shopId)
                .orElseThrow(() -> new IllegalArgumentException("Shop not found"));
        computer.setShop(shop);
        return computerRepository.save(computer);
    }

    public List<Computer> getComputersByShop(Long shopId) {
        Shop shop = shopRepository.findById(shopId)
                .orElseThrow(() -> new IllegalArgumentException("Shop not found"));
        return shop.getComputers();
    }
}
