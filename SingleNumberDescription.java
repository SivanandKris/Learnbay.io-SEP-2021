package com.edu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumberDescription {
    public int singleNumber(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int singleNum = 0;

        for(int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }

        for(Map.Entry<Integer,Integer> me : map.entrySet()) {
            if(me.getValue() == 1) {
                singleNum = me.getKey();
                break;
            } else {
                continue;
            }
        }

        return singleNum;

    }

    public static void main(String[] args) {
        SingleNumberDescription singleNumberDescription = new SingleNumberDescription();
        int arr[] = new int[]{4,1,2,1,2};
        int singleNum = singleNumberDescription.singleNumber(arr);
        System.out.println(singleNum);
    }
}
