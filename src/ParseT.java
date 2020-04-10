package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ParseT {

    /*
        this.name = name;
        this.sal = salary;
        this.sect = sector;
        this.employer = employer;
        this.pos = position;
        this.city = city;
        this.year = year;
     */

    private SalariesT allSalaries;
    public static void main(String[] args) throws FileNotFoundException {
        new ParseT("data/data.csv");
    }

    public ParseT(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNext()) {
            ArrayList<String> line = parseLine(scanner.nextLine());
            String name = line.get(1) + " " + line.get(2);
            double salary = Double.parseDouble(line.get(3)), benefits = Double.parseDouble(line.get(4));
            int year = Integer.parseInt(line.get(7));
            SalaryT row = new SalaryT(line.get(0), name, salary, benefits, line.get(5), line.get(6), year, "");
        }
        scanner.close();
    }

    public static ArrayList<String> parseLine(String line) {
        char commaDelim = ',';
        char quoteDelim = '"';
        boolean inQuotes = false;

        StringBuilder currrent = new StringBuilder();
        ArrayList<String> result = new ArrayList<>();

        if (line == null || line.length() == 0)
            return result;

        char[] chars = line.toCharArray();

        for (char c : chars) {
            if(c==quoteDelim) {
                inQuotes = !inQuotes;
            }
            if (inQuotes) {
                currrent.append(c);
            } else {
                if (c == quoteDelim) {
                    if (chars[0] != '"') {
                        currrent.append('"');
                    }
                    currrent.append('"');
                } else if (c == commaDelim) {
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
