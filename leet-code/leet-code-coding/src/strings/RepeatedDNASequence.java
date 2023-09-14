package strings;

import java.util.*;

public class RepeatedDNASequence {
    public List<String> findRepeatedDnaSequences(String str) {

        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(int i=0;i+10<=str.length();i++){
            String temp =str.substring(i,i+10);
            if(!set.contains(temp)){
                set.add(temp);
            }else{
                if(!list.contains(temp)){
                    list.add(temp);
                }

            }
        }
        return list;
    }

    // we can use hashmap also

    public List<String> findRepeatedDnaSequencesUsingHashMap(String str) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i+10<str.length();i++){
            String temp = str.substring(i,i+10);
            map.put(temp,map.getOrDefault(temp,0)+1);
        }
        List<String> list = new ArrayList<>();
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(entry.getValue()>1){
                list.add(entry.getKey());
            }
        }
        return list;
    }


    public static void main(String[] args) {
        String normal = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        new RepeatedDNASequence().findRepeatedDnaSequences(normal).forEach(System.out::println);
    }
}
