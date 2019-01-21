package com.hackermonkey.twosome;

import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class TwoSumSolutionTestBase {

    private TwoSumSolution solution = getSolution();

    protected abstract TwoSumSolution getSolution();

    @Test
    public void given_emptyInput_then_returnsEmptyArray() {
        // When
        int[] output = solution.twoSum(new int[]{}, 10);

        // Then
        assertThat(output).isEmpty();
    }

    @Test
    public void given_nullInput_then_returnsEmptyArray() {
        // When
        int[] output = solution.twoSum(null, 10);

        // Then
        assertThat(output).isEmpty();
    }

    @Test
    public void given_arrayWithOneElementOnly_then_returnsEmptyArray() {
        // When
        int[] output = solution.twoSum(new int[]{1}, 10);

        // Then
        assertThat(output).isEmpty();
    }

    @Test
    public void given_targetIsMet_then_indexesAreReturned() {
        // When
        int[] output = solution.twoSum(new int[]{3, 2, 4}, 6);

        // Then
        assertThat(output).containsExactlyInAnyOrder(1, 2);
    }

    @Test
    @Ignore("slow")
    public void performance_test_worstCaseScenario() {
        // Given
        int nextToLastIndex = 999_998;
        int lastIndex = 999_999;

        int[] largeInput = new int[1_000_000];
        for(int i = 0; i < nextToLastIndex; i++){
            largeInput[i] = 1;
        }

        largeInput[nextToLastIndex] = 2;
        largeInput[lastIndex] = 3;

        // When
        int[] output = solution.twoSum(largeInput, largeInput[nextToLastIndex] + largeInput[lastIndex]);

        // Then
        assertThat(output).containsExactlyInAnyOrder(nextToLastIndex, lastIndex);
    }

    @Test
    public void performance_test_bestCaseScenario() {
        // Given
        int firstIndex = 0;
        int secondIndex = 1;

        int[] largeInput = new int[1_000_000];
        for(int i = 0; i < 1_000_000; i++){
            largeInput[i] = 1;
        }

        largeInput[firstIndex] = 2;
        largeInput[secondIndex] = 3;

        // When
        int[] output = solution.twoSum(largeInput, largeInput[firstIndex] + largeInput[secondIndex]);

        // Then
        assertThat(output).containsExactlyInAnyOrder(firstIndex, secondIndex);
    }

    @Test
    public void given_similarNumbersToAdd_then_indexesAreComputedCorrectly() {
        // When
        int[] output = solution.twoSum(new int[]{2, 2, 4}, 4);

        // Then
        assertThat(output).containsExactlyInAnyOrder(0, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_targetIsNotMet_then_explode() {
        solution.twoSum(new int[]{1, 2, 3, 4}, 30);
    }
}