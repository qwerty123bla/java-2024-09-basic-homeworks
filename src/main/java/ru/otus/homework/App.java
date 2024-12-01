package ru.otus.homework;

import ru.otus.homework.hw9.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // 1
        List<Integer> list = fillList(3, 9);
        System.out.println("* 1");
        System.out.println(list);

        // 2
        List<Integer> sum = new ArrayList<>();
        Collections.addAll(sum, 1, 3, 4, 5, 7, 2, 9);
        System.out.println("* 2\nИсходынй массив: " + sum);
        System.out.println("Сумма элементов > 5: " + sum(sum));

        // 3
        List<Integer> overwrite = new ArrayList<>();
        Collections.addAll(overwrite, 1, 3, 4, 5, 7, 2, 9);
        System.out.println("* 3\nИсходынй массив: " + overwrite);
        overwrite(overwrite, 2);
        System.out.println("Массив после перезаписи: " + overwrite);

        // 4
        List<Integer> addValue = new ArrayList<>();
        Collections.addAll(addValue, 1, 3, 4, 5, 7, 2, 9);
        System.out.println("* 4\nИсходынй массив: " + addValue);
        addValue(addValue, 2);
        System.out.println("Массив после перезаписи: " + addValue);

        // 5
        List<Employee> empolyees = new ArrayList<>();
        Collections.addAll(empolyees, new Employee("Андрей", 25), new Employee("Дмитрий", 40), new Employee("Сергей", 30));
        System.out.println("* 5\nМассив сотрудников: " + empolyees);
        List<String> names = getNames(empolyees);
        System.out.println("Имена: " + names);

        // 6
        System.out.println("* 6\nМассив сотрудников: " + empolyees);
        checkEmployeeByAge(empolyees, 30);

        // 7
        Employee e =  yangestEmployee(empolyees);
        System.out.println("* 7\nМассив сотрудников: " + empolyees);
        System.out.println("Самый молодой сотрудник: " + e);
    }

    /* 1
    Реализуйте метод, принимающий в качестве аргументов числа min и max, и возвращающий ArrayList с набором последовательных значений в указанном диапазоне
    (min и max включительно, шаг - 1);
     */
    public static List<Integer> fillList(int min, int max) {
        List<Integer> list = new ArrayList<>();
        int value = min;
        for (int i = min; i <= max; i++) {
            list.add(value);
            value++;
        }

        return list;
    }

    /* 2
    Реализуйте метод, принимающий в качестве аргумента список целых чисел, суммирующий все элементы, значение которых больше 5, и возвращающий сумму;
     */
    public static int sum(List<Integer> list) {
        int sum = 0;
        for(Integer e: list) {
            if (e > 5) sum += e;
        }

        return sum;
    }

    /* 3
    Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список, метод должен переписать каждую заполненную ячейку списка указанным числом;
     */
    public static void overwrite(List<Integer> list, int value) {
        for(int i = 0; i < list.size(); i++) {
            list.set(i, value);
        }
    }

    /* 4
    Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список, увеличивающий каждый элемент списка на указанное число;
     */
    public static void addValue(List<Integer> list, int value) {
        list.replaceAll(integer -> integer + value);
    }

    /* 5
    Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий список их имен;
     */
    public static List<String> getNames(List<Employee> empolyees) {
        List<String> names = new ArrayList<>();

        for(Employee e: empolyees) {
            names.add(e.getName());
        }

        return names;
    }

    /* 6
    Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный средний возраст,
    и проверяющий что средний возраст сотрудников превышает указанный аргумент;
     */
    public static void checkEmployeeByAge(List<Employee> empolyees, int minAge) {
        int ageSum = 0;

        for(Employee e: empolyees) {
            ageSum += e.getAge();
        }

        if (ageSum / empolyees.size() > minAge)
            System.out.println("Средний возраст сотрудников превышает - " + minAge);
        else
            System.out.println("Средний возраст сотрудников не  превышает - " + minAge);
    }

    /* 7
    Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий ссылку на самого молодого сотрудника.
     */
    public static Employee yangestEmployee(List<Employee> empolyees) {
        Employee employee = empolyees.get(0);

        for(Employee e: empolyees) {
            if (employee.getAge() > e.getAge())
                employee = e;
        }

        return employee;
    }
}
