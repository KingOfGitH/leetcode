package easy;

import common.Node;

import java.util.LinkedList;
import java.util.List;

/**
 * @author by zhangborui
 * @classname Preorder_589
 * @description TODO
 * @date 2022/3/10 22:41
 */
public class Preorder_589 {
    List<Integer> res=new LinkedList<>();
    public List<Integer> preorder(Node root) {
        if (root != null) {
            res.add(root.val);
            for (Node child : root.children) {
                preorder(child);
            }
        }
        return res;
    }
}
