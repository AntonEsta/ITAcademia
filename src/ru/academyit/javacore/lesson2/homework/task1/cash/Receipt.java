package ru.academyit.javacore.lesson2.homework.task1.cash;

import ru.academyit.javacore.lesson2.homework.task1.product.Product;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Класс чека. Включает в себя товарные позиции.
 */
public class Receipt {

    private final Set<Position> positions = new HashSet<>();

    public List<Position> getPositions() {
        return positions.stream().toList();
    }

    public void addPosition(Product product, double quantity) {
        addPosition(new Position(product, quantity));
    }

    /**
     * Добавляет позицию в чек.
     *
     * @param position позиция.
     */
    public void addPosition(Position position) {
        this.positions.add(position);
    }

    /**
     * Заменяет товар в чеке.
     *
     * @param product     товар для замены
     * @param productDisc товар на который нужно заменить
     */
    public void replacePosition(Product product, Product productDisc) {
        this.positions.stream()
                .filter(p -> p.getProduct().equals(product))
                .forEach(p -> p.setProduct(productDisc));
    }
}
