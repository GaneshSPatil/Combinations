import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static List<ArrayList<Integer>> getCombinationsOf(ArrayList<Integer> set){
        List<ArrayList<Integer>> allCombinations = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= set.size(); i++) {
            List<ArrayList<Integer>> kSizedCombinations = getSizedCombinations(set, i);
            for (ArrayList<Integer> combination : kSizedCombinations) {
                allCombinations.add(combination);
            }
        }
        return allCombinations;
    }

    private static List<ArrayList<Integer>> getSizedCombinations(final ArrayList<Integer> allStates, int length) {
        List<ArrayList<Integer>> kSizedCombs = new ArrayList<ArrayList<Integer>>();
        if (length > allStates.size() || length <= 0) {
            return kSizedCombs;
        }

        if (length == allStates.size()) {
            kSizedCombs.add(allStates);
            return kSizedCombs;
        }

        if (length == 1) {
            for (final Integer state : allStates) {
                kSizedCombs.add(new ArrayList<Integer>(){{add(state);}});
            }
            return kSizedCombs;
        }
        final ArrayList<Integer> uniqueSetOfStates = new ArrayList<Integer>(allStates);
        for (int i = 0; i < new ArrayList<Integer>(uniqueSetOfStates).size() - length + 1; i++) {
            final int finalI = i;
            ArrayList<Integer> head = new ArrayList<Integer>(){
                {add(uniqueSetOfStates.subList(finalI, finalI + 1).get(0));}
            };
            ArrayList<Integer> listOfStates = new ArrayList<Integer>();
            for (Integer state : uniqueSetOfStates.subList(i + 1, allStates.size())) {
                listOfStates.add(state);
            }
            List<ArrayList<Integer>> tailCombs = new ArrayList<ArrayList<Integer>>(getSizedCombinations(listOfStates, length - 1));

            for (int j = 0; j < tailCombs.size(); j++) {
                head.addAll(new ArrayList<Integer>(tailCombs.get(j)));
                ArrayList<Integer> states = new ArrayList<Integer>();
                for (Integer state : new ArrayList<Integer>(head)) {
                    states.add(state);
                }
                kSizedCombs.add(states);
                head = new ArrayList<Integer>(){{add(uniqueSetOfStates.subList(finalI, finalI + 1).get(0));}};
            }
        }
        return kSizedCombs;
    }
}
