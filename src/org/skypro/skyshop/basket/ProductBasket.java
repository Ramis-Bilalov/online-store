package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {

    //    static Product[] products = new Product[5];
    static List<Product> products = new LinkedList<>();

    public static void addProduct(Product product) {
        if (product != null) {
            products.add(product);
        }
    }

    public static List<Product> removeProductsByName(String name) {
        List<Product> productList = new LinkedList<>();
        if(products != null) {
            Iterator<Product> iterator = products.iterator();
            while (iterator.hasNext()) {
                Product product = iterator.next();
                if (product.getProductName().equals(name)) {
                    productList.add(product);
                    iterator.remove();
                }
            }
        }
        if (productList.size() == 0) {
            System.out.println("---Список пуст");
        }
        return productList;
    }

    public static int getBasketCost() {
        int sum = 0;
        if (products != null) {
            for (Product product : products) {
                sum = sum + product.getProductPrice();
            }
        }
        return sum;
    }

    public static void printBasketContent() {
        int count = 0;
        int specialProductsCount = 0;
        if (products != null) {
            for (Product product : products) {
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
        if (products != null) {
            for (Product product : products) {
                if (product != null && product.getProductName().equals(productName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void cleanBasket() {
        products = null;
    }
}

