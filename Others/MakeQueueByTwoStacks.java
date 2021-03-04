package Others;

import java.util.Stack;

/**
 * 用两个栈实现队列
 *
 * 当push的时候将元素push进stack1，pop的时候我们先把
 * stack1的元素pop到stack2，然后再对stack2执⾏pop操作，这样就可以保证是先进先出的。
 * （负[pop] * 负[pop]得正[先进先出]）
 *
 */
public class MakeQueueByTwoStacks {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    //push操作，将元素添加到stack1
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1.empty() && stack2.empty()) {
            throw new RuntimeException("Queue is empty");
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }


    public static void main(String[] args) {

    }
}
