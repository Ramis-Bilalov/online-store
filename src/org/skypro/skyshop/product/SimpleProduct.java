package org.skypro.skyshop.product;

public class SimpleProduct extends Product{

    private int productPrice;

    public SimpleProduct(String productName, int productPrice) {
        super(productName);
        if(productPrice >= 1) {
            this.productPrice = productPrice;
        } else {
            throw new IllegalArgumentException("Цена не может быть отрицательной!");
        }
    }

    @Override
    public int getProductPrice() {
        return productPrice;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return productName + " : " + productPrice;
    }
}
