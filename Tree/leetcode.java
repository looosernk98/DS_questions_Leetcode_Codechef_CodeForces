import java.util.*;

class leetcode{
    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }
    public TreeNode sortedArrayToBST(int[] nums) {
        return solution(0,nums.length-1, nums);
    }
    
    public TreeNode solution(int si, int ei, int[] nums){
        if(si>ei) return null;
        
        int m = (si+ei)/2;
        
        TreeNode node = new TreeNode(nums[m]);
        
        node.left = solution(si, m-1, nums);
        node.right = solution(m+1, ei, nums);
        
        System.out.println(node.val+" "+node.left.val+" " +node.right.val);
        return node;
        
    }
   static ArrayList<Integer> list= new ArrayList<>();

    public static void main(String[] args){
        int[] arr = {-10,-3,0,5,9};
      leetcode leet = new leetcode();
      TreeNode root = leet.sortedArrayToBST(arr);
      display(root);
      System.out.println(list+" "+root.val);
    }

    public static void display(TreeNode root){
        if(root.left==null && root.right==null) return ;

        if(root.left==null || root.right==null){
            list.add(null);
            return ;
        } 

         list.add(root.val);
     
         display(root.left);
         display(root.right);

    }
}