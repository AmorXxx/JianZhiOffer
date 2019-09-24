public class Answer_26_2 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null){
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null){
            return pRootOfTree;
        }
        //将左子树构成双链表，并返回头节点。
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode p = left;
        //定位至左双链表的最后一个节点
        while (p != null && p.right != null){
            p = p.right;
        }
        //如果左子树不为空则将整个大树的根节点连接至左双链表的最后一位
        if (left != null){
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }
        //将右子树构成双链表并返回头节点
        TreeNode right = Convert(pRootOfTree.right);
        //如果右子树不为空的话则将该双链表追加到大树根节点之后
        if (right != null){
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        return left != null ? left : pRootOfTree;
    }
}
