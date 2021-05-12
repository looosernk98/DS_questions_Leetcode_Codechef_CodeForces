import java.util.*;

public class leetcode{
    public static void main(String[] args){
        
    }

    // leetcode 67 - Add binary

    //method 1
    public String addBinary(String a, String b) {
        String c = "0";
        String sum="";
        
        int i=a.length()-1;
        int j= b.length()-1;
        
        while(i>=0 && j>=0){
           if(a.charAt(i)=='1' && b.charAt(j)=='1'){
               sum = c=="1"? "1"+sum : "0"+sum;
               c = "1";
           }else if(a.charAt(i)=='0' && b.charAt(j)=='0'){
               sum = c=="1"? "1"+sum : "0"+sum;
               c = "0";
           }else{
               if(c=="1"){
                   sum = "0"+sum;
                   c="1";
               }else{
                   sum = "1"+sum;
                   c="0";
               }
           }
            
            i--;
            j--;
        }
        
        if(i>=0){
            while(i>=0){
                if(a.charAt(i)=='1'){
                    if(c=="1"){
                        sum = "0"+sum;
                        c = "1";
                    }else{
                        sum = "1"+sum;
                        c="0";
                    }
                }else{
                   sum = c + sum;
                    c="0";
                }
                
                i--;
            }
        }else if(j>=0){
             while(j>=0){
                if(b.charAt(j)=='1'){
                    if(c=="1"){
                        sum = "0"+sum;
                        c = "1";
                    }else{
                        sum = "1"+sum;
                        c="0";
                    }
                }else{
                   sum = c + sum;
                    c="0";
                }
                
                j--;
            }
        }else{
            if(c=="1"){
                sum ="1"+sum;
                c="0";
            }
        }
        
        if(c=="1") sum ="1"+sum;
        return sum;
    }

    //method 2

