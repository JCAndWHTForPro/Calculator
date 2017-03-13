package CaculateProject;

import CaculateProject.Impl.NumberHandle;
import CaculateProject.Impl.OperatorHandle;

import java.util.NoSuchElementException;
import java.util.Set;

/**
 * 算法：算术表达式解析器
 */
public class App {
    private static Handle numberHandle = new NumberHandle();
    private static Handle operatorHandle = new OperatorHandle();


    public Object getResult(String calculate) {
        StackContainer.numberStack.clear();
        StackContainer.operatorStack.clear();
        int i = 0;
        while (i < calculate.length()) {
            String keyWord;
            if ((keyWord = nextOperator(i, calculate)) != null) {
                i = i + keyWord.length();
                App.operatorHandle.handle(keyWord);
            } else if (!(keyWord = nextNumber(i, calculate)).equals("")) {
                i = i + keyWord.length();
                App.numberHandle.handle(keyWord);
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

    private String nextOperator(int index, String expression) {
        Set<String> keySet = OperatorContainer.getOperatorMap().keySet();
        for (String key : keySet) {
            int end = index + key.length();
            if (key.equals(expression.substring(index, end))) {
                return key;
            }
        }
        return null;
    }

    private String nextNumber(int index, String expression) {
        StringBuilder sb = new StringBuilder("");
        while (expression.charAt(index) >= 48 && expression.charAt(index) <= 57) {
            sb.append(expression.charAt(index));
            index++;
        }
        return sb.toString();
    }
}
