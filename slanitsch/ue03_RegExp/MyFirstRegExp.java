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
        final Pattern ipv4 = Pattern.compile("([\\d]+)\\.(\\d+)\\.(\\d+)\\.(\\d)");

        Matcher matcher = ipv4.matcher(ip);

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
        final Pattern numberpattern = Pattern.compile("\\d+|\\d.\\d+|\\d+E\\d+|"
                + "\\d+\\.\\d+E\\d+|-\\d+|-\\d+\\d+.\\d+E\\d++|-\\d+\\d+.\\d+E-\\d++");

        return n.matches(String.valueOf(numberpattern));
    }

    /**
     * tests if string n has an even number of 0
     * tests if string n is a binary number
     *
     * @param n string
     * @return boolean
     */
    public static boolean hasEvenZeros(String n) {
        final Pattern binarypattern = Pattern.compile("(1*01*01*)*");
        return n.matches(String.valueOf(binarypattern));
    }


    /**
     * tests if string n has no doubles behind each other
     *
     * @param n string
     * @return boolean
     */
    public static boolean hasNoDoubles(String n) {
        final Pattern numberpattern = Pattern.compile("0|1|(01)*0?|(10)*1?");
        return n.matches(String.valueOf(numberpattern));
    }


    /**
     * tests if string n is valid class name
     *
     * @param n string
     * @return boolean
     */
    public static boolean isClassName(String n) {
        final Pattern classpattern = Pattern.compile("[A-Z]+[A-Za-z0-9](_[A-Za-z0-9]+)?");
        return n.matches(String.valueOf(classpattern));
    }

    /**
     * tests if string n is valid date
     *
     * @param n string
     * @return boolean
     */
    public static boolean isDate(String n) {
        final Pattern datepattern = Pattern.compile("(0[0-9]|[1-2][0-9]|3[0-1]|[1-9]).[ ]?(0[1-9]|1[0-2]|[1-9]).[ ]?([0-9]{2,4})?");
        return n.matches(String.valueOf(datepattern));
    }

    /**
     * gets first ip in string s
     *
     * @param s string
     * @return firstIP
     */
    public static String getFirstIp(String s) {
        final Pattern ippattern = Pattern.compile("(([\\d]+)\\.(\\d+)\\.(\\d+)\\.(\\d))+");

        for (int i = 0; i < s.length(); i++) {
            String firstIP = s.substring(0, i);
            if (i == s.length() - 1) {
                i++;
            }

            if (firstIP.matches(String.valueOf(ippattern))) {
                return firstIP;
            }
        }
        return null;
    }

    /**
     * gets first date in string s
     * @param s string
     * @return firstDate
     */
    /**
     * gets first date in string s
     *
     * @param s string
     * @return firstDate
     */
    public static String getFirstDate(String s) {
        final Pattern datepattern = Pattern.compile(("((0[0-9]|[1-2][0-9]|3[0-1]|[1-9]).[ ]?(0[1-9]|1[0-2]|[1-9]).[ ]?"
                + "([0-9][0-9][0-9][0-9]|[0-9][0-9])?)+"));

        if (s.matches(String.valueOf(datepattern))) {
            for (int i = 0; i < s.length(); i++) {
                String firstDate = s.substring(0, i);
                if (firstDate.matches(String.valueOf(datepattern))) {
                    return firstDate;
                }
            }
        }
        return null;
    }

    public static String removeMultiSpaces2(String s) {
        final Pattern spacepattern = Pattern.compile("[A-za-z0-9]+[ ]+[A-za-z0-9]+");
        return s.replaceAll(String.valueOf(spacepattern), " ");
    }
}
