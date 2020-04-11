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

            ArrayList<SalariesT> all = new ArrayList<>();
            all.add(parse2018.getAllSalaries());
            all.add(parse2019.getAllSalaries());

            //System.out.println(new PredictionT(all).predict("Professor"));

            System.out.println(parse2019.getAllSalaries().size());
            System.out.println(parse2019.getAllSalaries().getSalaries().get(0));
            System.out.println(parse2018.getAllSalaries().size());
            System.out.println(parse2018.getAllSalaries().getSalaries().get(0));

            new AppFrame(parse2019.getAllSalaries(), all);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
