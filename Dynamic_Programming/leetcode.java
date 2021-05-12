
class leetcode{

// 746. Min Cost Climbing Stairs
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        
        dp[cost.length]=0;
        
        for(int i=cost.length-1; i>=0; i--){
            int min = Math.min(dp[i+1] , (i+2)<=cost.length ? dp[i+2] : 0);
            
            dp[i]= min+cost[i];
        }
        return Math.min(dp[0], dp[1]);
    } 

 public static void main(String[] args){

 }
 
}