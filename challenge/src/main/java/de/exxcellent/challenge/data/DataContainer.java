package de.exxcellent.challenge.data;

import java.util.ArrayList;
import java.util.List;

/**
 * DataContainer with variable amount of columns
 * DataContainer defined by name and columns (List<String>)
 * @author Chuong Bui-Ngoc
 *
 */
public class DataContainer
{
	private String name;
	private final List<Column> columnList = new ArrayList<>();

	/**
	 * Class constructor specified by name
	 * @param name
	 */
	public DataContainer(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	/**
	 * Adds a column to the DataContainer.
	 * @param column
	 */
	public void add(Column column)
	{
		columnList.add(column);
	}

	/**
	 * Gets the column by index
	 * @param index in the list
	 * @return
	 */
	public Column getColumn(int index)
	{
		return columnList.get(index);
	}

	/**
	 * Gets the column by its name
	 * @param name
	 * @return
	 */
	public Column getColumn(String name)
	{
		for (Column column : columnList)
		{
			if (name.equals(column.getName()))
				return column;
		}

		throw new RuntimeException("Column with the name " + name + " does not exist.");
	}

	/**
	* print out all data of DataContainer in console:
	* - Name of file
	* - Name of each column
	* - Values of each column
	*/
	public void print()
	{
		System.out.println("Name of file: " + name);

		// print out each line
		int columnLength = columnList.get(0).getValueList().size();

		for (int i = 0; i < columnLength; i++)
		{
			for (Column column : columnList)
			{
				if (i==0)
				{
					System.out.print(String.format("%17s", column.getName()));
				}
				else
				{
					System.out.print(String.format("%17s", column.getValueList().get(i)));
				}
			}
			System.out.println();
		}
	}
}
