public class LeetCode_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = (nums1.length + nums2.length) / 2 + 1;
        int[] arr = new int[length];
        return sort(arr, nums1, nums2);
    }

    private double sort(int[] arr, int[] nums1, int[] nums2){
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        while (p1 < nums1.length || p2 < nums2.length){
            if (p3 == arr.length) break;
            if (p1 == nums1.length) {
                arr[p3++] = nums2[p2++];
                continue;
            }
            if (p2 == nums2.length) {
                arr[p3++] = nums1[p1++];
                continue;
            }
            arr[p3++] = Math.min(nums1[p1], nums2[p2]);
            if (nums1[p1] < nums2[p2]) p1++;
            else p2++;
        }
        if (arr.length == 1){
            return arr[0];
        }
        if ((nums1.length + nums2.length) % 2 == 0){
            return ((double) arr[arr.length - 1] +(double) arr[arr.length - 2]) / 2.0;
        }
        return arr[arr.length - 1];
    }


    public static void main(String[] args) {
        LeetCode_4 leetCode_4 = new LeetCode_4();
        int[] nums1 = {};
        int[] nums2 = {2,3};
        double res = leetCode_4.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }
}
