package ru.bmstu.lab01.task_08;

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
}