package cn.yuans.test.offer.stack;

import java.util.Stack;

/**
 * 实现一个包含 min() 函数的栈，该方法返回当前栈中最小的值。
 *
 * @author yuans
 * @create 2021-04-12-15:11
 */
public class Offer_30 {
    /**
     * 使用一个额外的 minStack，栈顶元素为当前栈中最小的值。在对栈进行 push 入栈和 pop 出栈操作时，
     * 同样需要对 minStack 进行入栈出栈操作，从而使 minStack 栈顶元素一直为当前栈中最小的值。
     * 在进行 push 操作时，需要比较入栈元素和当前栈中最小值，将值较小的元素 push 到 minStack 中。
     */
    public static void main(String[] args) {
        Offer_30 offer_30 = new Offer_30();
        offer_30.push(3);
        offer_30.push(5);
        offer_30.push(8);
        offer_30.push(1);
        Integer min = offer_30.min();
        System.out.println(min);
    }

    private final Stack<Integer> dataStack = new Stack<>();
    private final Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
