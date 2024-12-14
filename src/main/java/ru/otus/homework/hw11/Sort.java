package ru.otus.homework.hw11;

import java.util.Arrays;

public class Sort {
    public static void replaceElement(int array[], int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void quickSort(int array[], int start, int end) {
        if (start < end) {
            // получаем середину заданного отрезка массива
            int middle = start + (int)Math.floor((end - start) / 2f);

            int[] tmp_arr = Arrays.copyOfRange(array, start, end);
            int middleVal = (int)Math.floor(Arrays.stream(Arrays.stream(tmp_arr).toArray()).average().getAsDouble());

            for(int i = start; i <= end; i++) {
                for(int j = end; j >= start; j--) {
                    if (array[i] >= middleVal && array[j] <= middleVal) {
                        replaceElement(array, i, j);
                    }
                    if (i >= j) break;
                }
            }

            //System.out.println(middle + " " + start + " " + end + " " + Arrays.toString(array));

            if (end - start > 1) {
                quickSort(array, start, middle);
                quickSort(array, middle, end);
            }
        }
    }

    public static void bubbleSort(int array[]) {
        int length = array.length - 1;
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length - i; j++) {
                if (array[j] > array[j + 1]) {
                    replaceElement(array, j, j + 1);
                }
            }
            //System.out.println(i + " " +( array.length - 1 - i) + " " +" " + Arrays.toString(array));
        }
    }
}
