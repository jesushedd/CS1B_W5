package src.main.Map61B;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.*;

public class ArrayMap<C extends Comparable<C>, V> implements Map61B<C ,V>, Iterable<C> {


    protected C[] keys;
    protected V[] values;
    int size; /*The next item will be added at (size) index*/

    private class KeyIterator  implements Iterator<C>{
        private int wizardP;
        public KeyIterator(){
            wizardP = 0;
        }

        public boolean hasNext(){
            return size > wizardP;
        }

        public C next(){
            C returnItem = keys[wizardP];
            wizardP++;
            return returnItem;
        }
    }

    @Override
    public KeyIterator iterator() {
        return new KeyIterator();
    }

    public ArrayMap(){
        keys = (C[]) new Comparable[100];
        values = (V[]) new Comparable[100];
        size = 0;
    }


    /*Returns the index of the given key if it exists*/
    public int keyIndex(C key){
        for (int i = 0; i < size ; i++) {
            if (keys[i].equals(key)){
                return i;
            }
        }
        return -1;
    }

    public boolean containsKey(C key){
        int index = keyIndex(key);
        return  index > -1;
    }


    public void put(C key, V value){
        int index = keyIndex(key);
        if (index == -1){
            values[size] = value;
            keys[size] = key;
            size++;
            return;
        }
        values[index] = value;
    }



    public V get(C key){
        int index = keyIndex(key);
        return values[index];
    }


    public int size(){
        return size;
    }


    public List<C> keys(){
        List<C> keyList = new LinkedList<C>();
        for (int i = 0; i < size ; i++) {
            keyList.add(keys[i]);
        }
        return keyList;
    }


    @Test
    public void test(){
        ArrayMap<Integer, Integer> am = new ArrayMap<Integer, Integer>();
        am.put(2,5);
        int expected = 5;
        assertEquals((Integer) expected,  am.get(2));
    }

    public static void main(String[] args) {
        ArrayMap<String, Integer> m = new ArrayMap<String, Integer>();
        m.put("greca", 3);
        m.put("safira", 2);
        m.put("shira", 1);

    }





}
