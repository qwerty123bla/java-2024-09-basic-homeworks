package ru.otus.homework.hw2;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        printString("print me", 5);
        sumArrMoreThanFive(new int []{9, 8, 0, 1, 2, 3, 4, 5, 6, 7});
        setNumberToArr(5, new int[10]);
        addNumToArrItems(3, new int[] {7, 1, 2, 3, 4, 5});
        witchPartBigger(new int[] {1, 2, 3, 4, 5, 6});

        arrSum(new int[] {1, 1, 1}, new int[] {2, 2}, new int[] {3, 3, 3, 3});
        showSumMiddlePoint(new int[] {2, 4, 1, 1, 2, 1, 1});
        isSorted(new int[] {2, 3, 5, 9}, false);  // isDesc = ture сортировка в порядке убывания
        reverse(new int[] {1, 2, 3, 4, 5, 6});
    }

    public static void printString(String str, int count) {
        System.out.println("1. printString");
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    public static void sumArrMoreThanFive(int[] arr) {
        System.out.println("2. sumArrMoreThanFive");
        int sum = 0;
        for (int j : arr) {
            sum = sum + ((j > 5) ? j : 0);
        }

        System.out.println("Исходный массив: " + Arrays.toString(arr));
        System.out.println("Сумма: " + sum);
    }

    public static void setNumberToArr(int num, int[] arr) {
        System.out.println("3. setNumberToArr");
        System.out.println("Исходный массив " + Arrays.toString(arr) + " Нужно заполнить все элементы массива чилом " + num);
        for (int i = 0; i < arr.length; i++) arr[i] = num;

        System.out.println("После обновления " + Arrays.toString(arr));
    }

    public static void addNumToArrItems(int num, int[] arr) {
        System.out.println("4. addNumToArrItems");
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        System.out.println("Требуется к каждому элементу массива добавить число " + num);

        for (int i = 0; i < arr.length; i++) {
            arr[i] += num;
        }

        System.out.println("Массив после обновления: " + Arrays.toString(arr));
    }

    public static void witchPartBigger(int[] arr) {
        System.out.println("5. witchPartBigger");
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        int middle = arr.length / 2;
        System.out.println("Середина массива позиция - " + middle);

        int sumLeft = 0;
        System.out.print("Левая часть массива: ");
        for (int i = 0; i < middle; i++) {
            System.out.print(arr[i] + " ");
            sumLeft += arr[i];
        }
        System.out.print("Сумма элементов = " + sumLeft + "\n");

        int sumRight = 0;
        System.out.print("Правая часть массива: ");
        for (int i = middle; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            sumRight += arr[i];
        }
        System.out.print("Сумма элементов = " + sumRight + "\n");

        if (sumLeft > sumRight) {
            System.out.println("Сумма левых элементов массива больше суммы правых");
        }
        else if(sumLeft < sumRight) {
            System.out.println("Сумма правых элементов массива больше суммы левых");
        }
        else {
            System.out.println("Суммы левых и правых элементов массива равны");
        }
    }

    public static void arrSum(int[]... arrs) {
        System.out.println("*1. arrSum");
        System.out.println("Переданные массивы: ");
        // переданные массивы
        for (int[] arr : arrs) {
            System.out.println(Arrays.toString(arr));
        }

        int newArrLength = 0;
        // выясняем длинну нового массива
        for (int i = 0; i < arrs.length; i++) {
            if (newArrLength < arrs[i].length) {
                newArrLength = arrs[i].length;
            }
        }

        int [] newArr = new int[newArrLength];

        // Заполняем новый массив суммами переданных
        for (int i = 0; i < arrs.length; i++) {
            for(int j = 0; j < arrs[i].length; j++) {
                newArr[j] += arrs[i][j];
            }
        }

        System.out.println("Результат сложения массивов" + Arrays.toString(newArr));
    }

    public static void showSumMiddlePoint(int [] arr) {
        System.out.println("*2. showSumMiddlePoint");

        int sumLeft = 0;

        for (int i = 0; i < arr.length; i++) {
            int sumRight = 0;
            sumLeft += arr[i];
            System.out.print(arr[i] + " ");

            for(int j = i + 1; j < arr.length; j++) {
                sumRight += arr[j];
            }

            if (sumLeft == sumRight) {
                System.out.print("| ");

                for(int j = i + 1; j < arr.length; j++) {
                    System.out.print(arr[j] + " ");
                }
                break;
            }
        }

        System.out.println();
    }

    public static void isSorted(int [] arr, boolean isDesc) {
        System.out.println("*3. isSorted");
        boolean isSorted = true;
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        for(int i = 0; i < arr.length - 1; i++) {
            if (isDesc) {
                // если должен быть отсортирован в порядке убывания
                if (arr[i] < arr[i+1]) {
                    isSorted = false;
                    break;
                }
            }
            else {
                // если должен быть отсортирован в порядке возрастания
                if (arr[i] > arr[i+1]) {
                    isSorted = false;
                    break;
                }
            }
        }

        System.out.println("Массив " + ((isSorted) ? "отсортирован " : "не отсортирован ") + "в порядке " + ((isDesc) ? "убывания " : "возрастания") + "\n");
    }

    public static void reverse(int [] arr) {
        System.out.println("*4. reverse");
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        System.out.print("Перевернутый массив: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[arr.length - (i + 1)] + " ");
        }
    }
}
