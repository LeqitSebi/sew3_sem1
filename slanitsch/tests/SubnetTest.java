package slanitsch.tests;

import org.junit.jupiter.api.Test;
import slanitsch.ue02_JUnit.IPAddress;
import slanitsch.ue02_JUnit.Subnet;

import static org.junit.jupiter.api.Assertions.*;

class SubnetTest {

    @Test
    public void testGetNet() {
        IPAddress ip = new IPAddress("192.168.1.0");
        Subnet subnet = new Subnet(ip, 24);
        assertEquals(new IPAddress("192.168.1.0"), subnet.getNet(), "network wrong");

        Subnet sub2 = new Subnet(new IPAddress("10.1.0.0"), 27);
        assertEquals(0x0a010000, sub2.getNet().getIP());

        assertThrows(IllegalArgumentException.class, () -> {
            new Subnet(new IPAddress("8.8.8.8"), 27).getNet().getIP();
        });
    }

    @Test
    public void testGetMask() {
        IPAddress ip = new IPAddress("192.168.1.0");
        Subnet subnet = new Subnet(ip, 24);
        assertEquals(new IPAddress("255.255.255.0"), subnet.getMask(), "netmask wrong");

        Subnet sub = new Subnet(new IPAddress("192.168.0.0"), 28);
        assertEquals(0b11111111_11111111_11111111_11110000, sub.getMask().getIP());

        assertThrows(IllegalArgumentException.class, () -> {
            new Subnet(new IPAddress("8.8.8.8"), 27);
        });
    }

    @Test
    public void testGetBroadcast() {
        IPAddress ip = new IPAddress("192.168.1.0");
        Subnet subnet = new Subnet(ip, 24);
        assertEquals(new IPAddress("192.168.1.255"), subnet.getBroadcast(), "broadcast wrong");

        Subnet sub2 = new Subnet(new IPAddress("10.1.0.0"), 27);
        assertEquals(0x0a01001f, sub2.getBroadcast().getIP());

        assertThrows(IllegalArgumentException.class, () -> {
            new Subnet(new IPAddress("8.8.8.8"), 27).getBroadcast().getIP();
        });
    }

    @Test
    public void testToString(){

        Subnet sub = new Subnet(new IPAddress("192.168.0.0"),28);
        assertEquals("Subnet [net=IPAddress [192.168.0.0], mask=IPAddress [255.255.255.240]]",sub.toString());

        assertThrows( IllegalArgumentException.class, () -> {
            new Subnet(new IPAddress("8.8.8.8"), 27).toString();
        });
    }

}