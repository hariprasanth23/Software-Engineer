package strings;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String originalString :strs){
            char[] ch = originalString.toCharArray();
            Arrays.sort(ch);
            String sortedString = new String(ch);
            if(!map.containsKey(sortedString)){
                map.put(sortedString, new ArrayList<>());
            }
            map.get(sortedString).add(originalString);
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        String[] strings = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> groups = new GroupAnagrams().groupAnagrams(strings);
        for(List<String> temp:groups){
            for(String temp2:temp){
                System.out.println(temp2+" ");
            }
            System.out.println();
        }
    }
}
