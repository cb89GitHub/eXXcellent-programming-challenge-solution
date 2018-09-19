package de.exxcellent.challenge;

import java.io.File;
import java.io.IOException;

import de.exxcellent.challenge.data.DataContainer;

/**
 * Read file
 * @author Chuong Bui-Ngoc
 *
 */
public interface IDataReader
{
	DataContainer read(File file) throws IOException;
}
