package src.panels;

import src.SalariesT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Class for the main GUI frame. Extension of the JFrame class.
 */
public class AppFrame extends JFrame {

    public static final Font standardFont = new Font("serif", Font.PLAIN, 20);
    public JPanel mainMenu, insight, prediction;
    private final SalariesT mainData;
    private final ArrayList<SalariesT> allData;

    /**
     * Constructor for App Frame. Instantiates the JFrame and defines properties on the frame.
     * @param main Main data set of SalariesT (2019)
     * @param all All years of SalariesT data
     */
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

    /**
     * Changes the main frame panel to the main menu.
     */
    public void goToMenu() {
        mainMenu = new MenuPanel(this);
        refresh(mainMenu);
    }

    /**
     * Changes the main frame panel to the Insight page.
     */
    public void goToInsight() {
        insight = new InsightPanel(mainData, this);
        refresh(insight);
    }

    /**
     * Changes the main frame panel to the prediction page.
     */
    public void goToPrediction() {
        prediction = new PredictionPanel(allData, this);
        refresh(prediction);
    }

    /**
     * Change the page content to another panel.
     * @param panel Panel to be used as main panel.
     */
    private void refresh(JPanel panel) {
        getContentPane().removeAll();
        add(panel);
        revalidate();
        repaint();
    }
}
