package src.panels;

import src.SalariesT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AppFrame extends JFrame {

    public static final Font standardFont = new Font("serif", Font.PLAIN, 20);
    public JPanel mainMenu, insight, prediction;
    private final SalariesT mainData;
    private final ArrayList<SalariesT> allData;

    public AppFrame(SalariesT main, ArrayList<SalariesT> all) {
        this.mainData = main;
        this.allData = all;

        setTitle("JobViz");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        setLayout(new CardLayout());
        goToMenu();
        setVisible(true);
        pack();

    }

    public void goToMenu() {
        mainMenu = new MenuPanel(this);
        refresh(mainMenu);
    }

    public void goToInsight() {
        insight = new InsightPanel(mainData, this);
        refresh(insight);
    }

    public void goToPrediction() {
        prediction = new PredictionPanel(allData, this);
        refresh(prediction);
    }

    private void refresh(JPanel panel) {
        getContentPane().removeAll();
        add(panel);
        revalidate();
        repaint();
    }
}
