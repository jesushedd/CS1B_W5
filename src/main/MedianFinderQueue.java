package src.main;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MedianFinderQueue {
    private final PriorityQueue<Integer> lessThanMedian ;
    private final PriorityQueue<Integer> biggerThanMedian ;



    public MedianFinderQueue(){
        //Seed max and min values
        lessThanMedian  = new PriorityQueue<>(Collections.reverseOrder());
        lessThanMedian.add(Integer.MIN_VALUE);
        biggerThanMedian = new PriorityQueue<>();
        biggerThanMedian.add(Integer.MAX_VALUE);

    }

    public MedianFinderQueue(List<Integer> lisValues){
        lessThanMedian  = new PriorityQueue<>(Collections.reverseOrder());
        lessThanMedian.add(Integer.MIN_VALUE);
        biggerThanMedian = new PriorityQueue<>();
        biggerThanMedian.add(Integer.MAX_VALUE);

        for (Integer v : lisValues){
            add(v);
        }
    }


    public void add(Integer x){
        if (x >= biggerThanMedian.peek()){ //
            biggerThanMedian.add(x);
        } else {
            lessThanMedian.add(x);
        }

        //Re-balance
        if(biggerThanMedian.size() - lessThanMedian.size() == 2){//upper queue is larger
            lessThanMedian.add(biggerThanMedian.poll()); //move value from upper to lower
        } else if (lessThanMedian.size() - biggerThanMedian.size() == 2) { // Lower queue is larger
            biggerThanMedian.add(lessThanMedian.poll()); //move value from lower to upper
        }

    }

    private double median(){
        if (lessThanMedian.size() == biggerThanMedian.size()){
            return ((lessThanMedian.peek() + biggerThanMedian.peek()) / 2.0F); // Median of same length halfs is mean of top values
        }
        //Otherwise median is in the top of queue that is larger by one
        else if (biggerThanMedian.size() > lessThanMedian.size()) {
            return biggerThanMedian.peek();

        } else return lessThanMedian.peek();


    }

    public static void main(String[] args) {
        MedianFinderQueue rm = new MedianFinderQueue(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100));
        System.out.println(rm.median());

    }

}
