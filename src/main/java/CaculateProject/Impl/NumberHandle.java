package CaculateProject.Impl;

import CaculateProject.Handle;
import CaculateProject.StackContainer;

/**
 * Created by jicheng on 2017/3/13.
 */
public class NumberHandle implements Handle {
    @Override
    public void handle(char ch) {
        if(!StackContainer.numberStack.isEmpty()){
            String top = StackContainer.numberStack.pollLast();
            if(top.matches("\\d+")){
                top = top+String.valueOf(ch);
                StackContainer.numberStack.add(top);
            }
        }
    }
}
