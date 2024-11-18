package ru.otus.homework.hw7;

public interface Transport {
    public boolean run(Locations location, int duration);
    public default String getType() {
        return this.getClass().getSimpleName();
    }
}
