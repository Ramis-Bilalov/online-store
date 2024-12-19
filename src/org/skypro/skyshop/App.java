package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        SimpleProduct product1 = new SimpleProduct("Апельсин", 115);        // создание продуктов
        DiscountedProduct product2 = new DiscountedProduct("Яблоко", 80, 15);
        SimpleProduct product3 = new SimpleProduct("Манго", 500);
        FixPriceProduct product4 = new FixPriceProduct("Киви");
        SimpleProduct product5 = new SimpleProduct("Арбуз", 50);
        SimpleProduct product6 = new SimpleProduct("Банан", 130);


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

        System.out.println("\n5. Поиск товара " + product2.getProductName() + ", который есть в корзине: " +
                ProductBasket.isProductOnBasket(product2.getProductName()));

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

        System.out.println("\n10. Поиск товара по имени в пустой корзине: " + ProductBasket.isProductOnBasket(product2.getProductName()));


        System.out.println("\nООП. Полиморфизм. Интерфейсы");

        SearchEngine searchEngine = new SearchEngine(5);

        Article article1 = new Article("Корейские автомобили", "KIA, HYUNDAI, GENESIS, SSANGYONG");
        Article article2 = new Article("Немецкие автомобили", "VW, AUDI, SKODA, BMW, MERCEDES");
        Article article3 = new Article("Японские автомобили", "Toyota, Mazda, Lexus");

        searchEngine.addNewSearchable(product1);
        searchEngine.addNewSearchable(product2);



        searchEngine.addNewSearchable(article1);
        searchEngine.addNewSearchable(article2);
        searchEngine.addNewSearchable(article3);

        System.out.println(Arrays.toString(searchEngine.getSearchArray("KIA")));

    }
}
