package src;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class ParseT {

    private SalariesT allSalaries;
    HashSet<String> uniqueSectors, uniqueEmployers, uniquePositions;

    public SalariesT getAllSalaries() {
        return allSalaries;
    }

    public ParseT(String fileName) throws Exception {
        parseFile(fileName);
    }

    public void parseFile(String fileName) throws Exception {
        Scanner scanner = new Scanner(new File(fileName));
        ArrayList<SalaryT> allRows = new ArrayList<>();
        scanner.nextLine();
        while(scanner.hasNext()) {
            ArrayList<String> line = parseLine(scanner.nextLine());
            setUniques(line);
            String name = line.get(1) + " " + line.get(2);
            String formatSal = String.join("",line.get(3).substring(1).split(","));
            String formatBenefits = String.join("",line.get(4).substring(1).split(","));
            double salary = Double.parseDouble(formatSal);
            double benefits = Double.parseDouble(formatBenefits);
            int year = Integer.parseInt(line.get(7));

            allRows.add(new SalaryT(line.get(0), name, salary, benefits, line.get(5), line.get(6), year, ""));
        }
        scanner.close();
        if(allRows.size() == 0) throw new Exception("Empty data");

        allSalaries = new SalariesT(allRows, allRows.get(0).getYear());
    }

    private void setUniques(ArrayList<String> line) {
        uniqueSectors.add(line.get(0));
        uniqueEmployers.add(line.get(5));
        uniquePositions.add(line.get(6));
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
