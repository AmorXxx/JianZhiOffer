import java.util.HashMap;

public class LeetCode_1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i]) && map.get(nums[i]) != i ){
                int[] res = {map.get(nums[i]), i};
                return res;
            }
            map.put(target - nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        LeetCode_1 leetCode_1 = new LeetCode_1();
        int[] arr = {3,3};
        leetCode_1.twoSum(arr, 6);
    }
}
