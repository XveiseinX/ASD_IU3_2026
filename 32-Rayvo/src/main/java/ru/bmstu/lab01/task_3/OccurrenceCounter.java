package ru.bmstu.lab01.task_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Задача 3. Подсчёт вхождений.
 *
 * <p>Считает количество элементов массива, равных заданному числу
 * {@code x}, за один линейный проход.
 */
public class OccurrenceCounter {

    /**
     * Возвращает количество элементов массива, равных {@code x}.
     *
     * <p>Если массив {@code null} или пуст, возвращается {@code 0}.
     *
     * @param array входной массив целых чисел (может быть {@code null})
     * @param x     искомое значение
     * @return количество элементов, равных {@code x}
     */
    public static int countOccurrences(int[] array, int x) {
        if (array == null) {
            return 0;
        }

        int count = 0;
        for (int value : array) {
            if (value == x) {
                count++;
            }
        }

        return count;
    }

    /**
     * Точка входа для запуска из командной строки.
     *
     * <p>Ожидает строку вида: {@code n a1 a2 ... an x}.
     * Выводит количество элементов, равных {@code x}.
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

            int x = Integer.parseInt(p[n + 1]);
            System.out.println(countOccurrences(array, x));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}