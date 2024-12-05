package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product product1 = new Product("Апельсин", 115);        // создание продуктов
        Product product2 = new Product("Яблоко", 80);
        Product product3 = new Product("Манго", 500);
        Product product4 = new Product("Киви", 180);
        Product product5 = new Product("Арбуз", 50);
        Product product6 = new Product("Банан", 130);


        // 1. Добавление продукта в корзину.

        System.out.println("1. Добавление продукта в корзину.");

        ProductBasket.addProduct(product1);
        ProductBasket.addProduct(product2);
        ProductBasket.addProduct(product3);
        ProductBasket.addProduct(product4);
        ProductBasket.addProduct(product5);

        // 2. Добавление продукта в заполненную корзину, в которой нет свободного места.
        System.out.println("2. Добавление продукта в заполненную корзину, в которой нет свободного места.");

        ProductBasket.addProduct(product6);

        System.out.println();

        // 3. Печать содержимого корзины с несколькими товарами.

        System.out.println("3. Печать содержимого корзины с несколькими товарами.");
        ProductBasket.printBasketContent();


        // 4. Получение стоимости корзины с несколькими товарами.

        System.out.println("\n4. Получение стоимости корзины с несколькими товарами " + ProductBasket.getBasketCost());

        // 5. Поиск товара, который есть в корзине.

        System.out.println("\n5. Поиск товара " + product1.getProductName() + ", который есть в корзине: " +
                ProductBasket.isProductOnBasket(product1.getProductName()));

        // 6. Поиск товара, которого нет в корзине.
        System.out.println("\nПоиск товара " + product6.getProductName() + ", которого нет в корзине: " +
                ProductBasket.isProductOnBasket(product6.getProductName()));

        // 7. Очистка корзины.

        System.out.println("\n7. Очистка корзины.");

        ProductBasket.cleanBasket();

        // 8. Печать содержимого пустой корзины.

        System.out.println("\n8. Печать содержимого пустой корзины.");
        ProductBasket.printBasketContent();

        // 9. Получение стоимости пустой корзины.

        System.out.println("\n9. Получение стоимости пустой корзины: " + ProductBasket.getBasketCost());

        // 10. Поиск товара по имени в пустой корзине.

        System.out.println("\n10. Поиск товара по имени в пустой корзине: " + ProductBasket.isProductOnBasket(product1.getProductName()));

    }
}
