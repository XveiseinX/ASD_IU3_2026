package ru.bmstu.lab01.task_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Задача 9. Проверка отсортированности.
 *
 * <p>Проверяет, является ли массив неубывающим
 * ({@code a[i] <= a[i+1]} для всех {@code i}), за один линейный проход.
 */
public class SortedChecker {

    /**
     * Проверяет, является ли массив неубывающим.
     *
     * <p>Массив {@code null}, пустой массив и массив из одного элемента
     * считаются неубывающими (тривиальный случай).
     *
     * @param array входной массив целых чисел (может быть {@code null})
     * @return {@code true}, если массив неубывающий, иначе {@code false}
     */
    public static boolean isNonDecreasing(int[] array) {
        if (array == null || array.length < 2) {
            return true;
        }

        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }

        return true;
    }
}