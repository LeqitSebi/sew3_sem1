package slanitsch.ue00_whp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CollectionsTest {

    @Test

    public static void main(String[] args) {
        LinkedList<Double> test = new LinkedList<>(Arrays.asList(100d, 130d, 200d, 110d, 175d, 160d, 1d));
        cleanValues(test);
        System.out.println(test);
    }

    public static List<Integer> zip(List<Integer> a, List<Integer> b) {
        List<Integer> output = new LinkedList<>();
        int max = Math.max(a.size(), b.size());
        for (int i = 0; i < max; i++) {
            if (a.size() == max) {
                output.add(a.get(i));
                try {
                    output.add(b.get(i));
                } catch (Exception e) {
                    output.add(null);
                }
            }
            if (b.size() == max) {
                output.add(b.get(i));
                try {
                    output.add(a.get(i));
                } catch (Exception e) {
                    output.add(null);
                }
            }
        }
        return output;
    }

    private static void cleanValues(List<Double> data) {
        double min = data.get(0);
        double max = data.get(0);
        for (double d : data) {
            if (d < min) {
                min = d;
            }
            if (d > max) {
                max = d;
            }
        }
        double range = max - min;
        double teil = range / 4;
        Iterator<Double> it = data.iterator();
        while (it.hasNext()) {
            if (it.next() < min + teil) {
                it.remove();
            }
            if (it.next() < min + 4 * teil && it.next() > min + 3 * teil) {
                it.remove();
            }
        }
    }
}
