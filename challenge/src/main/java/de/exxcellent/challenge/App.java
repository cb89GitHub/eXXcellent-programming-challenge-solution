package de.exxcellent.challenge;

import java.io.File;
import java.io.IOException;

import de.exxcellent.challenge.data.DataContainer;

/**
 * The entry class for your solution. This class is only aimed as starting point
 * and not intended as baseline for your software design. Read: create your own
 * classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App
{
	public static void main(String... args)
	{
		try
		{
			// day analysis function call
			String dayWithSmallestTempSpread = getDayWithSmallestTemperatureSpread();

			// football analysis functional call
			String teamWithSmallestGoalSpread = getTeamWithSmallestDifferenceInGoals();

			System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
			System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * gets the Team with smallest difference in goals
	 * @return
	 * @throws IOException
	 */
	private static String getTeamWithSmallestDifferenceInGoals() throws IOException
	{
		File file = new File("src\\main\\resources\\de\\exxcellent\\challenge\\football.csv");
		// change Reader here (e.g. JSON Reader)
		IDataReader csvReader = new CsvReader();
		DataContainer dataContainer = csvReader.read(file);

		// for testing purposes
		 dataContainer.print();

		Calculation calculation = new Calculation();
		String team = calculation.getElementOfMinOf(dataContainer, "Goals Allowed", "Goals", "Team");
		return team;
	}

	/**
	 * gets day with smallest temperature spread
	 * @return
	 * @throws IOException
	 */
	private static String getDayWithSmallestTemperatureSpread() throws IOException
	{
		File file = new File("src\\main\\resources\\de\\exxcellent\\challenge\\weather.csv");
		// change Reader here (e.g. JSON Reader)
		IDataReader csvReader = new CsvReader();
		DataContainer dataContainer = csvReader.read(file);

		// for testing purposes
		dataContainer.print();

		Calculation calculation = new Calculation();
		String day = calculation.getElementOfMinOf(dataContainer, "MxT", "MnT", "Day");
		return day;
	}

}
