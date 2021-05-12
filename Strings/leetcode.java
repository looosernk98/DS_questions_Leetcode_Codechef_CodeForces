import java.util.*;

public class leetcode {

    // 387. First Unique Character in a String
    public int firstUniqChar(String s) {
        char[] arr = new char[26];

        for(char ch : s.toCharArray()) arr[ch-97]++;      // str.toCharArray() --> function to convert string into char array

        for(int i=0; i<s.length(); i++){
            if(arr[s.charAt(i)-97]==1) return i;
        }

        return -1;
    }
    public static void main(String[] args){
       leetcode leet = new leetcode();
       int n = leet.firstUniqChar("jjswgshwdwewwp");
       System.out.println(n);
    }
}
