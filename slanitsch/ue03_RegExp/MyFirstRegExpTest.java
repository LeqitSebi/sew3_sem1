package slanitsch.ue03_RegExp;

import org.junit.jupiter.api.Test;

import slanitsch.ue03_RegExp.*;

import static org.junit.jupiter.api.Assertions.*;
import static slanitsch.ue03_RegExp.MyFirstRegExp.*;

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
}