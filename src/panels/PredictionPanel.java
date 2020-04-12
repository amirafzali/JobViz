package src.panels;

import lib.AutoCompletion;
import src.PredictionT;
import src.SalariesT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PredictionPanel extends JPanel {

    private ArrayList<SalariesT> data;
    private AppFrame main;

    private JComboBox<String> positionList;

    private JTextField f2017, f2018, f2019, fPredict;


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

    private void showResults() {
        PredictionT predict = new PredictionT(data);
        String pos = (String) positionList.getSelectedItem();
        double avg2017 = data.get(0).positionMean(pos), avg2018 = data.get(1).positionMean(pos), avg2019 = data.get(2).positionMean(pos);
        double avgPredict = predict.predict(pos).get(0);

        refresh(avg2017, avg2018, avg2019, avgPredict);
    }

    private void refresh(double a1, double a2, double a3, double a4) {
        f2017.setText(String.format("2018: $%.2f", a1));
        f2018.setText(String.format("2019: $%.2f", a2));
        f2019.setText(String.format("2019: $%.2f", a3));
        fPredict.setText(String.format("2020: $%.2f", a4));

        if(Double.isNaN(a1)) {
            f2017.setText(String.format("2017: Insufficient data!", a1));
            fPredict.setText(String.format("Prediction (2020): Cannot calculate due to missing data.", a4));
        }

        if (Double.isNaN(a2)){
            f2018.setText(String.format("2018: Insufficient data!", a1));
            fPredict.setText(String.format("Prediction (2020): Cannot calculate due to missing data.", a4));
        }

        revalidate();
        repaint();
    }
}
