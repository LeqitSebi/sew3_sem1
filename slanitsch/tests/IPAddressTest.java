package slanitsch.tests;

import org.junit.jupiter.api.Test;
import slanitsch.ue02_JUnit.*;
import static org.junit.jupiter.api.Assertions.*;
import static slanitsch.ue02_JUnit.IPAddress.createNetmask;

class IPAddressTest {

    @Test
    public void testCreateIpAddress(){
        IPAddress ip = new IPAddress("8.8.8.8");

        assertEquals(0x08080808, ip.getIP(), "wrong address");
    }

    @Test
    public void testCreateNetmask(){
        assertEquals(new IPAddress ("255.255.255.0"),  createNetmask(24), "wrong subnet");
    }

}