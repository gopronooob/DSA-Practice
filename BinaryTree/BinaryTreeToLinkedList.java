/*
**************** Problem Description ****************
Given the root of a binary tree, flatten the tree into a "linked list":
The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and
the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.
  Example 1 : 
  Input: root = [1,2,5,3,4,null,6]
  Output: [1,null,2,null,3,null,4,null,5,null,6]
  Example 2 : 
  Input: root = []
  Output: []
  Example 3 : 
  Input: root = [0]
  Output: [0]
*/

/*
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

class Solution {
    public void flatten(TreeNode root) {

        if(root == null) return;


        flattenTreeDFS(root);
    }

    public TreeNode flattenTreeDFS(TreeNode root)
    {
        if(root==null) return null;

        TreeNode leftTail=flattenTreeDFS(root.left);
        TreeNode rightTail=flattenTreeDFS(root.right);

        if(leftTail!=null)
        {
            TreeNode temp=root.right;
            root.right=root.left;
            leftTail.right=temp;
            root.left=null;
        }

        if(rightTail !=null) return rightTail;
        if(leftTail !=null) return leftTail;

        return root;


    }
}



/*
**************** Logic ****************
Recursively flatten left and right subtree for each node.
Merge the flattened left and right subtree for each node.
*/