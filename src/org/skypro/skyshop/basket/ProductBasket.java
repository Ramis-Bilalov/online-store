package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    static Product[] products = new Product[5];

    public static void addProduct(Product product) {
        boolean status = false;
        for (int i = 0; i < products.length; i++) {
            if(products[i] == null) {
                status = false;
                products[i] = product;
                break;
            } else status = true;
        }
        if(status) {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public static int getBasketCost() {
        int sum = 0;
        for (int i = 0; i < products.length; i++) {
            if(products[i] != null) {
                sum = sum + products[i].getProductPrice();
            }
        }
        return sum;
    }

    public static void printBasketContent() {
        int count = 0;                                                  // ввел эту переменную для подсчета товаров в корзине, если 0 значит корзина пустая
        int specialProductsCount = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                if(products[i].isSpecial()) {
                    specialProductsCount++;
                }
                count++;
                System.out.println(products[i]);
            }
        }
        if(count==0) {
            System.out.println("В корзине пусто");
        }
        System.out.println("------------------------------\nИтого: " + getBasketCost());
        System.out.println("Специальных товаров: " + specialProductsCount);
    }

    public static boolean isProductOnBasket(String productName) {
        for (int i = 0; i < products.length; i++) {
            if(products[i] != null && products[i].getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public static void cleanBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
    }
}
