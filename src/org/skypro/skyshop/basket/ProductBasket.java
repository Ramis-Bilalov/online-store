package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    static Map<String, List<Product>> productsBasket = new LinkedHashMap<>();

    public static void addProduct(Product product) {
        String productName = product.getProductName();
        List<Product> productsList = productsBasket.getOrDefault(productName, new ArrayList<>());
        productsList.add(product);
        productsBasket.put(productName, productsList);
    }

    public static List<Product> removeProductsByName(String name) {
        List<Product> deleteList = new LinkedList<>();
        List<Product> productsList = productsBasket.getOrDefault(name, new ArrayList<>());
        for (Product product : productsList) {
            if (product.getProductName().contains(name)) {
                deleteList.add(product);
                productsBasket.remove(name);
            }
        }
        return deleteList;
    }

    public static int getBasketCost() {
        int sum = 0;
        for (Map.Entry<String, List<Product>> entry : productsBasket.entrySet()) {
            List<Product> valueList = entry.getValue();
            for (Product product : valueList) {
                if (product != null) {
                    sum = sum + product.getProductPrice();
                }
            }
        }
        return sum;
    }

    public static void printBasketContent() {
        int count = 0;
        int specialProductsCount = 0;
        List<Product> newList = new LinkedList<>();
        for (Map.Entry<String, List<Product>> entry : productsBasket.entrySet()) {
            List<Product> value = entry.getValue();
            for (Product product : value) {
                if (product != null) {
                    newList.add(product);
                    if (product.isSpecial()) {
                        specialProductsCount++;
                    }
                    count++;
                }
            }
        }
        System.out.println(newList);
        if (count == 0) {
            System.out.println("В корзине пусто");
        }
        System.out.println("------------------------------\nИтого: " + getBasketCost());
        System.out.println("Специальных товаров: " + specialProductsCount);
    }

    public static boolean isProductOnBasket(String productName) {
        List<Product> productsList = productsBasket.getOrDefault(productName, new ArrayList<>());
        for (Product product : productsList) {
            if (product.getProductName().contains(productName)) {
                return true;
            }
        }
        return false;
    }

    public static void cleanBasket() {
        productsBasket.clear();
    }
}

