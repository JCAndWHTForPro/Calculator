package CaculateProject.Impl.dealcalc.Impl;

import CaculateProject.Impl.dealcalc.CalculateDeal;
import CaculateProject.StackContainer;

/**
 * Created by 10192096 on 2017/3/21 0021.
 */
public class OrOperatorDeal implements CalculateDeal {
    @Override
    public void cal() {
        String operatorNum1 = StackContainer.operatorStack.pop();
        String operatorNum2 = StackContainer.operatorStack.pop();
        if(isTrue(operatorNum2)){
            StackContainer.operatorStack.push("true");
        }else{
            StackContainer.operatorStack.push(String.valueOf(isTrue(operatorNum1)));
        }
    }

    private boolean isTrue(String str){
        return !str.matches("|false|\\[\\]|\\{\\}|null|0");
    }
}
