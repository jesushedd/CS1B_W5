package src.main;

import src.main.Map61B.Map61B;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

public class BiDividerMap2<K,V> implements Map61B<K,V> {

    private final Map<K, V> keyToValues;
    private final Map<V, K> valuesToKeys;

    public BiDividerMap2(){
        keyToValues = new HashMap<>();
        valuesToKeys = new HashMap<>();
    }



    public V getByKey(K key){
        return keyToValues.get(key);
    }


    public K getByValue(V val){
        return valuesToKeys.get(val);
    }


    public Integer numLessThan(K key){
        if (!keyToValues.containsKey(key)){
            return null;
        }

        List<K> keyList = keys();
        keyList.sort(null);
        return keyList.indexOf(key);


    }


    @Override
    public boolean containsKey(K key) {
        return keyToValues.containsKey(key);
    }

    @Override
    public V get(K key) {
        return keyToValues.get(key);
    }

    @Override
    public int size() {
        return keyToValues.size();
    }

    @Override
    public void put(K key, V value) {
        keyToValues.put(key, value);
        valuesToKeys.put(value, key);
    }

    @Override
    public List<K> keys() {
        return List.copyOf(keyToValues.keySet());
    }

    public static void main(String[] args) {
        BiDividerMap<Integer, Integer> biMap = new BiDividerMap<>();
        biMap.put(2, 4);
        biMap.put(3,9);
        biMap.put(4, 16);
        biMap.put(5, 25);
        biMap.put(6, 36);
        biMap.put(7, 49);
        System.out.println(biMap.numLessThan(7));
    }
}
