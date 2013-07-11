import java.util.List;


public interface CsvToXmlIntf {
	
	public void CsvToXml(String csvFile);
	public void XmlToCsv(String xmlFile);
	public List<PerfCounter>[] getRecords();
	public List<PerfCounter>[] filterRecords(String[] filterFields);
	public List<PerfCounter>[] sortRecords(String[] sortFields);
}
