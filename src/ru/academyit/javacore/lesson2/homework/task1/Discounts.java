package ru.academyit.javacore.lesson2.homework.task1;

import ru.academyit.javacore.lesson2.homework.task1.product.Product;

import java.util.*;

public final class Discounts {

    private final Map<Product, List<Discount>> productMap;
    private static Discounts instance;

    private Discounts(){
        this.productMap = new HashMap<>();
    }

    public static synchronized Discounts getInstance() {
        if (instance == null) {
            instance = new Discounts();
        }
        return instance;
    }

    public void addProductDiscount(Product product, Discount discount) {

        if (this.productMap.containsKey(product)) {
            if (!this.productMap.get(product).contains(discount)) {
                this.productMap.get(product).add(discount);
            }
        } else {
            this.productMap.put(product, Arrays.asList(discount));
        }
        
    }
    
    public Product getProductWithDiscounts(Product product) {
        
        Product productWithDiscounts = product.clone();

        if (this.productMap.containsKey(product)) {
            for (Discount d :
                    this.productMap.get(product)) {
                productWithDiscounts = d.apply(productWithDiscounts);
            }
        }

        return productWithDiscounts;
        
    }



}
