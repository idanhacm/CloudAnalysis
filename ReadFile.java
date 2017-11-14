package cloud_analysis_project;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile
{
	//The constant number range given
	final private int NUMBER_RANGE = 256;
	Scanner file_reader;
	
	//Default c'tor 
	public ReadFile() {
		try {
			file_reader = new Scanner(new File("input.dat"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public ReadFile(String file_name) {
		try {
			file_reader = new Scanner(new File(file_name));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void open_file(String file_name) {
		try {
			file_reader = new Scanner(new File(file_name));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	//File scanner to distribution function
	//usage: distribution need to be 256 in length integer, with a legit file scanner
	public boolean file_to_dis(int[] distribution) {
		if(distribution.length != 256)
			return false;

		file_reader.useDelimiter(",");
		
		while(file_reader.hasNext()) {
			if(file_reader.hasNextInt()) {
				int index = file_reader.nextInt();
				
				if(index >= NUMBER_RANGE || index < 0)
					continue;
				distribution[index]++;
			} else {
				file_reader.next();
			}
		}
		return true;
	}
}
