package ru.bmstu.lab01.task_03;

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
}