package ru.otus.homework.hw7;

public class Horse implements Transport {
    int endurance;

    public Horse(int endurance) {
        this.endurance = endurance;
    }

    @Override
    public boolean run(Locations location, int duration) {
        if(location == Locations.SWAMP) {
            System.out.println("Лошадь не может перемещаться по этому типу местности - " + location.getDescription());
            return false;
        }

        if (this.endurance >= duration) {
            this.endurance -= duration;
            System.out.println("Проехали на лошади " + duration + " осталось значение выносливости - " + this.endurance);
            return true;
        }
        else {
            System.out.println("Недостаточно сил для перемещения на дистанцию "  + duration + " осталось всего " + this.endurance);
            return false;
        }
    }
}
