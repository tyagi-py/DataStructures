package HashMaps;

import java.util.HashMap;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String args[]){
        int arr[] ={1,1,2,3,2,4,5,6,6,7,8};

        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (int i : arr){
            map.put(i,true);
        }
        Set<Integer> keys = map.keySet();
        for (int i : keys){
            System.out.println(i);
        }
    }

}
