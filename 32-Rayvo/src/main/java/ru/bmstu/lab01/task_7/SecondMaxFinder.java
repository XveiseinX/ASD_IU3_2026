package ru.bmstu.lab01.task_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Задача 7. Второй максимум.
 *
 * <p>Находит второй по величине элемент массива за один линейный проход.
 * Все элементы массива различны, поэтому второй максимум — это
 * наибольший элемент, строго меньший максимума.
 */
public class SecondMaxFinder {

    /**
     * Возвращает второй по величине элемент массива.
     *
     * <p>Массив должен содержать хотя бы два элемента. Если массив
     * {@code null} или содержит менее двух элементов, выбрасывается
     * {@link IllegalArgumentException}.
     *
     * @param array входной массив целых чисел (элементы различны)
     * @return второй по величине элемент
     * @throws IllegalArgumentException если массив {@code null} или
     *         содержит менее двух элементов
     */
    public static int findSecondMax(int[] array) {
        if (array == null || array.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements");
        }

        int max;
        int secondMax;

        if (array[0] > array[1]) {
            max = array[0];
            secondMax = array[1];
        } else {
            max = array[1];
            secondMax = array[0];
        }

        for (int i = 2; i < array.length; i++) {
            if (array[i] > max) {
                secondMax = max;
                max = array[i];
            } else if (array[i] > secondMax) {
                secondMax = array[i];
            }
        }

        return secondMax;
    }

    /**
     * Точка входа для запуска из командной строки.
     *
     * <p>Ожидает строку вида: {@code n a1 a2 ... an}.
     * Выводит второй по величине элемент.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] p = br.readLine().trim().split("\\s+");
            int n = Integer.parseInt(p[0]);

            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(p[i + 1]);
            }

            System.out.println(findSecondMax(array));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}