package cn.yuans.test.offer.stack;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作
 *
 * @author yuans
 * @create 2021-04-12-14:35
 */
public class Offer_9 {

    /**
     * in 栈用来处理入栈（push）操作，out 栈用来处理出栈（pop）操作。
     * 一个元素进入 in 栈之后，出栈的顺序被反转。
     * 当元素要出栈时，需要先进入 out 栈，此时元素出栈顺序再一次被反转，因此出栈顺序就和最开始入栈顺序是相同的，
     * 先进入的元素先退出，这就是队列的顺序。
     */
    public static void main(String[] args) throws Exception {
        Offer_9 offer_9 = new Offer_9();
        offer_9.push(1);
        offer_9.push(2);
        Integer pop = offer_9.pop();
        System.out.println(pop);
        Integer pop2 = offer_9.pop();
        System.out.println(pop2);
    }

    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    public void push(int node) {
        in.push(node);
    }

    public int pop() throws Exception {
        if (out.isEmpty())
            while (!in.isEmpty())
                out.push(in.pop());
        if (out.isEmpty())
            throw new Exception("queue is empty");
        return out.pop();
    }
}
