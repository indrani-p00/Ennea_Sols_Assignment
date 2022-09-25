package helper;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;



import model.Tutorial;

public class CSVHelper {
	
	public static String TYPE = "text/csv";
	static String[] HEADERs = {"code","name", "batch", "stock", "deal", "free", "mrp", "rate", "exp", "company", "supplier"};
	
	public static boolean hasCSVFormat(MultipartFile file) {
		
		if(!TYPE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}
	
	public static List<Tutorial> csvToTutorials(InputStream is) {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
			
			List<Tutorial> tutorials = new ArrayList<Tutorial>();
			
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			
			for(CSVRecord csvRecord : csvRecords) {
				Tutorial tutorial = new Tutorial(
						csvRecord.get("code"),
						csvRecord.get("name"),
						csvRecord.get("batch"),
						Long.parseLong(csvRecord.get("stock")),
						Long.parseLong(csvRecord.get("deal")),
						Long.parseLong(csvRecord.get("free")),
						Double.parseDouble(csvRecord.get("mrp")),
						Double.parseDouble(csvRecord.get("rate")),
						csvRecord.get("exp"),
						csvRecord.get("company"),
						csvRecord.get("supplier")
						);
				tutorials.add(tutorial);
			}
			
			return tutorials;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file:" + e.getMessage());
		}
	}
	
}
