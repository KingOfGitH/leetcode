package middle;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by zhangborui
 * @classname GetAllElements_1305
 * @description TODO
 * @date 2022/5/2 15:47
 */
public class GetAllElements_1305 {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = treeToList(root1);
        List<Integer> l2 = treeToList(root2);
        int i = 0;
        for (Integer integer : l1) {
            if (i < l2.size() &&integer <= l2.get(i)) {
                l2.add(i++, integer);
            } else {
                while (i < l2.size() && integer > l2.get(i)) {
                    i++;
                }
                l2.add(i++, integer);
            }
        }
        return l2;
    }

    public List<Integer> treeToList(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            res.addAll(treeToList(root.left));
            res.add(root.val);
            res.addAll(treeToList(root.right));
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        root1.left=new TreeNode(1);
        root1.right=new TreeNode(4);
        TreeNode root2 = new TreeNode(1);
        root2.left=new TreeNode(0);
        root2.right=new TreeNode(3);
        GetAllElements_1305 getAllElements_1305 = new GetAllElements_1305();
        System.out.println(getAllElements_1305.treeToList(root1));
        System.out.println(getAllElements_1305.treeToList(root2));
    }


}
