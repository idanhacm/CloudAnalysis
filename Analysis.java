package cloud_analysis_project;

import java.io.File;
import java.io.FileNotFoundException;

public final class Analysis {
	static public double get_avg(int threshold, int[] distribution)
	{
		double sum=0;
		for(int i=threshold; i<DataModel.NUMBER_RANGE; i++)
		{
			sum += distribution[i];
		}
		return sum/(DataModel.NUMBER_RANGE-threshold);
	}
	//given an array of file names puts the average values ranging 1 to 255 in dis_mean
	static public void get_mean(File[] files, int[] dis_mean, String tag)  {
		if (dis_mean.length != DataModel.NUMBER_RANGE)
			return;
		DataModel dm = DataModel.getInstance();
		for (int i = 0; i < files.length; i++) {
			dm.new_distribution(tag+i);
			ReadFile.file_to_dis(dm.getDistribution(tag+i), files[i]);
			for (int j = 0; j < DataModel.NUMBER_RANGE; j++) {
				dis_mean[j] += dm.getDistribution(tag+i)[j];
			}
		}
		for (int i = 0; i < DataModel.NUMBER_RANGE; i++) {
			dis_mean[i] /= files.length;
		}
	}
	public static double analize(File cFolder, File ncFolder)
	{
		return 92;
	}
}
