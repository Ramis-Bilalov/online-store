package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;

import java.util.List;

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

        SearchEngine searchEngine = new SearchEngine();

        Article article1 = new Article("Корейские автомобили", "KIA, HYUNDAI, GENESIS, SSANGYONG");
        Article article2 = new Article("Немецкие автомобили", "VW, AUDI, SKODA, BMW, MERCEDES");
        Article article3 = new Article("Японские автомобили", "Toyota, Mazda, Lexus");

        searchEngine.addNewSearchable(product1);
        searchEngine.addNewSearchable(product2);


        searchEngine.addNewSearchable(article1);
        searchEngine.addNewSearchable(article2);
        searchEngine.addNewSearchable(article3);

        System.out.println(searchEngine.getSearchSet("VW"));


        try {
            DiscountedProduct discountedProduct = new DiscountedProduct(" ", 15000, 20);
            SimpleProduct simpleProduct = new SimpleProduct(" ", 10000);
        } catch (IllegalArgumentException i) {
            i.printStackTrace();
        }
        System.out.println("Проверка завершена 1");


        try {
            System.out.println("searchEngine.getSearchTerm(\"V1\") = " + searchEngine.getSearchTerm("V1"));
        } catch (BestResultNotFound e) {
            e.printStackTrace();
        }

        System.out.println("Проверка завершена 2");

        try {
            System.out.println("searchEngine.getSearchTerm(\"VW\") = " + searchEngine.getSearchTerm("VW"));
        } catch (BestResultNotFound e) {
            e.printStackTrace();
        }

        System.out.println("Проверка завершена 3\n");

        // Удаление продукта по имени в корзине

        System.out.println("Удаление продукта по имени в корзине\n");

        System.out.println("Вывод списка удаленных продуктов");
        List<Product> productList = ProductBasket.removeProductsByName("Апельсин");
        System.out.println(productList);


        System.out.println("\nУдаление несуществующего продукта по имени в корзине");
        ProductBasket.removeProductsByName("Парта");

        System.out.println("\nВывести содержимое корзины");
        ProductBasket.printBasketContent();

        // Проверка методов класса SearchEngine

        System.out.println(searchEngine.getSearchSet("VW"));

        try {
            System.out.println("searchEngine.getSearchTerm(\"V1\") = " + searchEngine.getSearchTerm("V1"));
        } catch (BestResultNotFound e) {
            e.printStackTrace();
        }

        System.out.println("Проверка завершена 2");

        try {
            System.out.println("searchEngine.getSearchTerm(\"VW\") = " + searchEngine.getSearchTerm("VW"));
        } catch (BestResultNotFound e) {
            e.printStackTrace();
        }


        System.out.println("\n\n\n\n\n");

        Article articleTest1 = new Article("BMW", "For the joy of motoring");
        Article articleTest2 = new Article("Tesla", "Move fast and break things.");
        Article articleTest3 = new Article("Toyota", "Always a better way");
        Article articleTest4 = new Article("Audi", "Audi and BMW are strong competitors");

        SearchEngine searchEngine1 = new SearchEngine();

        searchEngine1.addNewSearchable(articleTest1);
        searchEngine1.addNewSearchable(articleTest2);
        searchEngine1.addNewSearchable(articleTest3);
        searchEngine1.addNewSearchable(articleTest4);

        System.out.println("searchEngine1.getSearchArray() = \n" + searchEngine1.getSearchSet("BMW"));



    }
}
