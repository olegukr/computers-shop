package org.factoriaf5;

public class Computer {

    long computerID;

    String  computerBrand;
    int     amountOfMemory_GB;
    Processor processor;
    String  operatingSystem;
    double  price;
    int     quantity;

    public Computer(String computerBrand, int amountOfMemory_GB, Processor processor, String operatingSystem,
            double price, int quantity) {
        this.computerBrand = computerBrand;
        this.amountOfMemory_GB = amountOfMemory_GB;
        this.processor = processor;
        this.operatingSystem = operatingSystem;
        this.price = price;
        this.quantity = quantity;
    }


    
}
