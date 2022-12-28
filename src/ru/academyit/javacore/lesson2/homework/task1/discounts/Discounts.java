package ru.academyit.javacore.lesson2.homework.task1.discounts;

import ru.academyit.javacore.lesson2.homework.task1.product.Product;

import java.util.*;

public final class Discounts {

    private final static Map<Product, List<Discounter>> productMap = new HashMap<>();
    private static Discounts instance;

    private Discounts(){
    }

    public static synchronized Discounts getInstance() {
        if (instance == null) {
            instance = new Discounts();
        }
        return instance;
    }

    public List<Discounter> getAllApplyDiscounts(Product product) {
        System.out.println("getAllApplyDiscounts: " + productMap.get(product).stream().filter(d -> d.isApply(product)).count());
        return productMap.get(product).stream().filter(d -> d.isApply(product)).toList();
    }

    public void addProductDiscount(Product product, Discounter discount) {
        if (productMap.containsKey(product)) {
            if (!productMap.get(product).contains(discount)) {
                productMap.get(product).add(discount);
            }
        } else {
            productMap.put(product, Arrays.asList(discount));
        }
        
    }
    
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
