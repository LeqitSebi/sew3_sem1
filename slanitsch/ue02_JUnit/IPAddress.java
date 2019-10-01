package slanitsch.ue02_JUnit;

public class IPAddress {

	/**
	 * ip as integer
	 */
	private int ip;

	public IPAddress(int a3, int a2, int a1, int a0) {
		createIP(a3, a2, a1, a0);
	}

	private void createIP(int a3, int a2, int a1, int a0) {
		this.ip = (a3 << 24) + (a2 << 16) + (a1 << 8) + a0;
		// System.out.format("%d.%d.%d.%d: %08x\n", a3,a2,a1,a0,ip);
	}

	/**
	 * create IP from given integer (internal use)
	 */
	IPAddress(int ip) {
		this.ip = ip;
	}

	public IPAddress(String ip) {
		String[] nums = ip.split("\\.");
		if (nums.length != 4) {
			throw new IllegalArgumentException("ill formed ip");
		}
		createIP(Integer.parseInt(nums[0]),
				Integer.parseInt(nums[1]),
				Integer.parseInt(nums[2]),
				Integer.parseInt(nums[2]));
	}

	/**
	 * create IP/Netmask with given number of bits
	 */
	public static IPAddress createNetmask(int cidr) {
		int mask = (int)(0xfffffff000000000l >> (cidr-1));
		return new IPAddress(mask);
	}

	/**
	 * @return  ip address as integer
	 */
	public int getIP() {
		return ip;
	}

	@Override
	public String toString() {
		int a0 = (ip       ) & 0xff;
		int a1 = (ip >>>  8) & 0xff;
		int a2 = (ip >>> 16) & 0xff;
		int a3 = (ip >>> 24) & 0xff;
		
		return "IPAddress [" + a3 + "." + a2 + "." + a2 + "." + a0 + "]";
	}
}
