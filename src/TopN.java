/**
 * 问题描述：
 * 如何从10亿数据中找出前n个最大的数
 */

import java.util.Random;

public class TopN {
    //父节点下标
    private int parent(int n){
        return (n - 1)/2;
    }

    //左节点下标
    private int left(int n){
        return n * 2 + 1;
    }

    //右节点下标
    private int right(int n){
        return n * 2 + 2;
    }

    //初始化小顶堆
    private void buildHeap(int n, int[] data){
        //取data的前N个数，维护成一个小顶堆
        for (int i = 1; i < n; i++){
            int t = i;
            //当数据未移动到根节点并且还比他的父节点小的时候说名此时还不是一个小顶堆
            while (t != 0 && data[t] < data[parent(t)]){
                int temp = data[t];
                data[t] = data[parent(t)];
                data[parent(t)] = temp;
                //数据的位置移动，下标自然也跟着移动
                t = parent(t);
            }
        }
    }

    //调整小顶堆
    private void adjust(int i, int n, int[] data){
        //若该值比堆顶小，直接丢弃
        if (data[i] <= data[0]){
            return;
        }

        //若该值比堆顶大，置换堆顶
        int temp = data[i];
        data[i] = data[0];
        data[0] = temp;

        //调整小顶堆
        int t = 0;
        while (right(t) < n && data[right(t)] < data[t] || left(t) < n && data[left(t)] < data[t]){
            //若右孩子比左孩子小，则右孩子和父节点置换
            if (right(t) < n && data[right(t)] < data[left(t)]){
                temp = data[t];
                data[t] = data[right(t)];
                data[right(t)] = temp;
                //保持下标和数值统一
                t = right(t);
            } // 若左孩子比右孩子小，则左孩子和父节点置换
            else {
                temp = data[t];
                data[t] = data[left(t)];
                data[left(t)] = temp;
                //保持数值和下标统一
                t = left(t);
            }
        }
    }

    public void findTopN(int n, int[] data){
        buildHeap(n, data);
        for (int i = n; i < data.length; i++){
            adjust(i, n, data);
        }
    }

    public void print(int[] data){
        for (int i = 0; i < data.length; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //第一组测试
        TopN topN = new TopN();
        int[] arr1 = new int[]{56, 30, 71, 18, 29, 93, 44, 75, 20, 65, 68, 34};
        System.out.println("原数组：");
        topN.print(arr1);
        topN.findTopN(5, arr1);
        System.out.println("调整后数组：");
        topN.print(arr1);

        //第二组测试
        int[] arr2 = new int[1000];
        for(int i=0; i<arr2.length; i++) {
            arr2[i] = i + 1;
        }

        System.out.println("原数组：");
        topN.print(arr2);
        topN.findTopN(50, arr2);
        System.out.println("调整后数组：");
        topN.print(arr2);

        //第三组测试
        Random random =new Random();
        int[] arr3 = new int[1000];
        for(int i=0; i<arr3.length; i++) {
            arr3[i] = random.nextInt();
        }

        System.out.println("原数组：");
        topN.print(arr3);
        topN.findTopN(50, arr3);
        System.out.println("调整后数组：");
        topN.print(arr3);

    }

}
