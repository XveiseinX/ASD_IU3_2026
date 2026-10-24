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

    /**
     * Точка входа для запуска из командной строки.
     *
     * <p>Ожидает строку вида: {@code n a1 a2 ... an}.
     * Выводит сумму всех элементов.
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

            System.out.println(sum(array));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}