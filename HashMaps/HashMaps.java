package HashMaps;


import java.util.HashMap;
import java.util.Set;

public class HashMaps {
    public static void main(String args[]){
        HashMap<String, Integer> map = new HashMap<>();

        // add value
        map.put("abc",1);
        map.put("bcd",2);

        //check contain key or not
        System.out.println(map.containsKey("abc"));
        System.out.println(map.containsValue(2));

        //get value
        System.out.println(map.get("abc"));
        System.out.println(map.get("sdf"));

        //remove
        int s = map.remove("abc");
        System.out.println(s);
        //check contain value or not // expensive func

        System.out.println(map.containsValue(1));

        // get size
        System.out.println(map.size());

        // iterate

        Set<String> keys = map.keySet();;
        for  (String key : keys){
            System.out.println(key);
        }


    }
}
