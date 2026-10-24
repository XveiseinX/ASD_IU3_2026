package ru.bmstu.lab01.task_25;

public class SumOfElements {

    /**
     * Возвращает сумму всех элементов массива.
     *
     * <p>Сумма накапливается в {@code long}, чтобы избежать переполнения
     * {@code int} при больших значениях элементов. Если массив
     * {@code null} или пуст, возвращается {@code 0}.
     *
     * @param array входной массив целых чисел (может быть {@code null})
     * @return сумма всех элементов
     */
    public static long sum(int[] array) {
        if (array == null) {
            return 0L;
        }

        long sum = 0L;
        for (int value : array) {
            sum += value;
        }

        return sum;
    }
}