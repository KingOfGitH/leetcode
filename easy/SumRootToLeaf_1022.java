package easy;

import common.TreeNode;

/**
 * @author by zhangborui
 * @classname SumRootToLeaf_1022
 * @description TODO
 * @date 2022/5/30 8:34
 */
public class SumRootToLeaf_1022 {
    int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        sumRootToLeaf(root, new StringBuilder());
        return sum;
    }

    public void sumRootToLeaf(TreeNode root, StringBuilder sb) {
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            sum += Integer.parseInt(sb.toString(), 2);
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        if (root.left != null) {
            sb.append(root.val);
            sumRootToLeaf(root.left, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (root.right != null) {
            sb.append(root.val);
            sumRootToLeaf(root.right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
