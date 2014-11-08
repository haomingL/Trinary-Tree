// This class is used to store the information of each root of the TrinaryTree.
public class TrinaryTreeNode {
   public int data;
   public TrinaryTreeNode left;
   public TrinaryTreeNode right;
   public TrinaryTreeNode middle;
   
   // pre : input a valid int data.
   // post: store the data in the root.
   public TrinaryTreeNode (int data) {
      this(data, null, null, null);
   }
   
   // pre : input a valid data, left, right and middle node.
   // post: store them in the root.
   public TrinaryTreeNode (int data, TrinaryTreeNode left, TrinaryTreeNode right
         , TrinaryTreeNode middle) {
      this.data = data;
      this.left = left;
      this.right = right;
      this.middle = middle;
   }
}
