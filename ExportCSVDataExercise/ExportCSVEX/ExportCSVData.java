
import edu.duke.*;
import org.apache.commons.csv.*;

public class ExportCSVData {

	private String countryinfo(CSVParser parser, String country) {

		for(CSVRecord record : parser){

			if(record.get("Country").contains(country)){
				String countrytemp = record.get("Country") + ": " + record.get("Exports") + ": " + record.get("Value (dollars)");
				return countrytemp;

			}
		}
		return "Not Found";
	}

	
	

	
	private void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {

		for(CSVRecord record : parser){

			if(record.get("Exports").contains(exportItem1) && record.get("Exports").contains(exportItem2)){
				System.out.println(record.get("Country"));
			}
		}
		
	}

	private int numberOfExporters(CSVParser parser, String exportItem) {

		int i = 0;

		for(CSVRecord record : parser){

			if(record.get("Exports").contains(exportItem)){

				i++;
			}
		}

		return i;
	}


	private void bigExporters(CSVParser parser, String amount) {

		String val = amount.replace("$", "");

		val = val.replaceAll(",", "");

		long i = Long.parseLong(val);
		
		for(CSVRecord record : parser){

			String a = record.get("Value (dollars)");

			String b = a.replace("$", "");

			b = b.replaceAll(",", "");

			long j = Long.parseLong(b);

			if(j > i){
				System.out.println(record.get("Country") + " " + record.get("Value (dollars)"));
			}
		}
		
	}


	

	public static void main(String[] args) {
		ExportCSVData objectTest = new ExportCSVData();
		objectTest.tester();
	}


	private void tester() {

		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();

		String info = countryinfo(parser, "Germany");
		System.out.println(info);

		parser = fr.getCSVParser();
		listExportersTwoProducts(parser, "gold", "diamonds");

		parser = fr.getCSVParser();
		int val = numberOfExporters(parser, "gold");

		System.out.println(val);
		parser = fr.getCSVParser();
		bigExporters(parser, "$999,999,999");
	}
	
}