/**
 * 输入三个数组，长度相同，斜着打印
 *
 * 如：
 * [1,2,3]
 * [4,5,6]
 * [7,8,9]
 *
 * 打印
 * 1,2,4,3,5,7,6,8,9
 */
public class Print_three_arrays_diagonally {
    public void Solution(int[] a, int[] b, int[] c){
        int p1 = 0;
        int p2 = -1;
        int p3 = -2;
        while (p3 < a.length){
            if (p1 >= 0 && p1 < a.length)
                System.out.print(a[p1] + " ");
            p1++;
            if (p2 >= 0 && p2 < a.length)
                System.out.print(b[p2] + " ");
            p2++;
            if (p3 >= 0)
                System.out.print(c[p3] + " ");
            p3++;
        }
    }
}
