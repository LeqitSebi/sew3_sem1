package slanitsch.ue03_RegExp;

import org.junit.jupiter.api.Test;

import slanitsch.ue03_RegExp.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static slanitsch.ue03_RegExp.HTMLStringTools.*;
import static slanitsch.ue03_RegExp.MyFirstRegExp.*;
import static slanitsch.ue03_RegExp.StringTools.splitToLines;

/**
 * tests methods from "MyFirstRegExp"
 */
class MyFirstRegExpTest {

    /**
     * test method "ipTest"
     */
    @Test
    void isIPt_TEST() {
        assertTrue(isIP("192.168.1.0"));
        assertFalse(isIP("256.0.20.68"));
        assertFalse(isIP("7..0.0.0"));
    }

    /**
     * tests method "isNumber(String n)"
     */
    @Test
    void isNumber_TEST() {
        assertFalse(isNumber("-24234E91.0"));
        assertTrue(isNumber("-99"));
        assertTrue(isNumber("-1245435.78E-91"));
    }

    /**
     * tests method "hasEvenZeros(String n)"
     */
    @Test
    void hasEvenZeros_TEST() {
        assertTrue(hasEvenZeros("001100"));
        assertFalse(hasEvenZeros("0011002"));
        assertFalse(hasEvenZeros("0011000"));
    }

    //TODO: Test "hasNoDoubles()"
    void hasNoDoubles_TEST() {

    }

    /**
     * tests method "isClassName(String n)"
     */
    @Test
    void isClassName_TEST() {
        assertTrue(isClassName("UE_03"));
        assertFalse(isClassName("Ue_03_"));
        assertFalse(isClassName("03_ue"));
    }

    /**
     * tests method "getFirstIP(String s)"
     */
    @Test
    void getFirstIP_TEST() {
        assertEquals("192.168.0.1", getFirstIp("192.168.0.177.0.1.6"));
        assertEquals("27.99.45.1", getFirstIp("27.99.45.1"));               //Warum falsch nur bei 1 IP?
        assertEquals("192.168.0.1", getFirstIp("192.168.0.177.0.1.6"));
    }

    /**
     * tests method "isDate(String n)
     */
    @Test
    void isDate_TEST() {
        assertTrue(isDate("1.1."));
        assertTrue(isDate("31. 11. 14"));
        assertFalse(isDate("001.1.2011"));
        assertFalse(isDate("23.12.196"));
    }

    @Test
    void getFirstDate_TEST() {
        assertEquals("1.1.", getFirstDate("1.1.31. 12. 1408. 1.2014"));         //Nimmt nur TT.MM? Warum?
        assertEquals("31. 12. 14", getFirstDate("31. 12. 141.1.08. 1.2014"));
    }

