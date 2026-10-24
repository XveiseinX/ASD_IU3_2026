package ru.bmstu.lab01.task_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Задача 11. Ближайший к среднему.
 *
 * <p>Находит элемент массива, ближайший к среднему арифметическому.
 * Если таких элементов несколько, возвращается первый по индексу.
 * Среднее может быть дробным, поэтому сравнение выполняется без
 * деления — через {@code |a[i] * n - sum|}.
 */
public class NearestToAverageFinder {

    /**
     * Возвращает элемент массива, ближайший к среднему арифметическому.
     *
     * <p>Если несколько элементов одинаково близки к среднему,
     * возвращается первый по индексу. Массив должен содержать хотя бы
     * один элемент.
     *
     * @param array входной массив целых чисел
     * @return элемент, ближайший к среднему
     * @throws IllegalArgumentException если массив {@code null} или пуст
     */
    public static int findClosestToAverage(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        long sum = 0L;
        for (int value : array) {
            sum += value;
        }

        long n = array.length;
        int best = array[0];
        long bestDiff = Math.abs((long) array[0] * n - sum);

        for (int i = 1; i < array.length; i++) {
            long diff = Math.abs((long) array[i] * n - sum);
            // Строгое < — при равенстве сохраняется первый по индексу
            if (diff < bestDiff) {
                bestDiff = diff;
                best = array[i];
            }
        }

        return best;
    }
}