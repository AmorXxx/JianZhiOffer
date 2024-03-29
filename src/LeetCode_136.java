/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度O(n)。 你可以不使用额外空间来实现吗？
 *
 *
 * 解法：
 *  ^ 异或
 *  先转换成二进制数，相同取0 不同取1
 *
 *  特点：
 *  任何数异或0，都等于自身；
 *  任何数异或1，都等于自身取反；
 *  任何数异或自身，都等于0；
 *  任何数对同一个数异或两次之后，都等于自身
 */
public class LeetCode_136 {
    public int singleNumber(int[] nums) {

        for(int i = 1; i < nums.length; i++){
            nums[0] = nums[0] ^ nums[i];
        }
        return nums[0];
    }
}