    /**
     * Test Methode für MyFirstRegExp
     */
    @Test
    public void testIPAdress() {
        //-----
        //A

        // Tests isIP()
        String ip1 = "192.168.0.1";
        assertTrue(isIP(ip1));
        String ip2 = "-1.0.0.0";
        assertFalse(isIP(ip2));
        String ip3 = "1.0.0.900";
        assertFalse(isIP(ip3));

        //Test isNumber
        String num1 = "4321234";
        assertTrue(isNumber(num1));
        String num2 = "-12341234";
        assertTrue(isNumber(num2));
        String num3 = "-1234.1234";
        assertTrue(isNumber(num3));
        String num4 = "1a234.1234";
        assertFalse(isNumber(num4));
        String num5 = "1.12345e9";
        assertTrue(isNumber(num5));
        String num6 = ".";
        assertFalse(isNumber(num6));
        String num7 = ".250";
        assertTrue(isNumber(num7));

        //Test hasEvenZeros
        String bin1 = "01010101";
        assertTrue(hasEvenZeros(bin1));
        String bin2 = "111110";
        assertFalse(hasEvenZeros(bin2));
        String bin3 = "1abc100";
        assertFalse(hasEvenZeros(bin3));

        //Test hasNoDoubles
        assertTrue(hasNoDoubles(bin1));
        assertFalse(hasNoDoubles(bin2));
        assertFalse(hasNoDoubles(bin3));

        //Test isClassName
        String c1 = "Test_Klasse";
        assertTrue(isClassName(c1));
        String c2 = "Test_Klasse123";
        assertTrue(isClassName(c2));
        String c3 = "test_Klasse";
        assertFalse(isClassName(c3));
        String c4 = "Test_Klasse_";
        assertFalse(isClassName(c4));

        //Test isDate
        String date1 = "1.1.";
        assertTrue(isDate(date1));
        String date2 = "31. 12. 14";
        assertTrue(isDate(date2));
        String date3 = "08. 1.2014";
        assertTrue(isDate(date3));
        String date4 = "29.2.2011";
        assertTrue(isDate(date4));
        String date5 = "1.1.0018";
        assertTrue(isDate(date5));
        String date6 = "001.1.2011";
        assertFalse(isDate(date6));
        String date7 = "23.12.196";
        assertFalse(isDate(date7));

        //Test getFirstIp
        assertNull(getFirstIp(date1));
        assertEquals(ip1, getFirstIp(ip1 + ip2));
        assertNull(getFirstIp(ip2));

        //Test getFirstDate
        assertNull(getFirstDate(ip1));
        assertEquals(date1, getFirstDate(date1 + "wereweradfsadsf"));
        assertNull(getFirstDate(date6 + " kjwerjkwe"));

        //-----
        //B

        //Test removeMulti Spaces
        assertEquals("1 2 3 4 5", removeMultiSpaces("1  2  3  4  5"));
        assertEquals(" 12345 ", removeMultiSpaces("  12345  "));
        assertEquals("Ich liebe SEW! ", removeMultiSpaces("Ich  liebe  SEW!  "));

        //Test SplitToLines
        String[] split1 = splitToLines("Test\nTo\nLines");
        assertEquals("Test", split1[0]);
        assertEquals("To", split1[1]);
        assertEquals("Lines", split1[2]);
        String[] split2 = splitToLines("Ohne Zeilenumbruch");
        assertEquals("Ohne Zeilenumbruch", split2[0]);

        //Test splitToLines(String s, int maxLen)
        List<String> list1 = splitToLines("Eins Zwei Drei Vier Fünf\nSechs Sieben Acht Neun Zehn\nElf Zwölf Dreizehn Vierzehn", 10);
        assertEquals("Eins Zwei", list1.get(0));
        assertEquals("Drei Vier", list1.get(1));
        assertEquals("Fünf", list1.get(2));
        assertEquals("Vierzehn", list1.get(list1.size() - 1));
        List<String> list2 = splitToLines("ABC DEFG HIJK LMNOP\nQRST UVWXYZ", 12);
        assertEquals("ABC DEFG", list2.get(0));
        assertEquals("HIJK LMNOP", list2.get(1));
        assertEquals("QRST UVWXYZ", list2.get(2));

        //-----
        //C

        //Test getHtmlTagStatistic
        Map htmlStats = getHtmlTagStatistic("resources/index.html");
        assertEquals(20.0, htmlStats.get("<img>"));
        assertEquals(6.0, htmlStats.get("<section>"));
        assertEquals(1.0, htmlStats.get("<html>"));

        //Test getAbsolutLinks
        Set<String> links = getAbsolutLinks("resources/index2.html");
        Object[] linksArray = links.toArray();
        assertEquals("https://urania.webuntis.com/WebUntis/index.do#/basic/main", linksArray[0]);
        assertEquals("https://www.eduvidual.at/my/", linksArray[1]);
        assertEquals("https://www.youtube.com/embed/UytDdfViR3k", linksArray[2]);

        //Test getDomains
        Set<String> domains = getDomains("resources/index2.html");
        Object[] domainsArray = domains.toArray();
        assertEquals("urania.webuntis.com", domainsArray[0]);
        assertEquals("www.eduvidual.at", domainsArray[1]);
        assertEquals("www.youtube.com", domainsArray[2]);

        //-----
    }
}