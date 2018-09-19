package de.exxcellent.challenge.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Column which is defined by name (String) and values (String)
 * @author Chuong Bui-Ngoc
 *
 */
public class Column
{
	private String name;
	private final List<String> valueList = new ArrayList<String>();

	/**
	 * Class constructor specified by name
	 * @param name
	 */
	public Column(String name)
	{
		this.name = name;
	}


	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}


	public List<String> getValueList()
	{
		return valueList;
	}


}
