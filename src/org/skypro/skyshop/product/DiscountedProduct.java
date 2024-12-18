package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private int basePrice;
    private int discountPercent;

    public DiscountedProduct(String productName, int basePrice, int discountPercent) {
        super(productName);
        if(basePrice >=0 && discountPercent >=0 && discountPercent <=100) {
            this.basePrice = basePrice;
            this.discountPercent = discountPercent;
        }
    }

    @Override
    public int getProductPrice() {
        return basePrice * (1 + discountPercent / 100);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return productName + " : " + getProductPrice() + " (скидка " + discountPercent + "%)";
    }
}