package src.panels;

import src.SalariesT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppFrame extends JFrame {

    public JPanel mainMenu, insight, prediction;
    private final Font standardFont = new Font("serif", Font.PLAIN, 20);
    private final SalariesT mainData;

    public AppFrame(SalariesT main) {
        mainData = main;
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

    public void refresh(JPanel panel) {
        getContentPane().removeAll();
        add(panel);
        revalidate();
        repaint();
    }
}
