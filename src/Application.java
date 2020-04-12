package src;

import java.util.ArrayList;

import src.panels.AppFrame;

/**
 * Main runner class
 *
 */
public class Application {

	public static void main(String[] args) {
		launch();
	}

	/**
	 * Parses the input data and launches the GUI
	 */
	private static void launch() {
		try {

			ParseT parse2019 = new ParseT("data/data2019.csv");
			ParseT parse2018 = new ParseT("data/data2018.csv");
			ParseT parse2017 = new ParseT("data/data2017.csv");

			ArrayList<SalariesT> all = new ArrayList<>();
			all.add(parse2017.getAllSalaries());
			all.add(parse2018.getAllSalaries());
			all.add(parse2019.getAllSalaries());

			System.out.println("Launching app... please wait :)");
			System.out.println("2019 rows: " + parse2019.getAllSalaries().size());
			System.out.println("2018 rows: " + parse2018.getAllSalaries().size());
			System.out.println("2017 rows: " + parse2017.getAllSalaries().size());
			System.out.println("Almost done loading...");
			new AppFrame(parse2019.getAllSalaries(), all);
			System.out.println("Done!");

		} catch (Exception e) {
			System.out.println("App launch failed! Probably due to missing CSVs.");
		}
	}
}
