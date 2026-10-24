package ru.bmstu.lab01.task_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Задача 5. Сумма элементов на чётных позициях.
 *
 * <p>Вычисляет сумму элементов массива с чётными индексами
 * ({@code 0, 2, 4, ...}) за один линейный проход.
 */
public class EvenIndexSum {

    /**
     * Возвращает сумму элементов массива с чётными индексами.
     *
     * <p>Если массив {@code null} или пуст, возвращается {@code 0}.
     *
     * @param array входной массив целых чисел (может быть {@code null})
     * @return сумма элементов с индексами {@code 0, 2, 4, ...}
     */
    public static long sumEvenIndices(int[] array) {
        if (array == null) {
            return 0L;
        }

        long sum = 0L;
        for (int i = 0; i < array.length; i += 2) {
            sum += array[i];
        }

        return sum;
    }
}