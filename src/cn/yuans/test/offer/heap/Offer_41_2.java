package cn.yuans.test.offer.heap;

import cn.yuans.test.offer.array.Offer_50;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。
 * 当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。
 *
 * @author yuans
 * @create 2021-04-12-16:14
 */
public class Offer_41_2 {

    public static void main(String[] args) {
        Offer_41_2 offer_41_2 = new Offer_41_2();
        offer_41_2.Insert('a');
        offer_41_2.Insert('b');
        offer_41_2.Insert('a');
        offer_41_2.Insert('c');
        offer_41_2.Insert('c');
        char c = offer_41_2.FirstAppearingOnce();
        System.out.println(c);
    }

    private final int[] cnts = new int[128];
    private final Queue<Character> queue = new LinkedList<>();

    public void Insert(char ch) {
        cnts[ch]++;
        queue.add(ch);
        while (!queue.isEmpty() && cnts[queue.peek()] > 1)
            queue.poll();
    }

    public char FirstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }
}
