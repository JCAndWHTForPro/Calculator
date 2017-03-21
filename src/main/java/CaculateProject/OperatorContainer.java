package CaculateProject;

import CaculateProject.Impl.dealcalc.CalculateDeal;
import CaculateProject.Impl.dealcalc.Impl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jicheng on 2017/3/13.
 */
public class OperatorContainer {
    private static Map<String, Integer> operatorMap = new HashMap<>();
    private static Map<String, CalculateDeal> calculateDealMap = new HashMap<>();

    private OperatorContainer() {
    }

    public static Map<String, Integer> getOperatorMap() {
        return operatorMap;
    }

    public static Map<String, CalculateDeal> getCalculateDealMap() {
        return calculateDealMap;
    }

    static {
        operatorMap.put("*", 20);
        operatorMap.put("/", 20);
        operatorMap.put("-", 19);
        operatorMap.put("+", 19);
        operatorMap.put(" and ", 18);
        operatorMap.put(" or ", 18);
        operatorMap.put("(", Integer.MAX_VALUE);
        operatorMap.put(")", Integer.MAX_VALUE);

        calculateDealMap.put("+", new PlusCalculateDeal());
        calculateDealMap.put("-", new MinusCalculateDeal());
        calculateDealMap.put("*", new MultiCalculateDeal());
        calculateDealMap.put("/", new DivisionCalculateDeal());
        calculateDealMap.put(" or ", new OrOperatorDeal());
        calculateDealMap.put(" and ", new AndOperatorDeal());
    }
}
