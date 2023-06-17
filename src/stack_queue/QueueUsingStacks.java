/*
Implement a first in first out (FIFO) queue using only two stacks.
The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
Implement the MyQueue class:
void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:
You must use only standard operations of a stack, which means only push to top,
peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively.
You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.

TC: Push - O(1)
    Pop - O(n)
    Peek - O(1)
SC: O(n)
 */

package stack_queue;

import java.util.Stack;

public class QueueUsingStacks {
    private final Stack<Integer> values = new Stack<>();
    public void push(int x) {
        Stack<Integer> tmpValues = new Stack<>();
        //read all stored elements and put all in new stack in reverse order:
        // a) read from top to tail (where on top stored newest elements)
        // b) write all values in new order (where on top stored oldest elements)
        // * delete all readed values from stack
        while (!this.values.isEmpty()) {
            tmpValues.push(values.pop());
        }
        // add new value on the top on a stack (it will ne first value on stored stack)
        this.values.push(x);
        // Move all elements back from the tmp stack to the stored, where:
        // a) new value x will be on the tail of stored values
        // b) all stored values will store like FIFO
        while (!tmpValues.isEmpty()) {
            this.values.push(tmpValues.pop());
        }
    }

    public int pop() {
        return values.pop();
    }

    public int peek() {
        return values.peek();
    }

    public boolean empty() {
        return values.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacks obj = new QueueUsingStacks();
        obj.push(5);
        obj.push(2);
        int param_3 = obj.peek();
        int param_2 = obj.pop();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }
}
