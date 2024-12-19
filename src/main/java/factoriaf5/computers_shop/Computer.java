package factoriaf5.computers_shop;

import jakarta.persistence.*;

@Entity
@Table(name = "computers")
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private int memory;

    @Column(name = "processor_features", nullable = false)
    private String processorFeatures;

    @Column(name = "operating_system", nullable = false)
    private String operatingSystem;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int quantity; // New attribute to track the quantity of this model

    @ManyToOne
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    public Computer() {}

    public Computer(String brand, int memory, String processorFeatures, String operatingSystem, double price, int quantity, Shop shop) {
        this.brand = brand;
        this.memory = memory;
        this.processorFeatures = processorFeatures;
        this.operatingSystem = operatingSystem;
        this.price = price;
        this.quantity = quantity;
        this.shop = shop;
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public int getMemory() {
        return memory;
    }

    public String getProcessorFeatures() {
        return processorFeatures;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
