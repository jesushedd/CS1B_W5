package src.main.Map61B;

public class IteratorDemo {
    public static void main(String[] args) {
        ArrayMap<String, Integer> am = new ArrayMap<String, Integer>();

        am.put("hello", 5);
        am.put("syrups", 10);
        am.put("kingdom", 10);

        /*ArrayMap<String, Integer>.KeyIterator ami = am.new KeyIterator();

        while (ami.hasNext()){
            System.out.println(ami.next());
        }*/

        for (String s : am){
            System.out.println(s);
        }




    }
}
