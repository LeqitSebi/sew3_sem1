package slanitsch.ue03_RegExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * the exercise is about regex and patterns
 */
public class MyFirstRegExp {
    /**
     * main method
     *
     * @param args methods
     */
    public static void main(String[] args) {
        System.out.println(getFirstIp("192.168.1.0192.168.1.0"));
    }

    /**
     * tests if string ip is ipv4
     *
     * @param ip ip
     * @return boolean
     */
    public static boolean isIP(String ip) {
        final Pattern ip_pattern = Pattern.compile("([\\d]+)\\.(\\d+)\\.(\\d+)\\.(\\d)");

        Matcher matcher = ip_pattern.matcher(ip);

        if (matcher.matches()) {
            for (int i = 1; i < 4; i++) {
                if (Integer.parseInt(matcher.group(i)) >= 0 && Integer.parseInt(matcher.group(i)) <= 255) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * tests if string n is allowed
     *
     * @param n number
     * @return boolean
     */
    public static boolean isNumber(String n) {
        final Pattern number_pattern = Pattern.compile("\\d+|\\d.\\d+|\\d+E\\d+|" +
                "\\d+\\.\\d+E\\d+|-\\d+|-\\d+\\d+.\\d+E\\d++|-\\d+\\d+.\\d+E-\\d++");

        return n.matches(String.valueOf(number_pattern));
    }

    /**
     * tests if string n has an even number of 0
     * tests if string n is a binary number
     *
     * @param n string
     * @return boolean
     */
    public static boolean hasEvenZeros(String n) {
        final Pattern binary_pattern = Pattern.compile("(1*01*01*)*");
        return n.matches(String.valueOf(binary_pattern));
    }

    //TODO: Geht nur mit geraden Zahlen

    /**
     * tests if string n has no doubles behind each other
     *
     * @param n string
     * @return boolean
     */
    public static boolean hasNoDoubles(String n) {
        final Pattern number_pattern = Pattern.compile("(10)*|(01)*|1|0|(010)*|(101)*");
        return n.matches(String.valueOf(number_pattern));
    }

    /**
     * tests if string n is valid class name
     *
     * @param n string
     * @return boolean
     */
    public static boolean isClassName(String n) {
        final Pattern class_pattern = Pattern.compile("[A-Z]+[a-z]*[0-9]*_*[A-Z]*?[a-z]*?[0-9]*");
        return n.matches(String.valueOf(class_pattern));
    }

    /**
     * tests if string n is valid date
     *
     * @param n string
     * @return boolean
     */
    public static boolean isDate(String n) {
        final Pattern date_pattern = Pattern.compile("(0[0-9]|[1-2][0-9]|3[0-1]|[1-9]).[ ]?(0[1-9]|1[0-2]|[1-9]).[ ]?([0-9][0-9][0-9][0-9]|[0-9][0-9])?");
        return n.matches(String.valueOf(date_pattern));
    }

    /**
     * gets first ip in string s
     *
     * @param s string
     * @return firstIP
     */
    public static String getFirstIp(String s) {
        final Pattern ip_pattern = Pattern.compile("(([\\d]+)\\.(\\d+)\\.(\\d+)\\.(\\d))+");

        if (s.matches(String.valueOf(ip_pattern))) {
            for (int i = 0; i < s.length(); i++) {
                String firstIP = s.substring(0, i);
                if (firstIP.matches(String.valueOf(ip_pattern))) {
                    return firstIP;
                }
            }
        }

        return "Keine gültige IP gefunden.";
    }

    /**
     * gets first date in string s
     * @param s string
     * @return firstDate
     */
    public static String getFirstDate(String s) {
        final Pattern date_pattern = Pattern.compile(("((0[0-9]|[1-2][0-9]|3[0-1]|[1-9]).[ ]?(0[1-9]|1[0-2]|[1-9]).[ ]?" +
                "([0-9][0-9][0-9][0-9]|[0-9][0-9])?)+"));

        if (s.matches(String.valueOf(date_pattern))) {
            for (int i = 0; i < s.length(); i++) {
                String firstDate = s.substring(0, i);
                if (firstDate.matches(String.valueOf(date_pattern))) {
                    return firstDate;
                }
            }
        }
        return "Kein gültiges Datum gefunden.";
    }
}
