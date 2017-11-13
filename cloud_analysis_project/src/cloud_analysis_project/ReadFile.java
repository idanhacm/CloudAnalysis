package cloud_analysis_project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadFile
{
	public int distribution[];
	private Scanner file_reader;
	final int NUMBER_RANGE = 256;
	
	public ReadFile(String file_name) 
	{
		distribution = new int[NUMBER_RANGE];
		read_file(file_name);
	}
	
	public void read_file(String file_name)
	{
		try 
		{
			file_reader = new Scanner(new File(file_name));
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		file_reader.useDelimiter(",");
		
		for(int i=0; i<distribution.length; i++)
		{
			distribution[i] = 0;
		}
		
		while(file_reader.hasNext())
		{
			if(file_reader.hasNextInt())
			{
				int index = file_reader.nextInt();
				if(index > 255 || index < 0)
					index = 255;
				System.out.println(index);
				distribution[index]++;
			}else
			{
				file_reader.next();
			}
		}
	}
	public void print_arr()
	{
		for(int i=0; i<255; i++)
		{
			System.out.println(i+": "+ distribution[i]);
		}
	}
	public static void main(String[] args) {
		ReadFile rf = new ReadFile("IR.txt");
		rf.print_arr();
	}
}
