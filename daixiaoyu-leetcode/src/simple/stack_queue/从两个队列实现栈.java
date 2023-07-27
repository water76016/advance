package simple.stack_queue;

import java.util.Stack;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-07-27 23:40
 **/
public class 从两个队列实现栈 {
    private Stack<Integer> one;
    private Stack<Integer> two;
    public 从两个队列实现栈() {
        this.one = new Stack<Integer>();
        this.two = new Stack<Integer>();
    }

    public void appendTail(int value) {
        one.push(value);
    }

    public int deleteHead() {
        if (two.size() > 0){
            return two.pop();
        }
        else {
            if (two.size() == 0 && one.size() == 0){
                return -1;
            }
            //把one的数，全部弄到two里面，然后再把two弹出
            while (one.size() > 0){
                int temp = one.pop();
                two.push(temp);
            }
            return two.pop();
        }
    }
}
