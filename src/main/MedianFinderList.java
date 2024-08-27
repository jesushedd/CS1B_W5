package src.main;

import java.util.ArrayList;
import java.util.List;

public class MedianFinderList extends ArrayList<Integer> {



    @Override
    public boolean add(Integer x){
        super.add(x);
        return true;
    }

    public float median(){
        int listSize = size();
        sort(null);
        if (listSize/ 2 == 0){
            return (get(listSize/2) + get(listSize/2 - 1)) / 2.0f;
        }

        return get(listSize/2);
    }

    public static void main(String[] args) {
        MedianFinderList my_finder = new MedianFinderList();
        my_finder.addAll(List.of(1,9,8,4,2,3,6,1,0,4,7,4,1,2,5,8,7,9,5,2,1,6));
        System.out.println(my_finder.median());
    }




}
