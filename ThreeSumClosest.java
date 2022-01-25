package com.edu;

import java.util.Arrays;

public class ThreeSumClosest {
    public int findClosestSum(int[] nums, int target){

        if(nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length -1; i++) {
            int leftIndex = i + 1;
            int rightIndex = nums.length - 1;
            int currentIndex  = i;

            while(leftIndex < rightIndex) {
                int leftValue = nums[leftIndex];
                int currentValue = nums[currentIndex];
                int rightValue = nums[rightIndex];

                int totalValue = leftValue + currentValue + rightValue;
                int currDiff = target - totalValue;

                if(Math.abs(currDiff) < Math.abs(diff)){
                    diff = currDiff;
                    //leftIndex++;
                    //rightIndex--;
                }
                if (totalValue < target){
                    leftIndex++;
                } else {
                    rightIndex--;
                }
            }
        }
        return target - diff;
    }
    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int[] nums = new int[]{0,2,1,-3};
        //int[] nums = new int[]{-1,2,1,-4};
        System.out.println(threeSumClosest.findClosestSum(nums, 1));
    }
}
