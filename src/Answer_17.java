public class Answer_17 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        //约定：空树不是任意一个树的子结构
        if (root1 == null || root2 == null){
            return false;
        }
        //如果根节点相同，则走judge判断子树
        if (root1.val == root2.val){
            if (judge(root1,root2)){
                return true;
            }
        }
        //如果根节点不同，再遍历root1的左子树和右子树，直到找到相同的根节点。
        return HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
    }
    //遍历子树
    public static boolean judge(TreeNode root1, TreeNode root2){
        //如果小树被遍历空，则说明全部匹配，返回true
        if (root2 == null){
            return true;
        }
        //如果小树还没被遍历空大树已经被遍历空，则说明不匹配，返回false
        if (root1 == null){
            return false;
        }
        //根节点相同后再判断左右子树是否相同
        if (root1.val == root2.val){
            return judge(root1.right,root2.right) && judge(root1.left,root2.left);
        }
        return false;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
