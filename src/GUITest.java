package src;

import src.panels.InsightPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GUITest {

    private final JFrame frame;
    private JPanel modePage;
    private final Font standardFont = new Font("serif", Font.PLAIN, 20);
    private SalariesT mainData;

    public GUITest(SalariesT main) {
        frame = new JFrame();
        frame.setTitle("JobViz");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500,500));
        frame.setLayout(new CardLayout());
        frame.setVisible(true);

        mainData = main;

        frame.add(new InsightPanel(mainData));

        frame.pack();
        //setupModeSelection();
        //addModeSelection();
    }

    private void addModeSelection() {
        frame.getContentPane().removeAll();
        frame.repaint();
        frame.add(modePage);
    }

    public void setupModeSelection() {
        modePage = new JPanel();
        modePage.setBorder(new EmptyBorder(100, 0, 0, 0));
        modePage.setPreferredSize(new Dimension(500,500));

        JPanel descArea = new JPanel(), buttonArea = new JPanel();

        Label desc = new Label("Welcome to JobViz");
        desc.setFont(standardFont.deriveFont(30f));
        descArea.setPreferredSize(new Dimension(500,100));
        descArea.add(desc);

        Button jobInsight = new Button("Job Insight"), salaryPrediction = new Button("Salary Prediction");
        buttonArea.add(jobInsight);
        buttonArea.add(salaryPrediction);


        modePage.add(descArea);
        modePage.add(buttonArea);
    }
}
