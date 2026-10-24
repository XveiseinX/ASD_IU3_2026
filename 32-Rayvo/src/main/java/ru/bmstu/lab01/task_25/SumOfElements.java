package ru.bmstu.lab01.task_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Задача 25. Сумма элементов.
 *
 * <p>Вычисляет сумму всех элементов массива за один линейный проход.
 */
public class SumOfElements {

    /**
     * Возвращает сумму всех элементов массива.
     *
     * <p>Сумма накапливается в {@code long}, чтобы избежать переполнения
     * {@code int} при больших значениях элементов. Если массив
     * {@code null} или пуст, возвращается {@code 0}.
     *
     * @param array входной массив целых чисел (может быть {@code null})
     * @return сумма всех элементов
     */
    public static long sum(int[] array) {
        if (array == null) {
            return 0L;
        }

        long sum = 0L;
        for (int value : array) {
            sum += value;
        }

        return sum;
    }
}