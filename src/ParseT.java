package src;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * A class for parsing the Ontario Sunshine List
 *
 */
public class ParseT {

	private SalariesT allSalaries;
	HashSet<String> uniqueSectors, uniqueEmployers, uniquePositions;

	/**
	 * Constructor for ParseT
	 * 
	 * @param fileName The name of the file to be parsed
	 * @throws Exception If parseFile runs into an error
	 */
	public ParseT(String fileName) throws Exception {
		uniqueSectors = new HashSet<>();
		uniqueEmployers = new HashSet<>();
		uniquePositions = new HashSet<>();
		parseFile(fileName);
	}

	/**
	 * Iterates through the lines in the file, converts them from String to the
	 * correct type, and stores them.
	 * 
	 * @param fileName The name of the file to be parsed
	 * @throws Exception If a line does not adhere to the format, if the file DNE or
	 *                   if the file is empty
	 */
	private void parseFile(String fileName) throws Exception {

		Reader reader = new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8);
		BufferedReader scanner = new BufferedReader(reader);
		ArrayList<SalaryT> allRows = new ArrayList<>();
		String r = scanner.readLine();
		while ((r = scanner.readLine()) != null) {
			ArrayList<String> line = parseLine(r);
			setUniques(line);
			String formatSal = String.join("", line.get(3).substring(1).split(","));
			String formatBenefits = String.join("", line.get(4).substring(1).split(","));
			double salary = Double.parseDouble(formatSal);
			double benefits = Double.parseDouble(formatBenefits);
			int year = Integer.parseInt(line.get(7));

			allRows.add(new SalaryT(line.get(0), line.get(2), line.get(1), salary, benefits, line.get(5), line.get(6),
					year));
		}
		scanner.close();
		if (allRows.size() == 0)
			throw new Exception("Empty data");

		allSalaries = new SalariesT(allRows, allRows.get(0).getYear(), uniqueSectors.toArray(new String[0]),
				uniqueEmployers.toArray(new String[0]), uniquePositions.toArray(new String[0]));
	}

	/**
	 * Get method for allSalaries
	 * 
	 * @return SalariesT The parsed salaries from the file
	 */
	public SalariesT getAllSalaries() {
		return allSalaries;
	}

	/**
	 * Method to add unique sectors employers and positions
	 * 
	 * @param line The line from the sunshine list to be added
	 */
	private void setUniques(ArrayList<String> line) {
		uniqueSectors.add(line.get(0));
		uniqueEmployers.add(line.get(5));
		uniquePositions.add(line.get(6));
	}

	/**
	 * Method to parse an individual line, taking into account quoted values
	 * 
	 * @param line The line to be parsed
	 * @return ArrayList<String> The line separated into its columns
	 */
	private static ArrayList<String> parseLine(String line) {
		char commaDelim = ',';
		char quoteDelim = '"';
		boolean inQuotes = false;

		StringBuilder current = new StringBuilder();
		ArrayList<String> result = new ArrayList<>();

		if (line == null || line.length() == 0)
			return result;

		char[] chars = line.toCharArray();
		for (char c : chars) {
			if (c == quoteDelim) {
				inQuotes = !inQuotes;
				continue;
			}
			if (inQuotes) {
				current.append(c);
			} else {
				if (c == commaDelim) {
					result.add(current.toString());
					current = new StringBuilder();
				} else if (c == '\n') {
					break;
				} else {
					current.append(c);
				}
			}
		}
		result.add(current.toString());
		return result;
	}
}
