package factoriaf5.computers_shop;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shops")
public class ShopController {

    private final ShopService service;
    public ShopController(ShopService service) {
        this.service = service;
    }

    @PostMapping
    public Shop addShop(@RequestBody Shop shop) {
        return service.addShop(shop);
    }

    @PostMapping("/{shopId}/computers")
    public Computer addComputerToShop(@PathVariable Long shopId, @RequestBody Computer computer) {
        return service.addComputerToShop(shopId, computer);
    }

    @GetMapping("/{shopId}/computers")
    public List<Computer> getComputersByShop(@PathVariable Long shopId) {
        return service.getComputersByShop(shopId);
    }
}
