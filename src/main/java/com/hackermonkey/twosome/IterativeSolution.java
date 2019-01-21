package com.hackermonkey.twosome;

import java.util.Optional;

/**
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 * for n = 1_000_000 => execution time = 139,761 ms (2.32935 min) [worst case scenario]
 */
public class IterativeSolution implements TwoSumSolution{

    public int[] twoSum(int[] input, int target){

        long start = System.currentTimeMillis();

        if(input == null || input.length == 0 || input.length == 1){
            return new int[]{};
        }

        for(int i = 0 ; i < input.length ; i++){
            Optional<Integer> satisfyingIndex = computeFor(i, input, target);
            if(satisfyingIndex.isPresent()){
                long end = System.currentTimeMillis();
                System.out.println(end - start + " ms");
                return new int[]{i, satisfyingIndex.get()};
            }
        }
        throw new IllegalArgumentException("Target can not be met!");
    }

    private Optional<Integer> computeFor(int pointer, int[] input, int target) {
        for(int i = pointer + 1 ; i < input.length ; i++){
            if(input[pointer] + input[i] == target){
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

}
