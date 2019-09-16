/**
 * 二叉搜索树：
 * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉排序树。
 */
public class Answer_23 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0)
            return false;
        if (sequence.length == 1)
            return true;
        return judge(sequence, 0, sequence.length-1);
    }
    public boolean judge(int[] a, int start, int end){
        //设置跳出递归的条件
        if (start >= end)
            return true;
        int i = start;
        while (a[i] < a[end]){
            ++i;
        }
        for (int j = i; j < end; j++){
            if (a[j] < a[end])
                return false;
        }
        return judge(a, start, i - 1) && judge(a, i, end - 1);
    }
}
