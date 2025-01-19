package ru.otus.homework.hw19;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit>{
    private List<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public void add(T fruit) {
        this.list.add(fruit);
    }

    public int weight() {
        return this.list.stream().map(Fruit::getWeight).reduce(0, Integer::sum);
    }

    public boolean ccompare(Box<? extends Fruit> box) {
        if (this.weight() == box.weight()) {
            return true;
        }

        return false;
    }

    public void move(Box<T> box) {
        if (!this.list.isEmpty()) {
            box.add(this.list.get(0));
            this.list.remove(0);
        }
    }
}
