package ru.bmstu.lab01.task_12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PairSumFinderTest {

    @Test
    void shouldFindBasicPair() {
        int[] array = {1, 2, 3, 4};
        assertArrayEquals(new int[]{0, 3}, PairSumFinder.findPair(array, 5));
    }

    @Test
    void shouldChooseSmallestIAmongMultiplePairs() {
        int[] array = {1, 2, 3, 4};
        // Пары: (0,3) 1+4=5, (1,2) 2+3=5. Наименьший i = 0 → (0,3)
        assertArrayEquals(new int[]{0, 3}, PairSumFinder.findPair(array, 5));
    }

    @Test
    void shouldChooseSmallestJWhenIEqual() {
        int[] array = {1, 2, 3, 2, 5};
        // s = 3: (0,1) 1+2=3, (0,3) 1+2=3. i=0, минимальный j=1 → (0,1)
        assertArrayEquals(new int[]{0, 1}, PairSumFinder.findPair(array, 3));
    }

    @Test
    void shouldChooseSmallestIWhenPairsOverlap() {
        int[] array = {-5, -3, -2, 0};
        // s = -5: (0,3) -5+0=-5, (1,2) -3+(-2)=-5. i=0 → (0,3)
        assertArrayEquals(new int[]{0, 3}, PairSumFinder.findPair(array, -5));
    }

    @Test
    void shouldFindPairWithDuplicates() {
        int[] array = {2, 2, 2};
        // s = 4: (0,1), (0,2), (1,2). i=0, минимальный j=1 → (0,1)
        assertArrayEquals(new int[]{0, 1}, PairSumFinder.findPair(array, 4));
    }

    @Test
    void shouldFindPairWhenEqualValuesNeeded() {
        int[] array = {3, 1, 3};
        // s = 6: (0,2) 3+3=6
        assertArrayEquals(new int[]{0, 2}, PairSumFinder.findPair(array, 6));
    }

    @Test
    void shouldReturnMinusOneWhenNoPair() {
        int[] array = {1, 2, 3};
        assertArrayEquals(new int[]{-1, -1}, PairSumFinder.findPair(array, 100));
    }

    @Test
    void shouldReturnMinusOneWhenArrayIsNull() {
        assertArrayEquals(new int[]{-1, -1}, PairSumFinder.findPair(null, 5));
    }

    @Test
    void shouldReturnMinusOneWhenArrayIsEmpty() {
        assertArrayEquals(new int[]{-1, -1}, PairSumFinder.findPair(new int[]{}, 5));
    }

    @Test
    void shouldReturnMinusOneWhenArrayHasOneElement() {
        assertArrayEquals(new int[]{-1, -1}, PairSumFinder.findPair(new int[]{5}, 10));
    }

    @Test
    void shouldFindPairWithZerosSum() {
        int[] array = {-3, 3, 0};
        // s = 0: (0,1) -3+3=0
        assertArrayEquals(new int[]{0, 1}, PairSumFinder.findPair(array, 0));
    }

    @Test
    void shouldFindPairAtEdges() {
        int[] array = {10, 1, 2, 3, 20};
        // s = 30: (0,4) 10+20=30
        assertArrayEquals(new int[]{0, 4}, PairSumFinder.findPair(array, 30));
    }

    @Test
    void shouldHandleIntegerMaxAndMinSum() {
        int[] array = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        // MAX + MIN = -1
        assertArrayEquals(new int[]{0, 1}, PairSumFinder.findPair(array, -1));
    }

    @Test
    void shouldNotFalselyMatchDueToOverflow() {
        int[] array = {Integer.MAX_VALUE, 1};
        // MAX + 1 = 2^31, не равно MIN. Переполнение не должно дать ложную пару.
        assertArrayEquals(new int[]{-1, -1}, PairSumFinder.findPair(array, Integer.MIN_VALUE));
    }

    @Test
    void shouldNotModifyOriginalArray() {
        int[] original = {1, 2, 3, 4};
        int[] copy = original.clone();

        PairSumFinder.findPair(original, 5);

        assertArrayEquals(copy, original);
    }
}