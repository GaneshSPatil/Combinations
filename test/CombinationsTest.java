import org.hamcrest.Matcher;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CombinationsTest {
    @Test
    public void shouldGenerateCombinationsForEmptyCollection() throws Exception {
        ArrayList<Integer> collection = new ArrayList<>();
        List<ArrayList<Integer>> combinations = Combinations.getCombinationsOf(collection);
        assertThat(combinations.size(), is(0));
    }

    @Test
    public void shouldGenerateCombinationsForCollectionWithOneElement() throws Exception {
        ArrayList<Integer> collection = new ArrayList<>();
        collection.add(1);
        List<ArrayList<Integer>> combinations = Combinations.getCombinationsOf(collection);

        assertThat(combinations.size(), is(1));
        assertThat(combinations.get(0), is(Arrays.asList(1)));
    }

    @Test
    public void shouldGenerateCombinationsForCollectionWithTwoElements() throws Exception {
        ArrayList<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        List<ArrayList<Integer>> combinations = Combinations.getCombinationsOf(collection);

        assertThat(combinations.size(), is(3));
        assertThat(combinations.get(0), is(Arrays.asList(1)));
        assertThat(combinations.get(1), is(Arrays.asList(2)));
        assertThat(combinations.get(2), is(Arrays.asList(1, 2)));
    }

    @Test
    public void shouldGenerateCombinationsForCollectionWithThreeElements() throws Exception {
        ArrayList<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        List<ArrayList<Integer>> combinations = Combinations.getCombinationsOf(collection);

        assertThat(combinations.size(), is(7));
        assertThat(combinations.get(0), is(Arrays.asList(1)));
        assertThat(combinations.get(1), is(Arrays.asList(2)));
        assertThat(combinations.get(2), is(Arrays.asList(3)));

        assertThat(combinations.get(3), is(Arrays.asList(1, 2)));
        assertThat(combinations.get(4), is(Arrays.asList(1, 3)));
        assertThat(combinations.get(5), is(Arrays.asList(2, 3)));

        assertThat(combinations.get(6), is(Arrays.asList(1, 2, 3)));
    }
}