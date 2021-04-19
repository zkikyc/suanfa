package stackAndQueue.stackToQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 使用栈来实现一个队列
 */
public class StackToQueue {

    //栈:先进后出  队列:先进后出
    //顺序刚好相反  那么使用两个栈 进行 push 和 pop操作  刚好满足题意
    //push:  将数据全部插入到pushStack中
    //pop:  从popStack中取  没有的话  将pushStack中的元素 全部压入popStack 再进行pop操作

    //时间复杂度分析 push  O(1)   pop 最坏情况  遍历一次 pushStack 压入popStack  O(N)  最好情况 直接从popStack中取 O(1)
    Stack<Integer> popStack = new Stack<>();
    Stack<Integer> pushStack = new Stack<>();


    public Integer pop() {
        if(popStack.isEmpty()&&pushStack.isEmpty()){
            throw new RuntimeException("没了!");
        }
        if (!popStack.isEmpty()) {
            return popStack.pop();
        }
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
        return popStack.pop();
    }
    public Integer peek() {
        if(popStack.isEmpty()&&pushStack.isEmpty()){
            throw new RuntimeException("没了!");
        }
        if (!popStack.isEmpty()) {
            return popStack.peek();
        }
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
        return popStack.peek();
    }

    public void push(int i) {
        pushStack.push(i);
    }

    public static void main(String[] args) {
        StackToQueue stackToQueue = new StackToQueue();
        Queue<Integer> queue = new LinkedList<>();
        for (int j = 0;j<100;j++){
            for(int i = 0;i<1000;i++){
                int k = (int)(Math.random()*1000);
                stackToQueue.push(k);
                queue.add(k);
            }
            while(!queue.isEmpty()){
                if(!queue.poll().equals(stackToQueue.pop())){
                    System.out.println("false");
                }
            }
        }

        System.out.println("success");
    }
}
