package ru.bmstu.lab01.task_01;

public class MinMaxFinder {

    /**
     * Результат поиска: минимальный и максимальный элементы.
     *
     * @param min минимальный элемент
     * @param max максимальный элемент
     */
    public record MinMax(int min, int max) {
    }

    /**
     * Возвращает минимальный и максимальный элементы массива.
     *
     * <p>Массив должен содержать хотя бы один элемент. Если массив
     * {@code null} или пуст, выбрасывается {@link IllegalArgumentException}.
     *
     * @param array входной массив целых чисел
     * @return пара {@code (min, max)}
     * @throws IllegalArgumentException если массив {@code null} или пуст
     */
    public static MinMax findMinMax(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        int min = array[0];
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }

        return new MinMax(min, max);
    }
}