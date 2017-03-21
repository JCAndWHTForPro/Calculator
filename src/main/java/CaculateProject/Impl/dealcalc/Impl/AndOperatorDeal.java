package CaculateProject.Impl.dealcalc.Impl;

import CaculateProject.Impl.dealcalc.CalculateDeal;
import CaculateProject.StackContainer;

/**
 * Created by 10192096 on 2017/3/21 0021.
 */
public class AndOperatorDeal implements CalculateDeal {
    @Override
    public void cal() {
        String operatorNum1 = StackContainer.operatorStack.pop();
        String operatorNum2 = StackContainer.operatorStack.pop();
        if(isFalse(operatorNum2)){
            StackContainer.operatorStack.push("false");
        }else{
            StackContainer.operatorStack.push(String.valueOf(!isFalse(operatorNum1)));
        }
    }
    private boolean isFalse(String str){
        return str.matches("|false|\\[\\]|\\{\\}|null|0");
    }
}
