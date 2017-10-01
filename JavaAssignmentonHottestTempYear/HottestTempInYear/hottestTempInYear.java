
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class hottestTempInYear {
    
	public CSVRecord maxTempInCSVFile(CSVParser parser) {
		
		CSVRecord largestSoFar = null;
		
		for (CSVRecord currentRow : parser) {
			
			largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
		}
		
		return largestSoFar;
	}

	public void testHottestInDay () {
		FileResource fr = new FileResource();
		CSVParser fileParser = fr.getCSVParser();
		CSVRecord hottest = maxTempInCSVFile(fileParser);
		System.out.println("The hottest temperature was " + hottest.get("TemperatureF") +
				   " at " + hottest.get("TimeEST"));
	}

	public CSVRecord hottestInYear() {
		CSVRecord largestSoFar = null;
		
		DirectoryResource dr = new DirectoryResource();
		
		for (File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
			CSVParser fileParser = fr.getCSVParser();
			CSVRecord currentRow = maxTempInCSVFile(fileParser);
			largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
		}
		
		return largestSoFar;
	}

	public CSVRecord getLargestOfTwo (CSVRecord currentRow, CSVRecord largestSoFar) {
		
		if (largestSoFar == null) {
			largestSoFar = currentRow;
		}
		
		else {
			double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
			double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));

			if (currentTemp > largestTemp) {
				//If so update largestSoFar to currentRow
				largestSoFar = currentRow;
			}
		}
		return largestSoFar;
	}

	public void testHottestInYear () {
		CSVRecord hottestTemp = hottestInYear();
		System.out.println("The hottest temperature was " + hottestTemp.get("TemperatureF") +
				   " at " + hottestTemp.get("DateUTC"));
	}
}