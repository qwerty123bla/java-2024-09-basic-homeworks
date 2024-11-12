package ru.otus.homework.hw6;

public class Plate {
    private int maxVolume;
    private int currentVolume;

    public Plate(int volume) {
        this.currentVolume = volume;
        this.maxVolume = volume;
        System.out.println("*** Создали тарелку, объём - " + this.currentVolume + " единиц еды");
    }

    public void add(int volume) {
        this.currentVolume = Math.min(this.currentVolume + volume, this.maxVolume);
        System.out.println("*** Добавили в тарелку " + volume + " единиц еды");
    }

    public boolean remove(int volume) {
        if (this.currentVolume - volume >= 0) {
            this.currentVolume -= volume;
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "*** Объём тарелки " + maxVolume +
                " сейчас в тарелке " + currentVolume +
                " единиц еды";
    }
}
