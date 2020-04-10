package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuOLD {
    private final BufferedReader reader;

    public MenuOLD() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void promptMode() throws IOException {
        String selection = "";
        do {
            exitPrompt();
            System.out.println("Welcome to JobViz. Please select an option:");
            System.out.println("1: Salary Insight | 2: Salary Prediction: ");
            selection = reader.readLine();
        } while(!validateMenuSelection(selection, 1, 2));
        switch (selection) {
            case "1": System.out.println("Salary Insight Selected"); break;
            case "2": System.out.println("Salary Prediction"); break;
        }
    }

    private void exitPrompt() {
        System.out.println("Type 'e' to exit at any time.");
    }

    private boolean validateMenuSelection(String sel, int low, int high) {
        try {
            if(sel.equalsIgnoreCase("e")) exitSequence();
            int selection = Integer.parseInt(sel);
            return selection >= low && selection <= high;
        } catch (Exception e) {
            System.out.println("Invalid menu selection!");
            return false;
        }
    }

    private void exitSequence() {
        System.out.println("Thanks for using JobViz! Goodbye.");
        System.exit(1);
    }
}
