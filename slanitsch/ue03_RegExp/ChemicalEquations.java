package slanitsch.ue03_RegExp;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChemicalEquations {

    public final static Pattern chemicalExpression = Pattern.compile("([A-Z][a-z])(\\d)(.*)");
    private final static Pattern FACTOR = Pattern.compile("(\\d*)\\s*(.+)");

    public static void main(String[] args) {
        String chemicalEq = "C6H12O6";
        Matcher m = chemicalExpression.matcher(chemicalEq);
        m.matches();
        System.out.println(m.group(1));
        System.out.println(getNumberOfAtoms("HCl + Na -> NaCl + H2"));
        System.out.println(analyze("HCl + Na -> NaCl + H2"));
        System.out.println(analyze("2 HCl + 2 Na -> 2 NaCl + H2"));
        System.out.println(analyze("12 CO2 + 6 H2O -> 2 C6H12O6 + 12 O2"));
    }


    /**
     * Gets the number of each atom of a chemical expression and puts the value into a map
     *
     * @param formula string
     * @return map map
     */
    public static Map<String, Integer> getNumberOfAtoms(String formula) {
        Map<String, Integer> map = new HashMap();
        // formula = formula.replaceAll(" ", "");

        for (String expression : formula.split("\\s*\\+\\s*")) {
            Matcher m = FACTOR.matcher(expression);
            m.matches();
            int factor = m.group(1).isEmpty() ? 1 : Integer.parseInt(m.group(1));
            String subSplitted = m.group(2);

            while (!subSplitted.isEmpty()) {
                Matcher mAtom = chemicalExpression.matcher(subSplitted);
                mAtom.matches();
                String atom = mAtom.group(1);
                int atomFactor = mAtom.group(2).isEmpty() ? 1 : Integer.parseInt(mAtom.group(2));
                subSplitted = mAtom.group(3);
                map.put(atom, map.getOrDefault(atom, 1) + factor * atomFactor);
            }
        }
        return map;
    }

    /**
     * Analyzes if the number of atoms in the reactant of a formula equals the number of the product
     *
     * @param formula string
     * @return boolean
     */
    public static boolean analyze(String formula) {
        String[] splitted = formula.split("\\s*->\\s*");
        Map map1 = getNumberOfAtoms(splitted[0]);
        Map map2 = getNumberOfAtoms(splitted[1]);
        return map1.equals(map2);
    }

}

