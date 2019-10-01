package slanitsch.tests;

import org.junit.jupiter.api.Test;
import slanitsch.ue02_JUnit.IPAddress;
import slanitsch.ue02_JUnit.Subnet;

import static org.junit.jupiter.api.Assertions.*;

class SubnetTest {

    @Test
    public void testGetMask(){
        IPAddress ip = new IPAddress("192.168.1.0");
        Subnet subnet = new Subnet(ip, 24);

        assertEquals(new IPAddress("255.255.255.0"), subnet.getMask(), "netmask wrong");
    }

}