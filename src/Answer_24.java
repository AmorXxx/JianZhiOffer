import java.util.ArrayList;

public class Answer_24 {
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return listAll;
        list.add(root.val);
        target = target - root.val;
        if (target == 0 && root.right == null && root.left == null)
            //如果直接添加list，下面对list的操作还会改变listAll中list的值
            listAll.add(new ArrayList<Integer>(list));
        //深度优先遍历，先左后右
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);
        return listAll;
    }
}
