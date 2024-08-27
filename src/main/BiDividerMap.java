package src.main;

import src.main.Map61B.ArrayMap;

import java.util.ArrayList;
import java.util.List;

public class BiDividerMap<K extends Comparable<K>, V> extends ArrayMap<K, V> {




    public V getByKey(K key){
        return super.get(key);
    }


    public K getByValue(V value){
        //get index by value
        for (int i = 0; i < super.size() ; i++) {
            if (super.values[i] == value){
                return super.keys[i];
            }
        }
        return null;
    }

    public  Integer numLessThan(K key){
        if (!containsKey(key)){
            return null;
        }
        List<K> keysLessThan = new ArrayList<>(size());
        for (int i = 0; i < size(); i++) {
            if (key.compareTo(keys[i]) > 0){
                keysLessThan.add(keys[i]);
            }

        }
        return keysLessThan.size();

    }


    public static void main(String[] args) {
        BiDividerMap<Integer, Integer> biMap = new BiDividerMap<>();
        biMap.put(2, 4);
        biMap.put(3,9);
        biMap.put(4, 16);
        biMap.put(5, 25);
        biMap.put(6, 36);
        biMap.put(7, 49);
        System.out.println(biMap.numLessThan(2));
    }



}
