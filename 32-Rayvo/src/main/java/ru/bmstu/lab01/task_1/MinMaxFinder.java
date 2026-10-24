package ru.bmstu.lab01.task_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Задача 1. Максимум и минимум.
 *
 * <p>Находит минимальный и максимальный элементы целочисленного массива
 * за один линейный проход.
 */
public class MinMaxFinder {

    /**
     * Результат поиска: минимальный и максимальный элементы.
     *
     * @param min минимальный элемент
     * @param max максимальный элемент
     */
    public record MinMax(int min, int max) {
    }

    /**
     * Возвращает минимальный и максимальный элементы массива.
     *
     * <p>Массив должен содержать хотя бы один элемент. Если массив
     * {@code null} или пуст, выбрасывается {@link IllegalArgumentException}.
     *
     * @param array входной массив целых чисел
     * @return пара {@code (min, max)}
     * @throws IllegalArgumentException если массив {@code null} или пуст
     */
    public static MinMax findMinMax(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        int min = array[0];
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }

        return new MinMax(min, max);
    }

    /**
     * Точка входа для запуска из командной строки.
     *
     * <p>Ожидает строку вида: {@code n a1 a2 ... an}.
     * Выводит минимальный и максимальный элементы через пробел.
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

            MinMax result = findMinMax(array);
            System.out.println(result.min() + " " + result.max());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}