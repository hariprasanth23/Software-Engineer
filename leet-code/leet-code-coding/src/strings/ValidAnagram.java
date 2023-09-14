package strings;

public class ValidAnagram {
    public boolean isAnagram(String firstString, String secondString){
        int[] ascii = new int[26];
        if(firstString.length() != secondString.length()){
            return false;
        }
        for(int i=0;i<firstString.length();i++){
            ascii[firstString.charAt(i) - 'a']++;
            ascii[secondString.charAt(i) - 'a']--;
        }
        for(int i:ascii){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "anagram";
        String str2 = "nagaram";
        System.out.println(new ValidAnagram().isAnagram(str,str2));
    }
}
