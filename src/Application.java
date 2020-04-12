package src;

import src.panels.AppFrame;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        GTest();
    }

    private static void GTest() {
        try {

            ParseT parse2019 = new ParseT("data/data2019.csv");
            ParseT parse2018 = new ParseT("data/data2018.csv");
            ParseT parse2017 = new ParseT("data/data2017.csv");

            ArrayList<SalariesT> all = new ArrayList<>();
            all.add(parse2017.getAllSalaries());
            all.add(parse2018.getAllSalaries());
            all.add(parse2019.getAllSalaries());

            System.out.println("Launching app... please wait :)");
            System.out.println("2019 rows: "+parse2019.getAllSalaries().size());
            System.out.println("2018 rows: "+parse2018.getAllSalaries().size());
            System.out.println("2017 rows: "+parse2017.getAllSalaries().size());
            System.out.println("Almost done loading...");
            new AppFrame(parse2019.getAllSalaries(), all);
            System.out.println("Done!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
