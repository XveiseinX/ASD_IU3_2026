package ru.bmstu.lab01.task_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Задача 4. Все индексы элемента.
 *
 * <p>Находит все индексы элементов массива, равных заданному числу
 * {@code x}, в порядке возрастания, за один линейный проход.
 */
public class AllIndicesFinder {

    /**
     * Возвращает все индексы элементов массива, равных {@code x},
     * в порядке возрастания.
     *
     * <p>Если массив {@code null}, пуст или не содержит {@code x},
     * возвращается пустой массив.
     *
     * @param array входной массив целых чисел (может быть {@code null})
     * @param x     искомое значение
     * @return массив индексов в порядке возрастания; пустой, если
     *         вхождений нет
     */
    public static int[] findAllIndices(int[] array, int x) {
        if (array == null) {
            return new int[0];
        }

        // Первый проход: считаем количество вхождений
        int count = 0;
        for (int value : array) {
            if (value == x) {
                count++;
            }
        }

        // Второй проход: заполняем массив индексов
        int[] indices = new int[count];
        int pos = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) {
                indices[pos++] = i;
            }
        }

        return indices;
    }

    /**
     * Точка входа для запуска из командной строки.
     *
     * <p>Ожидает строку вида: {@code n a1 a2 ... an x}.
     * Выводит индексы через пробел в порядке возрастания или {@code -1},
     * если вхождений нет.
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
            int[] indices = findAllIndices(array, x);

            if (indices.length == 0) {
                System.out.println(-1);
            } else {
                StringBuilder sb = new StringBuilder();
                for (int idx : indices) {
                    sb.append(idx).append(' ');
                }
                System.out.println(sb.toString().trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}