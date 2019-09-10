package slanitsch.ue00;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CollectionsTest {

    public static void main(String[] args) {
        LinkedList<Double> test = new LinkedList<>();
        test.addAll(Arrays.asList(new Double[]{100d, 130d, 200d, 110d, 175d, 160d}));
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

    public static void cleanValues(List<Double> data) {
        int total = 0;
        for (int i = 0; i < data.size(); i++) {
            total += data.get(i);
        }
        int[] quarters = new int[4];
        for (int i = 0; i < 3; i++) {
            quarters[i] = total / 4 * (i + 1);
        }
        for (int i = 0; i < data.size(); i++) {
            if (!(data.get(i) >= quarters[2] && data.get(i) <= quarters[3])) {
                data.remove(i);
            }
        }
    }
}
