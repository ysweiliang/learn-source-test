package cn.yuans.test.offer.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 大小为 K 的最小堆
 *
 * @author yuans
 * @create 2021-04-12-15:37
 */
public class Offer_40 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int k = 3;
        Offer_40 offer_40 = new Offer_40();
        ArrayList<Integer> retList = offer_40.GetLeastNumbers_Solution(nums, k);
        System.out.println(retList);
    }

    /**
     * 使用大顶堆。在添加一个元素之后，如果大顶堆的大小大于 K，那么将大顶堆的堆顶元素去除，
     * 也就是将当前堆中值最大的元素去除，从而使得留在堆中的元素都比被去除的元素来得小。
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] nums, int k) {
        if (k > nums.length || k <= 0)
            return new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            maxHeap.add(num);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        return new ArrayList<>(maxHeap);
    }
}
