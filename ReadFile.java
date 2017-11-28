package cloud_analysis_project;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile
{
	//File scanner to distribution function
	//usage: distribution need to be 256 in length integer, with a legit file scanner
	public static boolean file_to_dis(int[] distribution, File file)  {
		Scanner file_reader;
		if(distribution.length != DataModel.NUMBER_RANGE)
			return false;
		try {
			file_reader = new Scanner(file);
		} catch (FileNotFoundException e) {
			return false;
		}

		file_reader.useDelimiter(",");
		
		while(file_reader.hasNext()) {
			if(file_reader.hasNextInt()) {
				int index = file_reader.nextInt();
				
				if(index >= DataModel.NUMBER_RANGE || index < 0)
					continue;
				distribution[index]++;
			} else {
				file_reader.next();
			}
		}
		file_reader.close();
		return true;
	}
}
