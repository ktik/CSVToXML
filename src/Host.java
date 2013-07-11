
public class Host {
	
	private int host_id;
	private String host_name;
	private String ip_addr;
	private String os;
	private double load_avg_1min;
	private double load_avg_5min;
	private double load_avg_15min;
	
	public int getHost_id() {
		return host_id;
	}
	public void setHost_id(int host_id) {
		this.host_id = host_id;
	}
	public String getHost_name() {
		return host_name;
	}
	public void setHost_name(String host_name) {
		this.host_name = host_name;
	}
	public String getIp_addr() {
		return ip_addr;
	}
	public void setIp_addr(String ip_addr) {
		this.ip_addr = ip_addr;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public double getLoad_avg_1min() {
		return load_avg_1min;
	}
	public void setLoad_avg_1min(double load_avg_1min) {
		this.load_avg_1min = load_avg_1min;
	}
	public double getLoad_avg_5min() {
		return load_avg_5min;
	}
	public void setLoad_avg_5min(double load_avg_5min) {
		this.load_avg_5min = load_avg_5min;
	}
	public double getLoad_avg_15min() {
		return load_avg_15min;
	}
	public void setLoad_avg_15min(double load_avg_15min) {
		this.load_avg_15min = load_avg_15min;
	}
	
	
}
