package ru.bmstu.lab01.task_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Задача 27. Сумма квадратов.
 *
 * <p>Вычисляет сумму квадратов всех элементов массива за один
 * линейный проход. Каждое слагаемое и итоговая сумма вычисляются
 * в {@code long}, чтобы избежать переполнения {@code int}.
 */
public class SumOfSquares {

    /**
     * Возвращает сумму квадратов всех элементов массива.
     *
     * <p>Квадрат каждого элемента вычисляется как
     * {@code (long) value * value}, поэтому переполнение {@code int}
     * на промежуточном шаге невозможно. Если массив {@code null}
     * или пуст, возвращается {@code 0}.
     *
     * @param array входной массив целых чисел (может быть {@code null})
     * @return сумма квадратов всех элементов
     */
    public static long sumOfSquares(int[] array) {
        if (array == null) {
            return 0L;
        }

        long sum = 0L;
        for (int value : array) {
            sum += (long) value * value;
        }

        return sum;
    }

    /**
     * Точка входа для запуска из командной строки.
     *
     * <p>Ожидает строку вида: {@code n a1 a2 ... an}.
     * Выводит сумму квадратов всех элементов.
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

            System.out.println(sumOfSquares(array));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}