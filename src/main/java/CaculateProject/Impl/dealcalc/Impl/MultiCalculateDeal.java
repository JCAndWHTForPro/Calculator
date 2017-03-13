package CaculateProject.Impl.dealcalc.Impl;

import CaculateProject.Impl.dealcalc.CalculateDeal;
import CaculateProject.StackContainer;

/**
 * Created by 10192096 on 2017/3/13 0013.
 */
public class MultiCalculateDeal implements CalculateDeal{
    @Override
    public void cal() {
        Integer num1 = Integer.parseInt(StackContainer.operatorStack.pop());
        Integer num2 = Integer.parseInt(StackContainer.operatorStack.pop());
        StackContainer.operatorStack.push(String.valueOf(num1*num2));
    }
}
