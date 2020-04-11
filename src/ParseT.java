package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class ParseT {

    private SalariesT allSalaries;
    HashSet<String> uniqueSectors, uniqueEmployers, uniquePositions;

    public ParseT(String fileName) throws Exception {
        uniqueSectors = new HashSet<>();
        uniqueEmployers = new HashSet<>();
        uniquePositions = new HashSet<>();
        parseFile(fileName);
    }

    public void parseFile(String fileName) throws Exception {
		
    	Reader reader = new InputStreamReader(new FileInputStream(fileName), "utf-8");
    	BufferedReader scanner = new BufferedReader(reader);
        ArrayList<SalaryT> allRows = new ArrayList<>();
        String r = scanner.readLine();
        while((r = scanner.readLine()) != null) {
            ArrayList<String> line = parseLine(r);
            setUniques(line);
            String formatSal = String.join("",line.get(3).substring(1).split(","));
            String formatBenefits = String.join("",line.get(4).substring(1).split(","));
            double salary = Double.parseDouble(formatSal);
            double benefits = Double.parseDouble(formatBenefits);
            int year = Integer.parseInt(line.get(7));

            allRows.add(new SalaryT(line.get(0), line.get(1), line.get(2), salary, benefits, line.get(5), line.get(6), year));
        }
        scanner.close();
        if(allRows.size() == 0) throw new Exception("Empty data");

        allSalaries = new SalariesT(allRows, allRows.get(0).getYear(), uniqueSectors.toArray(new String[0]),
                        uniqueEmployers.toArray(new String[0]), uniquePositions.toArray(new String[0]));
    }

    private void setUniques(ArrayList<String> line) {
        uniqueSectors.add(line.get(0));
        uniqueEmployers.add(line.get(5));
        uniquePositions.add(line.get(6));
    }

    public SalariesT getAllSalaries() {
        return allSalaries;
    }

    public static ArrayList<String> parseLine(String line) {
        char commaDelim = ',';
        char quoteDelim = '"';
        boolean inQuotes = false;

        StringBuilder currrent = new StringBuilder();
        ArrayList<String> result = new ArrayList<>();

        if(line == null || line.length() == 0)
            return result;

        char[] chars = line.toCharArray();
        for(char c:chars) {
            if(c == quoteDelim) {
                inQuotes = !inQuotes;
                continue;
            }
            if (inQuotes) {
                currrent.append(c);
            } else {
                if (c == commaDelim) {
                    result.add(currrent.toString());
                    currrent = new StringBuilder();
                } else if (c == '\n') {
                    break;
                } else {
                    currrent.append(c);
                }
            }
        }
        result.add(currrent.toString());
        return result;
    }
}
