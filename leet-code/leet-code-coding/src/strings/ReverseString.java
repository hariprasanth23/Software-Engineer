package strings;

public class ReverseString {
    public String reverseString(String str){
        char[] ch = str.toCharArray();
        int left = 0;
        int right = str.length()-1;
        while(left < right){
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            left++;
            right--;
        }
        return new String(ch);
    }
    public static void main(String[] args) {
        String str = "Hari Prasanth";
        String reversedString = new ReverseString().reverseString(str);
        System.out.println(reversedString);
    }
}
