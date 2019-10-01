package slanitsch.tests;

import org.junit.jupiter.api.Test;
import slanitsch.ue02_JUnit.*;

import static org.junit.jupiter.api.Assertions.*;
import static slanitsch.ue02_JUnit.IPAddress.createNetmask;

class IPAddressTest {

    @Test
    public void testCreateIpAddress() {
        IPAddress ip = new IPAddress("8.8.8.8");

        assertEquals(0x08080808, ip.getIP(), "ipaddress wrong");
    }

    @Test
    public void testCreateNetmask() {
        assertEquals(new IPAddress("255.255.255.0"), createNetmask(24), "subnet wrong");
    }

    @Test
    public void testToString() {
        IPAddress ip = new IPAddress("8.8.8.8");

        assertEquals("IPAddress [8.8.8.8]", ip.toString(), "toString wrong");
    }

    @Test
    public void testCompareTo(){
        IPAddress ip = new IPAddress("8.8.8.8");
        IPAddress ip2 = new IPAddress("8.8.8.9");

        assertEquals(1, ip.compareTo(ip2), "not equal");
    }
}