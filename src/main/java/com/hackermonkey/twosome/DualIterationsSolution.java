package com.hackermonkey.twosome;

import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * for n = 1_000_000 => execution time = 40 ms [worst case scenario]
 */
public class DualIterationsSolution implements TwoSumSolution {
    @Override
    public int[] twoSum(int[] input, int target) {
        if(input == null || input.length < 2){
            return new int[]{};
        }

        long start = System.currentTimeMillis();

        Map<Integer, Integer> lookupTable = new HashMap<>();
        for(int i = 0 ; i < input.length ; i++){
            lookupTable.put(input[i], i);
        }

        for(int i = 0 ; i < input.length ; i++){
            int expectedComplement = target - input[i];
            if(lookupTable.containsKey(expectedComplement) && lookupTable.get(expectedComplement) != i){
                long end = System.currentTimeMillis();
                System.out.println((end - start) + " ms");
                return new int[]{i, lookupTable.get(expectedComplement)};
            }
        }


        throw new IllegalArgumentException("Target can not be met!");
    }
}
