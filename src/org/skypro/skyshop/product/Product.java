package org.skypro.skyshop.product;

public abstract class Product {

    protected String productName;

    public Product(String productName) {
        if(!productName.isBlank()) {
            this.productName = productName;
        }
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if (!productName.isBlank()) {
            this.productName = productName;
        }
    }

    public abstract int getProductPrice();

    public abstract boolean isSpecial();

}
