package ru.bmstu.lab01.task_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Задача 6. Элементы больше среднего.
 *
 * <p>Считает количество элементов массива, строго больших среднего
 * арифметического всех элементов. Гарантируется, что среднее — целое
 * число (сумма делится на {@code n}).
 */
public class AboveAverageCounter {

    /**
     * Возвращает количество элементов, строго больших среднего
     * арифметического.
     *
     * <p>Если массив {@code null} или пуст, возвращается {@code 0}.
     * Сумма накапливается в {@code long}, чтобы избежать переполнения
     * {@code int} при больших значениях элементов.
     *
     * @param array входной массив целых чисел (может быть {@code null})
     * @return количество элементов, строго больших среднего
     */
    public static int countGreaterThanAverage(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        // Первый проход: сумма всех элементов
        long sum = 0L;
        for (int value : array) {
            sum += value;
        }

        // Гарантируется, что среднее — целое число
        long average = sum / array.length;

        // Второй проход: подсчёт элементов строго больше среднего
        int count = 0;
        for (int value : array) {
            if (value > average) {
                count++;
            }
        }

        return count;
    }

    /**
     * Точка входа для запуска из командной строки.
     *
     * <p>Ожидает строку вида: {@code n a1 a2 ... an}.
     * Выводит количество элементов, строго больших среднего.
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

            System.out.println(countGreaterThanAverage(array));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}