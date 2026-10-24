package ru.bmstu.lab01.task_27;

public class SumOfSquares {

    /**
     * Возвращает сумму квадратов всех элементов массива.
     *
     * <p>Квадрат каждого элемента вычисляется как
     * {@code (long) value * value}, поэтому переполнение {@code int}
     * на промежуточном шаге невозможно. Если массив {@code null}
     * или пуст, возвращается {@code 0}.
     *
     * @param array входной массив целых чисел (может быть {@code null})
     * @return сумма квадратов всех элементов
     */
    public static long sumOfSquares(int[] array) {
        if (array == null) {
            return 0L;
        }

        long sum = 0L;
        for (int value : array) {
            sum += (long) value * value;
        }

        return sum;
    }
}