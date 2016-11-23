import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ObjectCombinationTest {
    @Test
    public void shouldGenerateCombinationsForEmptyCollection() throws Exception {
        ArrayList<String> collection = new ArrayList<>();
        List<ArrayList<String>> combinations = new Combinations(collection).generate();
        assertThat(combinations.size(), is(0));
    }

    @Test
    public void shouldGenerateCombinationsForCollectionWithOneElement() throws Exception {
        String a = new String("a");
        ArrayList<String> collection = new ArrayList<>();
        collection.add(a);
        List<ArrayList<String>> combinations = new Combinations(collection).generate();

        assertThat(combinations.size(), is(1));
        assertThat(combinations.get(0), is(Arrays.asList(a)));
    }

    @Test
    public void shouldGenerateCombinationsForCollectionWithTwoElements() throws Exception {
        String a = new String("a");
        String b = new String("b");
        ArrayList<String> collection = new ArrayList<>();
        collection.add(a);
        collection.add(b);
        List<ArrayList<String>> combinations = new Combinations(collection).generate();

        assertThat(combinations.size(), is(3));
        assertThat(combinations.get(0), is(Arrays.asList(a)));
        assertThat(combinations.get(1), is(Arrays.asList(b)));
        assertThat(combinations.get(2), is(Arrays.asList(a, b)));
    }

    @Test
    public void shouldGenerateCombinationsForCollectionWithThreeElements() throws Exception {
        String a = new String("a");
        String b = new String("b");
        String c = new String("c");
        ArrayList<String> collection = new ArrayList<>();
        collection.add(a);
        collection.add(b);
        collection.add(c);
        List<ArrayList<String>> combinations = new Combinations(collection).generate();

        assertThat(combinations.size(), is(7));
        assertThat(combinations.get(0), is(Arrays.asList(a)));
        assertThat(combinations.get(1), is(Arrays.asList(b)));
        assertThat(combinations.get(2), is(Arrays.asList(c)));

        assertThat(combinations.get(3), is(Arrays.asList(a, b)));
        assertThat(combinations.get(4), is(Arrays.asList(a, c)));
        assertThat(combinations.get(5), is(Arrays.asList(b, c)));

        assertThat(combinations.get(6), is(Arrays.asList(a, b, c)));
    }
}
