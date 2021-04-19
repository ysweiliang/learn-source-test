package cn.yuans.test.offer.pointer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 在有序数组中找出两个数，使得和为给定的数 S。
 * 如果有多对数字的和等于 S，输出两个数的乘积最小的。
 *
 * @author yuans
 * @create 2021-04-12-16:51
 */
public class Offer_57_1 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 5, 6, 7, 9, 3};
        int target = 7;
        Offer_57_1 offer_57_1 = new Offer_57_1();
        ArrayList<Integer> retList = offer_57_1.FindNumbersWithSum(nums, target);
        System.out.println(retList);
    }

    /**
     * 使用双指针，一个指针指向元素较小的值，一个指针指向元素较大的值。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
     * <p>
     * 如果两个指针指向元素的和 sum == target，那么这两个元素即为所求。
     * 如果 sum > target，移动较大的元素，使 sum 变小一些；
     * 如果 sum < target，移动较小的元素，使 sum 变大一些。
     */
    public ArrayList<Integer> FindNumbersWithSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int cur = nums[i] + nums[j];
            if (cur == target)
                return new ArrayList<>(Arrays.asList(nums[i], nums[j]));
            if (cur < target)
                i++;
            else
                j--;
        }
        return new ArrayList<>();
    }
}
