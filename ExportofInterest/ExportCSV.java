
import edu.duke.*;
import org.apache.commons.csv.*;


public class ExportCSV {
	
	public String theExporters(CSVParser parser, String exportOfInterest) {
	    
	    String countryName = "";
	    
	    for (CSVRecord record : parser) {
			
			String export = record.get("Exports");
			
			if (export.contains(exportOfInterest)) {
				
				countryName= record.get("Country");
				
				
			}
		}
		
           return countryName;
	}

	public void testSugar() {
	    
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		String sugarExporters =  theExporters(parser, "sugar");
		System.out.println("Sugar Exported by:"+sugarExporters);
		
		
	}

}

