package cloud_analysis_project;

import java.awt.Dimension;
import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import javax.swing.JSpinner.NumberEditor;

//Data model is a singleton meaning that only one instance of it will appear using the getinstace method
public class DataModel {
	public static DataModel instance = null;
	HashMap<String, int[]> distribution_list; 
	static final int NUMBER_RANGE = 256;
	private DataModel()
	{
		distribution_list = new HashMap<String, int[]>();
	}
	public static DataModel getInstance() {
		if(instance == null) {
			instance = new DataModel();
		}
		return instance;
	}
	public int[] getDistribution(int num)
	{
		return getDistribution(String.valueOf(num));
	}
	public int[] getDistribution(String index)
	{
		return distribution_list.get(index);
	}
	
	public void new_distribution(int key)
	{
		new_distribution(String.valueOf(key));
	}
	
	public void new_distribution(String key)
	{
		if(!distribution_list.containsKey(key))
			distribution_list.put(key, new int[NUMBER_RANGE]);
		else
			for(int i=0; i<distribution_list.get(key).length; i++)
			{
				distribution_list.get(key)[i] = 0;
			}
	}
	public void clear(String key)
	{
		distribution_list.remove(key);
	}
	public void clearAll()
	{
		distribution_list.clear();
	}
}
