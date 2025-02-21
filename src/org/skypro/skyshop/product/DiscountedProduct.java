package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private int basePrice;
    private int discountPercent;

    public DiscountedProduct(String productName, int basePrice, int discountPercent) {
        super(productName);
        if (basePrice >= 1) {
            this.basePrice = basePrice;
        } else throw new IllegalArgumentException("Цена ниже 1");
        if (discountPercent >= 0 && discountPercent <= 100) {
            this.discountPercent = discountPercent;
        } else throw new IllegalArgumentException("Неправильно указан процент");
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