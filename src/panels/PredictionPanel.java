package src.panels;

import src.SalariesT;

import javax.swing.*;
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
    }
}
