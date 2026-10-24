package ru.bmstu.lab01.task_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Задача 2. Индекс первого вхождения.
 *
 * <p>Находит индекс первого элемента массива, равного заданному числу
 * {@code x}, за один линейный проход. Если такого элемента нет,
 * возвращается {@code -1}.
 */
public class FirstOccurrenceFinder {

    /**
     * Возвращает индекс первого элемента массива, равного {@code x}.
     *
     * <p>Если массив {@code null} или элемент не найден, возвращается
     * {@code -1}.
     *
     * @param array входной массив целых чисел (может быть {@code null})
     * @param x     искомое значение
     * @return индекс первого вхождения {@code x} или {@code -1}, если
     *         элемент не найден или массив {@code null}
     */
    public static int findFirstOccurrence(int[] array, int x) {
        if (array == null) {
            return -1;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Точка входа для запуска из командной строки.
     *
     * <p>Ожидает строку вида: {@code n a1 a2 ... an x}.
     * Выводит индекс первого вхождения {@code x} или {@code -1}.
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
            System.out.println(findFirstOccurrence(array, x));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}