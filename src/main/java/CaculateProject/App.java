package CaculateProject;

import CaculateProject.Impl.NumberHandle;
import CaculateProject.Impl.OperatorHandle;

import java.util.NoSuchElementException;

/**
 * 算法：算术表达式解析器
 */
public class App {
    private static Handle numberHandle = new NumberHandle();
    private static Handle operatorHandle = new OperatorHandle();


    public Object getResult(String calculate) {
        for (int i = 0; i < calculate.length(); i++) {
            char ch = calculate.charAt(i);
            if (isOperatorChar(ch)) {
                App.operatorHandle.handle(ch);
            } else if (isNumber(ch)) {
                App.numberHandle.handle(ch);
            } else{
                continue;
            }
        }
        lastOperatorStackToNumberStack();
        return calculateResult();
    }

    private void lastOperatorStackToNumberStack() {
        while (true) {
            try {
                StackContainer.numberStack.add(StackContainer.operatorStack.pop());
            } catch (NoSuchElementException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    private Object calculateResult() {
        StackContainer.operatorStack.clear();
        for (String str : StackContainer.numberStack) {
            if (OperatorContainer.getCalculateDealMap().keySet().contains(str)) {
                OperatorContainer.getCalculateDealMap().get(str).cal();
            } else {
                StackContainer.operatorStack.push(str);
            }
        }
        return StackContainer.operatorStack.pop();
    }

    private boolean isOperatorChar(char ch) {
        return OperatorContainer.getOperatorMap().keySet().contains(String.valueOf(ch));
    }

    private boolean isNumber(char ch) {
        return String.valueOf(ch).matches("\\w+");
    }
}
