package ru.otus.homework.hw11;

public enum Position {
    MANAGER(true),
    DIRECTOR(true),
    DRIVER(false),
    ENGINEER(false),
    SENIOR_MANAGER(true),
    DEVELOPER(false),
    QA(false),
    JANITOR(false),
    PLUMBER(false),
    BRANCH_DIRECTOR(true),
    JUNIOR_DEVELOPER(false);

    private boolean isManager;

    private Position(boolean isManager) {
        this.isManager = isManager;
    }

    public boolean isManager() {
        return this.isManager;
    }
}
