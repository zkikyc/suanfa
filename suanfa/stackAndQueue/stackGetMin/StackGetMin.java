package stackAndQueue.stackGetMin;

import java.util.Stack;

/**
 * 设计一个具有getMin方法的栈  要求 getMin  pop  push  时间复杂度均为O(1)
 */
public class StackGetMin {

    /**
     * 栈:先进后出  实现获取最小的栈  因为时间复杂度要求未O(1) 所以 不能进行遍历操作
     * 1.定义两个栈  minStack记录当前栈最小值  当插入元素比minStack栈顶元素小时 则插入minStack。 dataStack 记录实际的值
     * 假设 4,5,3,1,1 依次压入栈中 则minStack中 应该为4,3,1,1  dataStack为4,5,3,1,1
     * 弹出时  如果 dataStack 弹出的值 等于minStack中的栈顶元素  则一起弹出 当前 minStack栈顶元素始终为最小值
     *
     */
    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();


    public void push(int i) {
        dataStack.push(i);
        if (minStack.isEmpty()) {
            minStack.push(i);
            return;
        }
        if(minStack.peek()>=i){
            minStack.push(i);
        }
    }

    public Integer getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("没了!");
        }
        return minStack.peek();
    }

    public Integer pop(){
        if (dataStack.isEmpty()) {
            throw new RuntimeException("没了!");
        }
        Integer pop = dataStack.pop();
        if(minStack.peek() == pop){
           return minStack.pop();
        }
        return pop;
    }

    public static void main(String[] args) {
        StackGetMin stackGetMin = new StackGetMin();
        stackGetMin.push(3);
        stackGetMin.push(7);
        stackGetMin.push(4);
        stackGetMin.push(5);
        stackGetMin.push(1);
        stackGetMin.push(9);
        System.out.println(stackGetMin.pop());
        System.out.println(stackGetMin.pop());
        System.out.println(stackGetMin.pop());
        System.out.println(stackGetMin.getMin());
        System.out.println(stackGetMin.getMin());
    }
}