package slanitsch.tests;

import org.junit.jupiter.api.Test;
import slanitsch.ue02_JUnit.IPAddress;

import static org.junit.jupiter.api.Assertions.*;

class IPAddressTest {

    @Test
    public void testCreateIpAddress(){
        IPAddress ip = new IPAddress("8.8.8.8");

        assertEquals(0x08080808, ip.getIP(), "wrong address");
    }

}