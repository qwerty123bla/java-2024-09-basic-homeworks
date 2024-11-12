package ru.otus.homework.hw6;

public class Cat {
    private int portion;
    private String name;
    private boolean isWellFed;

    public Cat(String name, int portion) {
        this.name = name;
        this.portion = portion;
        this.isWellFed = false;
    }

    @Override
    public String toString() {
        return this.name + " " + (this.isWellFed ? "сыт": "голоден");
    }

    public void eat(Plate plate) {
        if (!isWellFed) {
            System.out.println(this.name + " идёт кушать");

            if (plate.remove(this.portion)) {
                this.isWellFed = true;
                System.out.println(this.name + " съел " + this.portion + " единиц еды");
            }
            else {
                System.out.println(this.name + " слишком мало еды");
            }

            System.out.println("-------------------------");
        }

    }
}
