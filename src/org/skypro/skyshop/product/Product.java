package org.skypro.skyshop.product;

public class Product {

    private String productName;
    private int productPrice;

    public Product(String productName, int productPrice) {
        if(productPrice >=0 && !productName.isBlank()) {
            this.productName = productName;
            this.productPrice = productPrice;
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

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        if(productPrice >= 0) {
            this.productPrice = productPrice;
        } else throw new RuntimeException("Отрицательная цена");
    }
}
