import java.util.List;


public class PerfCounter {
	
	private int site_id;
	private String site_name;
	private String site_location;
	List<Host>[] hosts;
	
	public int getSite_id() {
		return site_id;
	}
	public void setSite_id(int site_id) {
		this.site_id = site_id;
	}
	public String getSite_name() {
		return site_name;
	}
	public void setSite_name(String site_name) {
		this.site_name = site_name;
	}
	public String getSite_location() {
		return site_location;
	}
	public void setSite_location(String site_location) {
		this.site_location = site_location;
	}
	public List<Host>[] getHosts() {
		return hosts;
	}
	public void setHosts(List<Host>[] hosts) {
		this.hosts = hosts;
	}
	
	
	
}
