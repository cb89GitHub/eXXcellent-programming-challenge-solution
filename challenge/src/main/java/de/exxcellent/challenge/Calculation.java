package de.exxcellent.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.exxcellent.challenge.data.Column;
import de.exxcellent.challenge.data.DataContainer;

/**
 * Calculation/Logic class
 * @author Chuong Bui-Ngoc
 *
 */
public class Calculation
{
	/**
	 * Get the element corresponding to the minimum of the difference of two columns(columnName1 and columnName2)
	 * @param dataContainer
	 * @param columnName1
	 * @param columnName2
	 * @param resultColumnName
	 * @return
	 */
	public String getElementOfMinOf(DataContainer dataContainer, String columnName1, String columnName2, String resultColumnName)
	{
		Column column1 = dataContainer.getColumn(columnName1);
		Column column2 = dataContainer.getColumn(columnName2);

		List<Integer> differenceList = new ArrayList<Integer>();

		// calculate absolute difference
		for (int i = 0; i < column1.getValueList().size(); i++)
		{
			int column1IntValue = Integer.parseInt(column1.getValueList().get(i));
			int column2IntValue = Integer.parseInt(column2.getValueList().get(i));
			differenceList.add(Math.abs(column1IntValue - column2IntValue));
		}

		// get the index of the corresponding element and return the element
		int index = differenceList.indexOf(Collections.min(differenceList));
		return dataContainer.getColumn(resultColumnName).getValueList().get(index);
	}
}
