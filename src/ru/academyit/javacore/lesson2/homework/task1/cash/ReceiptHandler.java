package ru.academyit.javacore.lesson2.homework.task1.cash;

public class ReceiptHandler {

    public static double totalCost(Receipt receipt) {
        return receipt.getPositions().stream()
                .mapToDouble((e) -> e.getProduct().getCost() * e.getQuantity())
                .sum();
    }

}