    public String addBinary_2(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;

        while(i>=0 || j>=0){
          int sum = carry;
        
          if(i>=0) sum += a.charAt(i) - '0';
          if(j>=0) sum += b.charAt(j) - '0';
          
          sb.append(sum % 2);
          carry = sum / 2;

          i--;
          j--;

        }

        if(carry !=0){
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

   // method 3
    public String addBinary_3(String a, String b){
        int alen=a.length()-1;
        int blen=b.length()-1;
        String s="";
        int car=0;
        
        while(alen>=0 || blen>=0 || car>0){
            int achar = alen>=0 ? Character.getNumericValue(a.charAt(alen)) : 0;
            int bchar = blen>=0 ? Character.getNumericValue(b.charAt(blen)) : 0;
            int sum=achar+bchar+car;
        
            
            if(sum<2) s=Integer.toString(sum)+s;
            else if(sum==2) s=Integer.toString(0)+s;
            else s=Integer.toString(1)+s;
            
            car = sum>1 ? 1 : 0;
            --alen;--blen;
        }
        return s;
    }

    // leetcode 258 - Add digits 

    public int addDigits(int num) {
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
    }
       // method 2
    public int addDigits_2(int num) {
        while(num / 10 != 0){
            int sum = 0;
            while(num!=0){
                sum += num%10;
                num = num/10;
            }
            
            num = sum;
        }
        
        return num;
    }

    // leetcode 441 - Add Strings 

    public String addStrings(String num1, String num2) {
        int i=num1.length()-1;
        int j=num2.length()-1;
        
        StringBuilder sb = new StringBuilder();
        int carry =0;
        
        while(i>=0 || j>=0){
            int sum = carry;
            if(i>=0) sum += num1.charAt(i)-'0'; // if(i>=0) sum += Integer.valueOf(num1.charAt(i)+"");  
            if(j>=0) sum += num2.charAt(j)-'0'; // if(j>=0) sum += Integer.valueOf(num2.charAt(j)+"");  //
            
            sb.append(sum%10);
            carry = sum/10;
            
            i--;
            j--;
        }
        
        if(carry!=0){
            sb.append(carry);
        }
        
        return sb.reverse().toString();
    }

    // leetcode 989. Add to Array-Form of Integer

    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> list = new ArrayList<>();
        
        int i=num.length-1;
        int carry =0;
        
        while(i>=0 || k!=0){
            int sum = carry;
            if(i>=0) sum += num[i]; 
            if(k!=0){
                sum += k%10; 
                k=k/10;
            }
            
            list.add(sum%10);
            carry = sum/10;
            
            i--;
        }
        
        if(carry!=0){
            list.add(carry);
        }
        
      Collections.reverse(list);
        
        return  list;
    }


    // leetcode 66. Plus One

    // method 1
    public int[] plusOne(int[] digits) {
        int i = digits.length-1;
        int c =0;
        List<Integer> list = new ArrayList<>();
        
        while(i>=0){
            if(i==digits.length-1){
                int v = (digits[i]+1+c)%10;
                c = (digits[i]+1+c)/10;
                list.add(v);
            }else{
                int v = (digits[i]+c)%10;
                c = (digits[i]+c)/10;
                list.add(v);
            }
            
            i--;
        }
        
        if(c!=0) list.add(c);
        
        int[] arr = new int[list.size()];
        
        for(int j=list.size()-1; j>=0; j--){
            arr[list.size()-1-j]=list.get(j);
        }
        
        return arr;
    }

    // method 2 
    public int[] plusOne_2(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i] + 1;
            if (digit < 10) {
                digits[i] = digit;
                break;
            } else {
                digits[i] = 0;
            }
        }
        if(digits[0] == 0) {
            digits =  new int[digits.length  +1];
            digits[0] = 1;
        }
        return digits;
    }

    //172. Factorial Trailing Zeroes

    public int trailingZeroes(int n) {
        int count=0;
        
        while(n>=5){
            count += n/5;   // divide the num every time by 5 until num becomes less than 5 and count quotient every time that will be answer of trailing zeroes
            n = n/5;
        }
        
        return count;
    }

    //171. Excel Sheet Column Number
    public int titleToNumber(String columnTitle) {
        int res = 0;
        int multiple = 1;
        for(int i = columnTitle.length() - 1; i >=0; i--){
            res += ((int) (columnTitle.charAt(i) - 'A') + 1) * multiple;
            multiple *= 26;
        }
        return res;
    }

    //method 2
    public int titleToNumber_2(String columnTitle) {
        int sum =0;
        
        for(int i=0; i<columnTitle.length(); i++){
            sum += (columnTitle.charAt(i)-'A'+1)*powerof26(columnTitle.length()-i-1);  // can also use Math.pow() instead of powerof26 function
        }
        
        return sum;
    }
    
    public int powerof26(int n){
        if(n==0) return 1;
        if(n==1) return 26;
        
        int ans =1;
        
        if(n%2==1){
            ans *=26;
        }
        
        int v = powerof26(n/2);
        ans *= v*v;
        return ans;
    }

    //605. Can Place Flowers
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0) return true;
        
        if(flowerbed.length==1){
            if(flowerbed[0]==0 && n==1) return true;
            else return false;
        }
        
        for(int i=0; i<flowerbed.length; i++){
            if(i==0){
                if(flowerbed[i]==0 && flowerbed[i+1]!=1){
                    flowerbed[i]=1;
                    n--;
                }
            }else if(i==flowerbed.length-1){
                if(flowerbed[i]==0 && flowerbed[i-1]!=1){
                    flowerbed[i]=1;
                    n--;
                } 
            }else{
              if(flowerbed[i]==0 && flowerbed[i-1]!=1 && flowerbed[i+1]!=1){
                  flowerbed[i]=1;
                  n--;
              }
            }
            
            if(n==0) return true;
            
        }
        
      return false;
    }

    // 1304. Find N Unique Integers Sum up to Zero
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        
        for(int i=0; i<n/2; i++){
            ans[i]=(i+1);
            ans[n-1-i]=-(i+1);
        }
        
        return ans;
    }

    // 1346. Check If N and Its Double Exist
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<arr.length; i++){
            if(set.contains(arr[i])) return true;
            else{
                set.add(arr[i]*2);
                if(arr[i]%2==0) set.add(arr[i]/2);
            }
        }
        
        return false;
    }

    // 1232. Check If It Is a Straight Line
    public boolean checkStraightLine_1(int[][] coordinates) {
        int x0 = coordinates[0][0], y0 = coordinates[0][1];
        int x1 = coordinates[1][0], y1 = coordinates[1][1];
          
          for(int i=2; i<coordinates.length; i++){
              int x2 = coordinates[i][0] , y2 = coordinates[i][1];
              //m1 = m2 ->it handles divide by 0 
              if((y2-y1)*(x1-x0) != (y1-y0)*(x2-x1)) return false; //(x1 - x0) * (y2 - y1) != (y1 - y0) * (x2 - x1)
          }
          
          return true;
      }

    public boolean checkStraightLine_2(int[][] coordinates) {        
        if(coordinates[1][0] == coordinates[0][0]) {
            for(int i = 1; i < coordinates.length; ++i) {
                if(coordinates[i][0] != coordinates[i - 1][0]) {
                    return false;
                }
            }
            return true;
        }
        
        float m = (float) (coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);
        float c = coordinates[0][1] - m * coordinates[0][0];
        
        for(int i = 1; i < coordinates.length; ++i) {
            float y = coordinates[i][1];
            float mxplusc = m * coordinates[i][0] + c;
            
            if(y != mxplusc) {
                return false;
            }
        }
        return true;
    }

    public boolean checkStraightLine_3(int[][] coordinates){

        if(coordinates.length>2){
             
            int dx = coordinates[1][0]-coordinates[0][0];
            int dy = coordinates[1][1]-coordinates[0][1];
            int cc=coordinates[0][0]*dy-coordinates[0][1]*dx;
              for(int i=2;i<coordinates.length;++i){
                  if(coordinates[i][0]*dy - coordinates[i][1]*dx!=cc)
                      return false;
              }
          }
            return true;
    }

     // 1252. Cells with Odd Values in a Matrix
     public int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];
        
        for(int[] a : indices){
            int r = a[0];
            int c = a[1]; 
            
            for(int j=0; j<n; j++){    // row addition
                matrix[r][j]++;
            }
            
            for(int i=0; i<m; i++){    // col addition
                matrix[i][c]++;
            }
        }
        
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] % 2 == 1) count++;
            }
        }
        return count;
    }







        //     220. Contains Duplicate III
        //     204. Count Primes
        //     509. Fibonacci Number
        //     1337. The K Weakest Rows in a Matrix

        // 1534. Count Good Triplets
        // 48. Rotate Image
        // 835. Image Overlap
        // 1389. Create Target Array in the Given Order
        // 162. Find Peak Element
        // 658. Find K Closest Elements
        // 566. Reshape the Matrix
        // 378. Kth Smallest Element in a Sorted Matrix
        // 1539. Kth Missing Positive Number
        // 1329. Sort the Matrix Diagonally
        // 1552. Magnetic Force Between Two Balls
        // 1512. Number of Good Pairs
        // 1769. Minimum Number of Operations to Move All Balls to Each Box
        // 1464. Maximum Product of Two Elements in an Array
        // 1572. Matrix Diagonal Sum
        // 74 , 1588, 1424, 7
        // 999. Available Captures for Rook
        // 1470,
        // 1351. Count Negative Numbers in a Sorted Matrix
        // 1401. Circle and Rectangle Overlapping
        // 1802. Maximum Value at a Given Index in a Bounded Array
        // 1385. Find the Distance Value Between Two Arrays
        // missing element in sorted array
        // 41. First Missing Positive
        // 1748. Sum of Unique Elements
        // 1323. Maximum 69 Number
        // 1819. Number of Different Subsequences GCDs
        // 1679. Max Number of K-Sum Pairs
        // 1380. Lucky Numbers in a Matrix
        // 1365. How Many Numbers Are Smaller Than the Current Number
        // 1488. Avoid Flood in The City


}