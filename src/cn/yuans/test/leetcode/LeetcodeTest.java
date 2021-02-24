package cn.yuans.test.leetcode;

import java.util.*;

/**
 * @author yuans
 * @create 2020-04-18-20:36
 */
public class LeetcodeTest {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 1, 1};
        containsNearbyDuplicate(nums, 1);
        System.out.println(3/ 2);
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();
        //设min为当前重复数字最短距离
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (seen.containsKey(nums[i])) {
                //重复数字出现时两数距离
                int temp = i - seen.get(nums[i]);
                //求最小值
                min = Math.min(min, temp);
                if (min <= k) {
                    return true;
                }
                //修改hashMap保证未来出现重复数字之差为最小
                seen.replace(nums[i], i);
            } else {
                seen.put(nums[i], i);
            }
        }
        return false;
    }
}

