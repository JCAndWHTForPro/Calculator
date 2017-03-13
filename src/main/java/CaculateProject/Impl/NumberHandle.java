package CaculateProject.Impl;

import CaculateProject.Handle;
import CaculateProject.OperatorContainer;
import CaculateProject.StackContainer;

/**
 * Created by jicheng on 2017/3/13.
 */
public class NumberHandle implements Handle {
    @Override
    public void handle(String ch) {
        StackContainer.numberStack.add(ch);
    }
}
