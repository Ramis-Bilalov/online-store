package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {

    protected String productName;


    public Product(String productName) {
        if(productName != null && !productName.isBlank()) {
            this.productName = productName;
        } else throw new IllegalArgumentException("Неправильное имя");
    }

    @Override
    public String searchTerm() {
        return productName;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
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
