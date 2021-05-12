import java.util.*;
class leetcode{

    // 219. Contains Duplicate II
    public static boolean containsNearbyDuplicate(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                if(Math.abs(i-map.get(arr[i])) <= k ){
                    return true;
                }else{
                    map.put(arr[i],i);
                }
            }else{
                map.put(arr[i],i);  // k=1, arr = {1,0,1,1};  imp step : agar first time duplicate milega to uska diff 2 (0-2) aayega 
                                    // but map me dubara 1 dalenge 2 index wala then index 2 and 3 ka diff 1 aayega which is equal to k
            }
        }
        
        return false;
    }

    // 202. Happy Number

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
      
        while(!set.contains(n)){
             set.add(n);  // if it is not in set then first add in set bcoz it's not happy no
            
            int temp=0;

            // finding sum by squaring each digit of n
            while(n>0){
                temp += (n%10)*(n%10);
                n = n/10;  
            }
            
            n = temp;
            if(n==1) return true;  // cheking if sum equals to 1 if satisfy the condition then it is happy no otherwise lopp will run again for this new number
           
        }
        
        return false;
    }

    public static void main(String[] args){
       int[] arr =  {1,0,1,1};
       int k =1;
        System.out.println(containsNearbyDuplicate(arr,k));
    }


}