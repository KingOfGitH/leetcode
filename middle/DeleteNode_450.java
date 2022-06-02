package middle;

import common.TreeNode;

/**
 * @author by zhangborui
 * @classname DeleteNode_450
 * @description TODO
 * @date 2022/6/2 10:37
 */
public class DeleteNode_450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode left = root.left;
                while (left.right != null) {
                    left = left.right;
                }
                left.right = root.right;
                return root.left;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
//        root.right.right = new TreeNode(8);
//        root.left.left.left = new TreeNode(1);
//        root.left.left.right = new TreeNode(3);
//        root.right.left.left = new TreeNode(9);
//        root.right.left.right = new TreeNode(10);
//        root.right.right.left = new TreeNode(11);
//        root.right.right.right = new TreeNode(12);
        DeleteNode_450 deleteNode_450 = new DeleteNode_450();
        deleteNode_450.deleteNode(root, 3);
        System.out.println(root);
    }


}
