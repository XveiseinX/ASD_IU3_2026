package ru.bmstu.lab01.task_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Задача 12. Пара с заданной суммой.
 *
 * <p>Находит индексы {@code (i, j)}, {@code i < j}, такие что
 * {@code a[i] + a[j] == s}. Если пар несколько, выбирается пара
 * с наименьшим {@code i}, а при равенстве — с наименьшим {@code j}.
 * Если пары нет, возвращается {@code {-1, -1}}.
 */
public class PairSumFinder {

    /**
     * Возвращает индексы пары с заданной суммой.
     *
     * <p>Используется {@link HashMap}, хранящая первое вхождение каждого
     * значения. Для каждого {@code j} ищется {@code s - a[j]} среди
     * индексов {@code < j} — это даёт минимально возможный {@code i}
     * для данного {@code j}. Перебор {@code j} по возрастанию
     * обеспечивает минимальный {@code j} при равных {@code i}.
     *
     * @param array входной массив целых чисел (может быть {@code null})
     * @param s     искомая сумма
     * @return массив {@code {i, j}} или {@code {-1, -1}}, если пары нет
     */
    public static int[] findPair(int[] array, int s) {
        if (array == null || array.length < 2) {
            return new int[]{-1, -1};
        }

        Map<Integer, Integer> firstIndex = new HashMap<>();
        int bestI = -1;
        int bestJ = -1;

        for (int j = 0; j < array.length; j++) {
            // target может выйти за пределы int — считаем в long
            long target = (long) s - array[j];
            if (target >= Integer.MIN_VALUE && target <= Integer.MAX_VALUE) {
                Integer i = firstIndex.get((int) target);
                if (i != null) {
                    if (bestI == -1 || i < bestI || (i == bestI && j < bestJ)) {
                        bestI = i;
                        bestJ = j;
                    }
                }
            }
            // Сохраняем только первое вхождение значения
            firstIndex.putIfAbsent(array[j], j);
        }

        if (bestI == -1) {
            return new int[]{-1, -1};
        }
        return new int[]{bestI, bestJ};
    }

    /**
     * Точка входа для запуска из командной строки.
     *
     * <p>Ожидает строку вида: {@code n a1 a2 ... an s}.
     * Выводит индексы пары через пробел или {@code -1 -1}, если пары нет.
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

            int s = Integer.parseInt(p[n + 1]);
            int[] result = findPair(array, s);
            System.out.println(result[0] + " " + result[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}