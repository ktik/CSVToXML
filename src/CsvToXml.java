import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class CsvToXml implements CsvToXmlIntf {

	@Override
	public void CsvToXml(String csvFile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void XmlToCsv(String xmlFile) {
		// TODO Auto-generated method stub
		
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
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			
			while (br)
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
