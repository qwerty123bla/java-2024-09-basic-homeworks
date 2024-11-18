package ru.otus.homework.hw7;

public enum Locations {
    FOREST("Густой лес"),
    PLANE("Равнина"),
    SWAMP("Болото");

    private String description;

    private Locations(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
