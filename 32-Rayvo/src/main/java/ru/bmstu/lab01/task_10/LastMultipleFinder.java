package ru.bmstu.lab01.task_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Задача 10. Поиск элемента с условием.
 *
 * <p>Находит индекс последнего элемента массива, кратного заданному
 * числу {@code k}. Если такого элемента нет, возвращается {@code -1}.
 * {@code k} не может быть нулём.
 */
public class LastMultipleFinder {

    /**
     * Возвращает индекс последнего элемента, кратного {@code k}.
     *
     * <p>Проход идёт справа налево, поэтому находится именно последний
     * элемент, а при первом совпадении работа прекращается досрочно.
     * Если массив {@code null}, пуст или не содержит кратных {@code k},
     * возвращается {@code -1}.
     *
     * @param array входной массив целых чисел (может быть {@code null})
     * @param k     делитель; не должен быть нулём
     * @return индекс последнего элемента, кратного {@code k}, или {@code -1}
     * @throws IllegalArgumentException если {@code k == 0}
     */
    public static int findLastMultiple(int[] array, int k) {
        if (k == 0) {
            throw new IllegalArgumentException("k must not be zero");
        }
        if (array == null) {
            return -1;
        }

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] % k == 0) {
                return i;
            }
        }

        return -1;
    }
}