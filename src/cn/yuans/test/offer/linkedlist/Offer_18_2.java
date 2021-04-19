package cn.yuans.test.offer.linkedlist;

/**
 * 删除链表中重复的结点
 *
 * @author yuans
 * @create 2021-04-12-17:27
 */
public class Offer_18_2 {

    public static void main(String[] args) {

    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            while (next != null && pHead.val == next.val)
                next = next.next;
            return deleteDuplication(next);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
}
