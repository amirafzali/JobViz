package src.panels;

import lib.AutoCompletion;
import src.PredictionT;
import src.SalariesT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Class for the prediction page. Extension of the JPanel class.
 */
public class PredictionPanel extends JPanel {

    private final ArrayList<SalariesT> data;
    private final AppFrame main;

    private JComboBox<String> positionList;

    private JTextField f2017, f2018, f2019, fPredict;

    /**
     * Constructor for PredictionPanel. Instantiates the panel and defines properties on the object.
     * @param allData All SalariesT data available.
     * @param main Reference to the AppFrame object.
     */
    public PredictionPanel(ArrayList<SalariesT> allData, AppFrame main) {
        this.data = allData;
        this.main = main;
        setFocusable(true);
        setVisible(true);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        welcomeText();
        setupPosition();
        setupOuts();
        setupSubmit();

        repaint();
    }

    /**
     * Adds the header text to the panel.
     */
    private void welcomeText() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.PAGE_AXIS));
        Label h1 = new Label("Salary Prediction", SwingConstants.CENTER);
        h1.setAlignment(Label.CENTER);
        h1.setFont(AppFrame.standardFont.deriveFont(30f));
        Label p1 = new Label("Please select a position to perform a salary prediction for:");
        p1.setAlignment(Label.CENTER);
        header.add(h1);
        header.add(p1);
        add(header);
    }

    /**
     * Adds a combo box for picking the desired position to perform a prediction calculation on.
     */
    private void setupPosition() {
        JPanel position = new JPanel();
        position.setLayout(new FlowLayout());
        positionList = new JComboBox<>(data.get(data.size()-1).getPositions());
        positionList.setPreferredSize(new Dimension(350,positionList.getPreferredSize().height));
        position.add(new Label("Position: "));
        position.add(positionList);
        AutoCompletion.enable(positionList);
        add(position);
    }

    /**
     * Adds the result ouput text fields to the panel.
     */
    private void setupOuts() {
        f2017 = new JTextField("2017: Waiting...");
        f2018 = new JTextField("2018: Waiting...");
        f2019 = new JTextField("2019: Waiting...");
        fPredict = new JTextField("Prediction (2020): Waiting...");

        JTextField[] fields = {f2017, f2018, f2019, fPredict};

        for(JTextField f : fields) {
            f.setEditable(false);
            f.setFont(AppFrame.standardFont.deriveFont(18f));
            add(f);
        }
    }

    /**
     * Add submit and go back to menu buttons to the panel. Defines action listeners on the buttons.
     */
    private void setupSubmit() {
        JPanel buttonRow = new JPanel();
        JButton submit = new JButton("Show Results!");
        JButton back = new JButton("Go back");

        back.setBorder(BorderFactory.createLineBorder(new Color(130,0,0)));
        submit.setBorder(BorderFactory.createLineBorder(new Color(0,130,0)));
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showResults();
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.goToMenu();
            }
        });
        submit.setPreferredSize(new Dimension(125,40));
        back.setPreferredSize(new Dimension(125,40));
        submit.setFont(AppFrame.standardFont.deriveFont(18f));
        back.setFont(AppFrame.standardFont.deriveFont(18f));
        buttonRow.add(submit);
        buttonRow.add(back);
        add(buttonRow);
    }

    /**
     * Function that is called when show results is clicked. Calls refresh with the
     * salary averages for the past 3 years, and the prediction for next year.
     */
    private void showResults() {
        PredictionT predict = new PredictionT(data);
        String pos = (String) positionList.getSelectedItem();
        double avg2017 = data.get(0).positionMean(pos), avg2018 = data.get(1).positionMean(pos), avg2019 = data.get(2).positionMean(pos);
        double avgPredict = predict.predict(pos).get(0);
        double rate = predict.predict(pos).get(1);

        refresh(avg2017, avg2018, avg2019, avgPredict, rate);
    }

    /**
     * Attempts to set the outputs. If data is missing, then it is indicated as so, and no prediction is showed.
     * @param a1 Average salary for the position, from 2017.
     * @param a2 Average salary for the position, from 2018.
     * @param a3 Average salary for the position, from 2019.
     * @param a4 Calculated prediction of average salary for the position in the next year (2020).
     * @param a5 Changed rate of salary for the predicted year.
     */
    private void refresh(double a1, double a2, double a3, double a4, double a5) {
        f2017.setText(String.format("2017: $%.2f", a1));
        f2018.setText(String.format("2018: $%.2f", a2));
        f2019.setText(String.format("2019: $%.2f", a3));

        String toUse = "";
        double real = 0;
        System.out.println(a5);
        if(!Double.isNaN(a4) && !Double.isNaN(a5)) {
            real = a5*100;
            if(real < 100) {
                toUse = "% decline";
                real = 100-real;
            } else if(real > 100) {
                real = real-100;
                toUse = "% increase";
            } else {
                toUse = "%, no change";
            }
        }
        real = Math.abs(real);

        fPredict.setText(String.format("2020: $%.2f, %.2f%s", a4, real, toUse));

        if(Double.isNaN(a1)) {
            f2017.setText("2017: Insufficient data!");
            fPredict.setText("Prediction (2020): Cannot calculate due to missing data.");
        }

        if (Double.isNaN(a2)){
            f2018.setText("2018: Insufficient data!");
            fPredict.setText("Prediction (2020): Cannot calculate due to missing data.");
        }

        revalidate();
        repaint();
    }
}
