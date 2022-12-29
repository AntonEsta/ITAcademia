package ru.academyit.javacore.lesson2.homework.task1.cash;

/**
 * Класс для обработки чеков.
 */
public class ReceiptHandler {

    /**
     * Вычисляет общую стоимость товаров по чеку.
     *
     * @param receipt чек для обработки
     * @return стоимость всех позиций в чеке
     */
    public static double totalCost(Receipt receipt) {
        return receipt.getPositions().stream()
                .mapToDouble((e) -> e.getProduct().getCost() * e.getQuantity())
                .sum();
    }

}
