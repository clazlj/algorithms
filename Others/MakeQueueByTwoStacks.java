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
public class MakeQueueByTwoStacks<E> {
    private final Stack<E> stack1 = new Stack<>();
    private final Stack<E> stack2 = new Stack<>();

    //push操作，将元素添加到stack1
    public void push(E node) {
        stack1.push(node);
    }

    public E pop() {
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
        MakeQueueByTwoStacks<Integer> queue = new MakeQueueByTwoStacks<>();

        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);


        // 一旦pop，中途再push的只能等待pop完，后面的pop才能取到中途push的元素
        System.out.println(queue.pop() + "出队列");
        System.out.printf("stack1元素个数%s,stack2元素个数%s\n", queue.stack1.size(), queue.stack2.size());

        System.out.println(queue.pop() + "出队列");
        System.out.printf("stack1元素个数%s,stack2元素个数%s\n", queue.stack1.size(), queue.stack2.size());

        System.out.println("pop的中途push一个元素");
        queue.push(5);
        System.out.printf("stack1元素个数%s,stack2元素个数%s\n", queue.stack1.size(), queue.stack2.size());

        System.out.println(queue.pop() + "出队列");
        System.out.printf("stack1元素个数%s,stack2元素个数%s\n", queue.stack1.size(), queue.stack2.size());

        System.out.println(queue.pop() + "出队列");
        System.out.printf("stack1元素个数%s,stack2元素个数%s\n", queue.stack1.size(), queue.stack2.size());


        // pop四次后才能pop到5
        System.out.println(queue.pop() + "出队列");
        System.out.printf("stack1元素个数%s,stack2元素个数%s", queue.stack1.size(), queue.stack2.size());

        System.out.println(queue.pop() + "出队列");
    }
}
