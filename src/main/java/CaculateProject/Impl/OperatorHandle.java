package CaculateProject.Impl;

import CaculateProject.Handle;
import CaculateProject.OperatorContainer;
import CaculateProject.StackContainer;

import java.util.LinkedList;
import java.util.Map;

/**
 * Created by jicheng on 2017/3/13.
 */
public class OperatorHandle implements Handle {
    @Override
    public void handle(String ch) {
        if (")".equals(ch)) {
            handleBracket();
        } else if (isLowerOperator(ch)) {
            String top = StackContainer.operatorStack.pop();
            StackContainer.numberStack.add(top);
            StackContainer.operatorStack.push(ch);
        } else {
            StackContainer.operatorStack.push(ch);
        }

    }

    private void handleBracket() {
        String operator;
        while (!(operator = StackContainer.operatorStack.pop()).equals("(")) {
            StackContainer.numberStack.add(operator);
        }
    }

    private boolean isLowerOperator(String ch) {
        Map<String, Integer> operatorMap = OperatorContainer.getOperatorMap();
        LinkedList<String> operatorStack = StackContainer.operatorStack;
        return !operatorStack.isEmpty() && operatorMap.get(ch) < operatorMap.get(operatorStack.peek()) && notBracket(operatorStack.peek());
    }

    private boolean notBracket(String ch) {
        return !ch.equals("(") && !ch.equals(")");
    }
}
