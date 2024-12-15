package ru.otus.homework;

public class App {
    public static void main(String[] args) {
        System.out.println("Привет");

        String str = "2.4 345 -";
        int spaceIndex1 = str.indexOf(' ');
        System.out.println(spaceIndex1);
        double val1 = Double.parseDouble(str.substring(0, spaceIndex1));
        int spaceIndex2 = str.indexOf(' ', spaceIndex1 + 1);
        System.out.println(spaceIndex2);
        double val2 = Double.parseDouble( str.substring(spaceIndex1, spaceIndex2));
        String operator = str.substring(spaceIndex2 + 1);


        System.out.println(operator.equals("+") + " |" + operator + "|");
    }
}
