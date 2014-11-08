// This class constructs a TrinaryTree and implement add and delete function.
public class TrinaryTree {
   private TrinaryTreeNode root; // the overallRoot in the TrinaryTree
   
   // pre : input a int variable
   // post: add the data to the tree.
   public void add(int data) {
      root = add(root, data); 
   }
   
   // post: add the data to the given root.
   private TrinaryTreeNode add(TrinaryTreeNode root, int data) {
      if (root == null) {
         root = new TrinaryTreeNode(data);
      } 
      else if (root.data == data) {
         root.middle = add(root.middle, data);
      } 
      else if (root.data > data) {
         root.left = add(root.left, data);
      } 
      else {
         root.right = add(root.right, data);
      }
      return root;
   }
   
   // pre : delete the root with given data in the tree.
   // post: return true if the data exists in the tree or false if the data does
   //       not exist in the tree. If true, remove the data from the given tree.
   public boolean delete(int data) {
      if (root == null) {
         return false;
      } 
      else {
         TrinaryTreeNode current = root;// keep the track of the target root
         TrinaryTreeNode parent = null; // keep track of the parent root of the
                                        // target root.
         while (current != null) {
            if (data > current.data) {
               parent = current;
               current = current.right;
            } 
            else if (data < current.data) {
               parent = current;
               current = current.left;
            } 
            else { // data == current.data
               current.middle = null; // ensure that we delete the middle.
               if (current.left == null && current.right == null) { // given data is a leaf
                  if (current == root) {
                     root = null;
                  } 
                  else if (parent.left == current) {
                     parent.left = null;
                  } 
                  else { // parent.right == current
                     parent.right = null;
                  }
               } 
               else if (current.left == null || current.right == null) {
               // given data is a branch with only one child
                  if (current.left == null) {
                     if (current == root) {
                        root = current.right;
                     } 
                     else if (parent.left == current) {
                        parent.left = current.right;
                     } 
                     else {
                        parent.right = current.right;
                     }
                  } 
                  else {
                     if (current == root) {
                        root = current.left;
                     } 
                     else if (parent.left == current) {
                        parent.left = current.left;
                     } 
                     else {
                        parent.right = current.left;
                     }
                  }
               } 
               else { // given data is a branch with two children
                  current.left = findAndDelete(current.left, current);
               }
               return true;
            }
         }
         return false; // given data not found
      }
   }
   
   // post: find the rightmost leaf of the first left child of the target root.   
   private TrinaryTreeNode findAndDelete(TrinaryTreeNode current, TrinaryTreeNode target) {
      if (current.right == null) {
         target.data = current.data;
         current = current.left;
      } 
      else {
         current.right = findAndDelete(current.right, target);
      }
      return current;
   }
}
