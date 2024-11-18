package ru.otus.homework.hw7;

public class AllTerrain implements Transport{
    int petrol;

    public AllTerrain(int petrol) {
        this.petrol = petrol;
    }

    @Override
    public boolean run(Locations location, int duration) {
        if (this.petrol >= duration) {
            this.petrol -= duration;
            System.out.println("Проехали на вездеходе " + duration + " осталось бензина - " + this.petrol);
            return true;
        }
        else {
            System.out.println("Недостаточно бензина для перемещения на дистанцию " + duration + " осталось всего " + this.petrol);
            return false;
        }
    }
}
