package ru.academyit.javacore.lesson2.homework.task1.cash;

import java.util.ArrayList;
import java.util.List;

public class Receipt {

    private List<Position> positionList = new ArrayList<>();

    public List<Position> getPositions() {
        return positionList;
    }

    public void addPosition(Position position) {
        this.positionList.add(position);
    }

    public double totalCost() {
        return this.positionList.stream().mapToDouble((e) -> e.getProduct().getCost()).sum();
    }

}
