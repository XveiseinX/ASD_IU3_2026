package ru.bmstu.lab01.task_06;

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
}