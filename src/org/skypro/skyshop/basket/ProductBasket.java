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
        List<Product> productsList = productsBasket.values().stream().flatMap(Collection::stream)
                .filter(product -> product.getProductName().contains(name))
                .toList();

        if (isProductOnBasket(name)) {
            productsBasket.remove(name);
        }

        return productsList;
    }

    public static int getBasketCost() {
        return productsBasket.values().stream().flatMap(Collection::stream)
                .mapToInt(Product::getProductPrice)
                .sum();
    }

    public static void printBasketContent() {
        productsBasket.forEach((s, products) -> System.out.println(s + products));
        System.out.println("Итого: " + getBasketCost());
        System.out.println("Специальных товаров: " + getSpecialCount());
    }

    private static long getSpecialCount() {
        return productsBasket.values().stream().flatMap(Collection::stream)
                .filter(Product::isSpecial).count();
    }

    public static boolean isProductOnBasket(String productName) {
        return productsBasket.values().stream().flatMap(Collection::stream)
                .anyMatch(product -> product.getProductName().contains(productName));
    }

    public static void cleanBasket() {
        productsBasket.clear();
    }
}

