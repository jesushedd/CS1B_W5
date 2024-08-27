package src.main;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class AbsDataTypes {
    public static void main(String[] args) {
        /*(b) Given an unsorted array of integers, return the array sorted from least to
        greatest.*/
        Integer[] arr = {3,86,23,101};
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(List.of(arr));
        while (!priorityQueue.isEmpty()){
            for (int i = 0; i < arr.length; i++) {
                arr[i] = priorityQueue.poll();
            }

        }
        System.out.println(Arrays.toString(arr));


    }

}
