package test;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Integer[] arr1 = generateRandomArray();
        Integer[] arr2 = arr1.clone();
        Integer[] arr3 = arr1.clone();

        long start = System.currentTimeMillis();
        sortBubble(arr1);
        System.out.println("Пузырьковая сортировка. Затраченное время - " + (System.currentTimeMillis() - start));

        long start2 = System.currentTimeMillis();
        sortSelection = (arr2);
        System.out.println("Сортировка выбором. Затраченное время - " + (System.currentTimeMillis() - start2));

        long start3 = System.currentTimeMillis();
        sortInsertion = (arr3);
        System.out.println("Сортировка вставками. Затраченное время - " + (System.currentTimeMillis() - start3));

    }

    public static Integer[] generateRandomArray() {
        Random random = new Random();
        Integer[] arr = new Integer[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100000) + 100000;
        }
        return arr;

    }

    private static void sortBubble(Integer[] arr1) {
        for (int i = 0; i < arr.lenght-1; i++) {


        }
    }

