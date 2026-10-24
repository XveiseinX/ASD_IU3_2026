package ru.bmstu.lab01.task_9;

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

    /**
     * Точка входа для запуска из командной строки.
     *
     * <p>Ожидает строку вида: {@code n a1 a2 ... an}.
     * Выводит {@code YES}, если массив неубывающий, иначе {@code NO}.
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

            System.out.println(isNonDecreasing(array) ? "YES" : "NO");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}