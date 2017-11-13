package cloud_analysis_project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile
{
	//256 int array, containing the distribution of the pixel colors
	private int distribution[];
	
	//File reader object
	private Scanner file_reader;
	
	//The constant number range given
	final private int NUMBER_RANGE = 256;
	
	//Default c'tor 
	public ReadFile()
	{
		distribution = new int[NUMBER_RANGE];
	}
	
	//string c'tor, read from file_name
	public ReadFile(String file_name) 
	{
		distribution = new int[NUMBER_RANGE];
		file_to_dis(file_name);
	}
	//get average and calculate
	public double get_mean()
	{
		double sum=0;
		double count=0;
		for(int i=0; i<NUMBER_RANGE; i++)
		{
			count += distribution[i];
			sum += distribution[i]*i;
		}
		return sum/count;
	}
	//File reader function
	public void file_to_dis(String file_name)
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
				
				if(index >= NUMBER_RANGE || index < 0)
					continue;
				distribution[index]++;
			}else
			{
				file_reader.next();
			}
		}
	}
	
	//TODO: useless main for debugging purposes only
	public static void main(String[] args) 
	{
		ReadFile rf = new ReadFile("n.txt");
		System.out.println(rf.get_mean());
	}
}
