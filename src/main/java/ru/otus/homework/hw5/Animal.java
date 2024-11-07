package ru.otus.homework.hw5;

public abstract class Animal {
    protected String name;
    protected int runSpeed;
    protected int swimSpeed;
    protected int endurance;

    Animal(String name, int runSpeed, int swimSpeed, int endurance) {
        this.name = name;
        this.runSpeed = runSpeed;
        this.swimSpeed = swimSpeed;
        this.endurance = endurance;
    }

    protected float action(int distance, int cost, int speed) {
        System.out.println("Выносливость до действия :" + this.endurance);

        if (this.endurance < distance * cost) {
            this.endurance = 0;
            System.out.println("Выносливость после действия :" + this.endurance);
            return -1;
        }
        else {
            this.endurance = this.endurance - distance * cost;
            System.out.println("Выносливость после действия :" + this.endurance);
            return (float)distance / speed;
        }
    }

    public float run(int distance) {
        System.out.println(this.name + " нужно пробежать " + distance + " метров");
        return action(distance, 1, this.runSpeed);
    }

    public abstract float swim(int distance);

    public void info() {
        System.out.println(this.name + " " + (((this.endurance) == 0) ? "Устал" : "Полон сил"));
    }
}
