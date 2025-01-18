package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
//    static List<Product> products = new LinkedList<>();

    public static String default_name = "USER";
    static List<Product> productList = new LinkedList<>();
    static Map<String, List<Product>> productsBasket = new LinkedHashMap<>();

    public static void addProduct(Product product) {
        if (product != null) {
            productList.add(product);
            productsBasket.put(default_name, productList);
        }
    }

    public static List<Product> removeProductsByName(String name) {
        List<Product> productsList = new LinkedList<>();
        if(productList != null) {
            Iterator<Product> iterator = productList.iterator();
            while (iterator.hasNext()) {
                Product product = iterator.next();
                if (product.getProductName().equals(name)) {
                    productsList.add(product);
                    iterator.remove();
                }
            }
        }
        if (productsList.size() == 0) {
            System.out.println("---Список пуст");
        }
        return productsList;
    }

    public static int getBasketCost() {
        int sum = 0;
        if (productList != null) {
            for (Product product : productList) {
                sum = sum + product.getProductPrice();
            }
        }
        return sum;
    }

    public static void printBasketContent() {
        int count = 0;
        int specialProductsCount = 0;
        if (productList != null) {
            for (Product product : productList) {
                if (product != null) {
                    if (product.isSpecial()) {
                        specialProductsCount++;
                    }
                    count++;
                    System.out.println(product);
                }
            }
        }
        if (count == 0) {
            System.out.println("В корзине пусто");
        }
        System.out.println("------------------------------\nИтого: " + getBasketCost());
        System.out.println("Специальных товаров: " + specialProductsCount);
    }

    public static boolean isProductOnBasket(String productName) {
        if (productList != null) {
            for (Product product : productList) {
                if (product != null && product.getProductName().equals(productName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void cleanBasket() {
        productList = null;
    }
}

