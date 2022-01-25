package com.edu;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int rows){
        List<List<Integer>> pTriangle = new ArrayList<>();

        for(int i=0; i<rows; i++){
            ArrayList<Integer> subList = new ArrayList<>();
            System.out.print("Row num: " + i + " ");

            ArrayList<Integer> prevList = null;

            if(i != 0) {
                prevList = (ArrayList<Integer>) pTriangle.get(i - 1);
            }
            for(int j = 0; j < i + 1; j++){
                System.out.print("Cols: " + j + " ");

                if(j == 0 || j == i || i == 0) {
                    subList.add(1);
                    //System.out.print(" Value : " + 1 + "  ");
                    continue;
                } else {
                    int value1 = prevList.get(j-1);
                    int value2 = prevList.get(j);
                    subList.add(value1 + value2);
                    //System.out.print(" Value : " + (value1 + value2) + "  ");
                }
            }
            pTriangle.add(subList);
            System.out.print("\n");
            //int cols = i + 1;
        }
        return pTriangle;
    }
    public static void main(String[] args) {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        pascalsTriangle.generate(5);
    }
}
