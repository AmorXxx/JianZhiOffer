
import java.util.ArrayList;

public class Answer_19 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (matrix.length == 0)
            return list;
        //避免空指针异常
        if (matrix[0].length == 0)
            return list;
        int hang = matrix.length;
        int lie = matrix[0].length;
        //要遍历的层数
        int layer = (Math.min(hang,lie) - 1)/2 + 1;
        for (int ceng = 0; ceng < layer; ceng++){
            //左至右
            for (int i = ceng; i < lie - ceng; i++) {
                list.add(matrix[ceng][i]);
            }
            //右上至右下
            for (int i = ceng + 1; i < hang - ceng; i++){
                list.add(matrix[i][lie - ceng - 1]);
            }
            //右至左
            for (int i = lie - 2 - ceng; i >= ceng && hang - ceng - 1 != ceng; i--){
                list.add(matrix[hang - ceng - 1][i]);
            }
            //左下至左上
            for (int i = hang - 2 - ceng; i > ceng && lie - ceng - 1 != ceng; i--){
                list.add(matrix[i][ceng]);
            }
        }
        return list;
    }
}
