import java.util.ArrayList;
import java.util.List;

public class Combinations<T> {
    private ArrayList<T> collection;

    public Combinations(ArrayList<T> collection) {
        this.collection = collection;
    }

    public List<ArrayList<T>> generate(){
        List<ArrayList<T>> allCombinations = new ArrayList<>();
        for (int i = 0; i <= collection.size(); i++) {
            List<ArrayList<T>> kSizedCombinations = getSizedCombinations(collection, i);
            for (ArrayList<T> combination : kSizedCombinations) {
                allCombinations.add(combination);
            }
        }
        return allCombinations;
    }

    private List<ArrayList<T>> getSizedCombinations(final ArrayList<T> allStates, int length) {
        List<ArrayList<T>> kSizedCombs = new ArrayList<>();
        if (length > allStates.size() || length <= 0) {
            return kSizedCombs;
        }

        if (length == allStates.size()) {
            kSizedCombs.add(allStates);
            return kSizedCombs;
        }

        if (length == 1) {
            for (final T state : allStates) {
                kSizedCombs.add(new ArrayList<T>(){{add(state);}});
            }
            return kSizedCombs;
        }
        final ArrayList<T> uniqueSetOfStates = new ArrayList<>(allStates);
        for (int i = 0; i < new ArrayList<>(uniqueSetOfStates).size() - length + 1; i++) {
            final int finalI = i;
            ArrayList<T> head = new ArrayList<T>(){
                {add(uniqueSetOfStates.subList(finalI, finalI + 1).get(0));}
            };
            ArrayList<T> listOfStates = new ArrayList<>();
            for (T state : uniqueSetOfStates.subList(i + 1, allStates.size())) {
                listOfStates.add(state);
            }
            List<ArrayList<T>> tailCombs = new ArrayList<>(getSizedCombinations(listOfStates, length - 1));

            for (int j = 0; j < tailCombs.size(); j++) {
                head.addAll(new ArrayList<>(tailCombs.get(j)));
                ArrayList<T> states = new ArrayList<>();
                for (T state : new ArrayList<>(head)) {
                    states.add(state);
                }
                kSizedCombs.add(states);
                head = new ArrayList<T>(){{add(uniqueSetOfStates.subList(finalI, finalI + 1).get(0));}};
            }
        }
        return kSizedCombs;
    }
}
