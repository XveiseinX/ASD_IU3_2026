package ru.bmstu.lab01.task_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Задача 8. Фильтрация по знаку.
 *
 * <p>Разделяет массив на два: из положительных и из отрицательных
 * элементов, сохраняя исходный порядок. Нули не включаются ни в один
 * из массивов.
 */
public class SignFilter {

    /**
     * Результат фильтрации: положительные и отрицательные элементы
     * в исходном порядке.
     *
     * @param positive положительные элементы
     * @param negative отрицательные элементы
     */
    public record FilterResult(int[] positive, int[] negative) {
    }

    /**
     * Разделяет массив на положительные и отрицательные элементы,
     * сохраняя исходный порядок. Нули отбрасываются.
     *
     * <p>Если массив {@code null} или пуст, оба результирующих массивов
     * пусты.
     *
     * @param array входной массив целых чисел (может быть {@code null})
     * @return пара массивов {@code (positive, negative)}
     */
    public static FilterResult filterBySign(int[] array) {
        if (array == null || array.length == 0) {
            return new FilterResult(new int[0], new int[0]);
        }

        // Первый проход: подсчёт положительных и отрицательных
        int positiveCount = 0;
        int negativeCount = 0;
        for (int value : array) {
            if (value > 0) {
                positiveCount++;
            } else if (value < 0) {
                negativeCount++;
            }
        }

        // Второй проход: заполнение массивов в исходном порядке
        int[] positive = new int[positiveCount];
        int[] negative = new int[negativeCount];
        int pi = 0;
        int ni = 0;
        for (int value : array) {
            if (value > 0) {
                positive[pi++] = value;
            } else if (value < 0) {
                negative[ni++] = value;
            }
        }

        return new FilterResult(positive, negative);
    }

    /**
     * Точка входа для запуска из командной строки.
     *
     * <p>Ожидает строку вида: {@code n a1 a2 ... an}.
     * Выводит две строки: положительные элементы через пробел, затем
     * отрицательные через пробел. Если соответствующий массив пуст,
     * выводится {@code -}.
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

            FilterResult result = filterBySign(array);
            System.out.println(formatArray(result.positive()));
            System.out.println(formatArray(result.negative()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Форматирует массив в строку через пробел; пустой массив — {@code -}.
     *
     * @param array массив для форматирования
     * @return строка с элементами через пробел или {@code -}
     */
    private static String formatArray(int[] array) {
        if (array.length == 0) {
            return "-";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(array[i]);
        }
        return sb.toString();
    }
}