package src;

public class Application {
    public static void main(String[] args) {
        GUITest x = new GUITest();
    }

    public static void readTest() {
        try {
            ParseT parse2019 = new ParseT("data/data.csv");
            System.out.println(parse2019.getAllSalaries().size());
            System.out.println(parse2019.getAllSalaries().getSalaries().get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
