package slanitsch.ue03_RegExp;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTools {
    /**
     * ersetzt Doppelte Leerzeichen duch einzelne
     *
     * @param s der zu bearbeitende String
     * @return der bearbeitete String
     */
    static String removeMultiSpaces(String s) {
        Pattern p = Pattern.compile("[ ][ ]");
        Matcher m = p.matcher(s);
        s = m.replaceAll(" ");
        return s;
    }

    /**
     * teilt einen String an den Leerzeichen
     *
     * @param s input String
     * @return Sting[]
     */
    static String[] splitToLines(String s) {
        return s.split("\n");
    }

    /**
     * ein String wird an Zeilenubrüchen gesplitet in maxLen große Teile
     *
     * @param s      String der getielt wird
     * @param maxLen maximal Länge eines Strings
     * @return Ergebniss String[]
     */
    static List<String> splitToLines(String s, int maxLen) {
        List<String> list = new LinkedList<>();
        String[] split = s.split("\n");
        for (String s1 : split) {
            if (s1.length() <= maxLen) {
                list.add(s1);
            } else {
                while (s1.length() > maxLen) {
                    for (int i = maxLen; i >= 0; i--) {
                        if (s1.charAt(i) == ' ') {
                            list.add(s1.substring(0, i));
                            s1 = s1.substring(i + 1);
                            break;
                        }
                    }
                    list.add(s1);
                }
            }
        }
        return list;
    }
}