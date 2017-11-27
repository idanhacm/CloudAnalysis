package cloud_analysis_project;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile
{
	//The constant number range given
	final private int NUMBER_RANGE = 256;
	
	//File scanner to distribution function
	//usage: distribution need to be 256 in length integer, with a legit file name
	public static boolean file_to_dis(int[] distribution, String file_name) throws FileNotFoundException {
		Scanner file_reader = new Scanner(new File(file_name));
		
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
