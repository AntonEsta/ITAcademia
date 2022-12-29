package ru.academyit.javacore.lesson2.homework.task1.discounts;

import ru.academyit.javacore.lesson2.homework.task1.product.Product;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс хранит связь товаров и скидок применяемых к ним.
 */
public final class Discounts {

    private final static Map<Product, List<Discounter>> productMap = new HashMap<>();
    private static Discounts instance;

    private Discounts() {
    }

    /**
     * Возвращает экземпляр класса
     *
     * @return экземпляр класса
     */
    public static synchronized Discounts getInstance() {
        if (instance == null) {
            instance = new Discounts();
        }
        return instance;
    }

    /**
     * Возвращает все скидки которые могут быть применены в товару.
     *
     * @param product товар на которые предположительно имеются скидки.
     * @return Лист скидок предоставленные для указанного товара.
     */
    public List<Discounter> getAllApplyDiscounts(Product product) {
        return productMap.get(product).stream().filter(d -> d.isApply(product)).toList();
    }

    /**
     * Добавить скидку для товара.
     *
     * @param product  указание товар к которому будет применяться скидка.
     * @param discount Скидка применяемая к товару.
     */
    public void addProductDiscount(Product product, Discounter discount) {
        if (productMap.containsKey(product)) {
            if (!productMap.get(product).contains(discount)) {
                productMap.get(product).add(discount);
            }
        } else {
            productMap.put(product, Collections.singletonList(discount));
        }

    }

    /**
     * Возвращает продукт с примененными к нему скидками.
     *
     * @param product товар для скидки
     * @return товар с примененными скидками.
     */
    public Product getProductWithDiscounts(Product product) {

        Product productWithDiscounts = product.clone();

        if (productMap.containsKey(product)) {
            for (Discounter d :
                    productMap.get(product)) {
                productWithDiscounts = d.apply(productWithDiscounts);
            }
        }

        return productWithDiscounts;

    }

}
