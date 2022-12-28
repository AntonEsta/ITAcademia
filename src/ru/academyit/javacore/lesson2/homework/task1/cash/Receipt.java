package ru.academyit.javacore.lesson2.homework.task1.cash;

import ru.academyit.javacore.lesson2.homework.task1.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Receipt {

    private final List<Position> positionList = new ArrayList<>();

    public List<Position> getPositions() {
        return positionList;
    }

    public Position getPositionByProduct(Product product) {
        return this.positionList.stream()
                .filter(p -> p.getProduct().equals(product))
                .findFirst().get();
    }

    public void addPosition(Position position) {
        this.positionList.add(position);
    }

    public double totalCost() {
        return this.positionList.stream().mapToDouble((e) -> e.getProduct().getCost()).sum();
    }

    public void replacePosition(Product product, Product productDisc) {
        if (this.positionList.contains(product)) {
            this.positionList.get(positionList.indexOf(product)).setProduct(productDisc);
        }

        //        if (this.positionList.stream().anyMatch(p -> p.getProduct().equals(product))) {
//            this.positionList.get(positionList.indexOf(product)).setProduct(productDisc);
//        }
    }
}
