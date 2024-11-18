package ru.otus.homework.hw7;

public class Car implements Transport{
    int petrol;

    public Car(int petrol) {
        this.petrol = petrol;
    }

    @Override
    public boolean run(Locations location, int duration) {
        if(location == Locations.FOREST || location == Locations.SWAMP) {
            System.out.println("Машина не может перемещаться по этому типу местности - " + location.getDescription());
            return false;
        }

        if (this.petrol >= duration) {
            this.petrol -= duration;
            System.out.println("Проехали на машине " + duration + " осталось бензина - " + this.petrol);
            return true;
        }
        else {
            System.out.println("Недостаточно бензина для перемещения на дистанцию " + duration + " осталось всего " + this.petrol);
            return false;
        }
    }
}
