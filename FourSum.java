package com.edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length == 0) {
            return lists;
        }

        Arrays.sort(nums);
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < nums.length - 1; i++) {

            for(int j = i + 1; i < nums.length - 1; i++){
                List<Integer> subList = new ArrayList<>();
                int current = j;
                int leftIndex = j + 1;
                int rightIndex = nums.length - 1;

                while(leftIndex < rightIndex) {
                    int iValue = nums[i];
                    int jValue = nums[current];
                    int leftIndexValue = nums[leftIndex];
                    int rightIndexValue = nums[rightIndex];

                    int totalValue = iValue + jValue + leftIndexValue + rightIndexValue;
                    String check = iValue + "-" + jValue + "-" + leftIndexValue + "-" + rightIndexValue;
                    if(target == totalValue && !set.contains(check)){
                        set.add(check);
                        subList.add(iValue);
                        subList.add(jValue);
                        subList.add(leftIndexValue);
                        subList.add(rightIndexValue);
                        lists.add(subList);
                        rightIndex--;
                        leftIndex++;
                        //current++;
                    }
                    else if(totalValue < target){
                        leftIndex++;
                    } else {
                        rightIndex--;
                    }
                }
            }
        }

        return lists;
    }
    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] nums = new int[]{1,0,-1,0,-2,2};
        List<List<Integer>> lists = fourSum.fourSum(nums, 0);

        for(List subList : lists) {
            for(Object i : subList) {
                System.out.print(i.toString() + " ");
            }
            System.out.println("");
        }
    }
}
