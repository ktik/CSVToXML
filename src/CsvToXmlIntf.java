import java.util.List;
import org.dom4j.Document;


public interface CsvToXmlIntf {
	
	public void ConvCsvToXml(String csvFile);
	public void ConvXmlToCsv(String xmlFile);
	public List<PerfCounter>[] getRecords();
	public List<PerfCounter>[] filterRecords(String[] filterFields);
	public List<PerfCounter>[] sortRecords(String[] sortFields);
}
