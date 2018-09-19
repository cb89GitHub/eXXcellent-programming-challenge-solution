package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import de.exxcellent.challenge.data.Column;
import de.exxcellent.challenge.data.DataContainer;

/**
 * Reads Csv Files and returns the data as DataContainer
 * @author Chuong Bui-Ngoc
 *
 */
public class CsvReader implements IDataReader
{

	@Override
	public DataContainer read(File file) throws IOException
	{
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		DataContainer dataContainer = new DataContainer(file.getName());
		try
		{
			br = new BufferedReader(new FileReader(file.getAbsolutePath()));
			line = br.readLine();
			String[] names = line.split(cvsSplitBy);
			for (String name : names)
			{
				dataContainer.add(new Column(name));
			}

			while ((line = br.readLine()) != null)
			{
				// use comma as separator
				String[] columnValues = line.split(cvsSplitBy);
				for (int i = 0; i < columnValues.length; i++)
				{
					dataContainer.getColumn(i).getValueList().add(columnValues[i]);
				}
			}
		}
		finally
		{
			if (br != null)
			{
				br.close();
			}
		}

		return dataContainer;
	}

}
