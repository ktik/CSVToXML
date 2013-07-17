import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.net.URL;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;


public class CsvToXml implements CsvToXmlIntf {

	private String[] colNames;
	ArrayList<PerfCounter> perfCounterList = new ArrayList<PerfCounter>();
	
	public CsvToXml(ArrayList<String> lines)  {
		
		colNames = lines.get(0).split(",");
				
		for (int i=1; i< lines.size(); i++) {
			String line = lines.get(i);
			processLine(line);
			
		}
		
		StringBuffer xmlString = makeXml();
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("/Users/kartikmalladi/Documents/java_projects/ipsoft_out.xml"));
			bw.write(xmlString.toString());
			bw.flush();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(xmlString);
		
//		for (int i=0; i<perfCounterList.size(); i++) {
//			System.out.println(perfCounterList.get(i).getSite_id()+","+perfCounterList.get(i).getSite_location());
//		}
		
	}
	
	private StringBuffer makeXml() {
		StringBuffer xmlString = new StringBuffer();
		xmlString.append("<Sites>\n");
		
		for (int i=0; i<perfCounterList.size(); i++) {
			PerfCounter pc = perfCounterList.get(i);
			xmlString.append("<Site id=\""+pc.getSite_id()+"\" name=\""+pc.getSite_name()+"\" location=\""+pc.getSite_location()+"\">\n");
			ArrayList<Host> hosts = pc.getHosts();
			xmlString.append("<Hosts>\n");
			for (Host h: hosts) {
				xmlString.append("<Host id=\""+h.getHost_id()+"\">\n");
				xmlString.append("<Host_name>"+h.getHost_name()+"</Host_name>\n");
				xmlString.append("<IP_address>"+h.getIp_addr()+"</IP_address>\n");
				xmlString.append("<OS>"+h.getOs()+"</OS>\n");
				xmlString.append("<Load_avg_1min>"+h.getLoad_avg_1min()+"</Load_avg_1min>\n");
				xmlString.append("<Load_avg_5min>"+h.getLoad_avg_5min()+"</Load_avg_5min>\n");
				xmlString.append("<Load_avg_15min>"+h.getLoad_avg_15min()+"</Load_avg_15min>\n");
				xmlString.append("</Host>\n");
				
			}
			xmlString.append("</Hosts>\n");
			xmlString.append("</Site>\n");
			
		}
		xmlString.append("</Sites>\n");
		return xmlString;
		
	}
	
	private void processLine(String line) {
		String[] vals = line.split(",");
		int siteid = Integer.parseInt(vals[0].trim());
		String sitename = vals[1].trim();
		String siteloc = vals[2].trim();
		int hostid = Integer.parseInt(vals[3].trim());
		String hostname = vals[4].trim();
		String ipaddr = vals[5].trim();
		String os = vals[6].trim();
		double _1min = Double.parseDouble(vals[7].trim());
		double _5min = Double.parseDouble(vals[8].trim());
		double _15min = Double.parseDouble(vals[9].trim());
		
		Host h = new Host(hostid, hostname, ipaddr, os, _1min, _5min, _15min);
		boolean flag = false;
		
		for (int i=0; i< perfCounterList.size(); i++) {
			PerfCounter pc = perfCounterList.get(i);
			if (pc.getSite_id() == siteid) {
				flag = true;
				ArrayList<Host> tempHosts = pc.getHosts();
				tempHosts.add(h);
				pc.hosts = tempHosts;
			}
		}
		
		if (!flag) {
			ArrayList<Host> hosts = new ArrayList<Host>();
			hosts.add(h);
			PerfCounter pc = new PerfCounter(siteid, sitename, siteloc, hosts);
			perfCounterList.add(pc);
		}
		
	}
	
	@Override
	public void ConvCsvToXml(String csvFile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ConvXmlToCsv(String xmlFile) {
		
		Document document = getDocument(xmlFile);
		String xPath = "//Sites/Site";
		List<Node> nodes = document.selectNodes(xPath);
		for (Node node: nodes) {
			String siteId = node.valueOf("@id");
			String siteName = node.valueOf("@name");
			String siteLoc = node.valueOf("@location");
			System.out.println(siteId+","+siteName+","+siteLoc);
		}
		
	}
	
	private Document getDocument(final String xmlFileName) {
	
		Document document = null;
		SAXReader reader = new SAXReader();
		
		try {
			document = reader.read(xmlFileName);
		} catch(DocumentException e) {
			e.printStackTrace();
		}
		
		return document;
	}

	@Override
	public List<PerfCounter>[] getRecords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PerfCounter>[] filterRecords(String[] filterFields) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PerfCounter>[] sortRecords(String[] sortFields) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		
		String filename = args[0];
		
		if (filename.endsWith(".csv")) {
			BufferedReader br = null;
			String line = null;
			ArrayList<String> allLines = new ArrayList<String>();
			int i = 0;
			try {
				br = new BufferedReader(new FileReader(filename));
				
				while ((line = br.readLine()) != null) {
					//System.out.println(line);
					allLines.add(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (br!=null)
						br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			CsvToXml cTox = new CsvToXml(allLines);
		}
		else {
			
		}
	}

}
