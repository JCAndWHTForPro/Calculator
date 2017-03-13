package CaculateProject.Impl;

import CaculateProject.Handle;
import CaculateProject.StackContainer;

/**
 * Created by jicheng on 2017/3/13.
 */
public class NumberHandle implements Handle {
    @Override
    public void handle(char ch) {
        String top = StackContainer.numberStack.pollLast();
        if(top == null){
            StackContainer.numberStack.add(String.valueOf(ch));
        }else if(top.matches("\\d+")){
            StackContainer.numberStack.add(top+String.valueOf(ch));
        }else{
            StackContainer.numberStack.add(top);
            StackContainer.numberStack.add(String.valueOf(ch));
        }
    }
}
