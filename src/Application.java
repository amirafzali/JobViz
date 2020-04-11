package src;

import src.panels.AppFrame;

public class Application {
    public static void main(String[] args) {
        GTest();
    }

    private static void GTest() {
        try {
            ParseT parse2019 = new ParseT("data/data2019.csv");
            System.out.println(parse2019.getAllSalaries().size());
            System.out.println(parse2019.getAllSalaries().getSalaries().get(0));
            AppFrame x = new AppFrame(parse2019.getAllSalaries());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
