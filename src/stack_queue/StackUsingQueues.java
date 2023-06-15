/*
Implement a last-in-first-out (LIFO) stack using only two queues.
The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
Implement the MyStack class:
void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.
Notes:
You must use only standard operations of a queue, which means that only push to back, peek/pop from front,
size and is empty operations are valid.
Depending on your language, the queue may not be supported natively.
You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
https://leetcode.com/problems/implement-stack-using-queues/solutions/

TC: Push - O(1)
    Pop - O(n)
    Peek - O(1)
SC: O(n)
 */

package stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    static Queue<Integer> q1;
    static Queue<Integer> q2;

    public StackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        if(!q1.isEmpty()){
            q1.add(x);
        } else{
            q2.add(x);
        }
    }

    public int pop() {
        if(empty()){
            return -1;
        }
        int top =-1;
        if(!q1.isEmpty()){
            while(!q1.isEmpty()){
                top = q1.remove();
                if(q1.isEmpty()){
                    break;
                }
                q2.add(top);
            }
        } else{
            while(!q2.isEmpty()){
                top=q2.remove();
                if(q2.isEmpty()){
                    break;
                }
                q1.add(top);
            }
        }
        return top;
    }

    public int top() {
        if(empty()){
            return -1;
        }
        int top =-1;
        if(!q1.isEmpty()){
            while(!q1.isEmpty()){
                top = q1.remove();
                q2.add(top);
            }
        } else{
            while(!q2.isEmpty()){
                top=q2.remove();
                q1.add(top);
            }

        }
        return top;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues obj = new StackUsingQueues();
        obj.push(5);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }
}
