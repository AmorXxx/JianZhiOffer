
import java.util.ArrayList;

public class Answer_21 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        ArrayList<Integer> list = new ArrayList<>();
        //先确定两个数组除顺序外是否相同
        pit:for (int k = 0; k < pushA.length; k++) {
            list.add(pushA[k]);
            for (int l = 0; l < popA.length; l++) {
                if (pushA[k] == popA[l])
                    continue pit;
            }
            return false;
        }
        //判断原则：popA中下标为ide元素不能为pushA中0到i-1得元素
        hook:
        for (int i = 0; i < popA.length - 1; i++) {
            int a = popA[i];
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == a) {
                        if (j == 0) {
                            continue hook;
                        } else {
                            for (int n = 0; n < j -1; n++) {
                                if (popA[i + 1] == list.get(n)) return false;
                                else continue hook;
                            }
                        }
                }
            }
        }
        return true;
    }
}

