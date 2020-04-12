package src.panels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Constructor for the main menu panel. Extension of the JPanel class.
 */
public class MenuPanel extends JPanel {

    private AppFrame main;

    /**
     * Constructor for the MenuPanel. Instantiates the panel and defines properties on the object.
     * @param main Reference to the AppFrame object.
     */
    public MenuPanel(AppFrame main) {
        this.main = main;

        setFocusable(true);
        setVisible(true);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setupFields();
    }

    /**
     * Creates the MenuPanel fields.
     * This includes a text header intro, as well as the two buttons that take you to the
     * Insight or the Prediction page.
     */
    private void setupFields() {
        JPanel descArea = new JPanel(), buttonArea = new JPanel();
        Label desc = new Label("Welcome to JobViz");
        Label desc2 = new Label("Job Insight: Custom data queries | Salary Prediction: Calculated predictions");
        Label desc3 = new Label("Please select from the mode options below:");
        descArea.setBorder(new EmptyBorder(125,0,0,0));
        Font standardFont = new Font("serif", Font.PLAIN, 15);
        desc.setFont(standardFont.deriveFont(30f));
        descArea.add(desc);
        descArea.add(new Label("-------------------------------------------"));
        descArea.add(desc3);
        descArea.add(desc2);

        JButton insightButton = new JButton("Job Insight"), predictionButton = new JButton("Salary Prediction");
        insightButton.setPreferredSize(new Dimension(150,50));
        predictionButton.setPreferredSize(new Dimension(150,50));
        insightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.goToInsight();
            }
        });

        predictionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.goToPrediction();
            }
        });

        buttonArea.add(insightButton);
        buttonArea.add(predictionButton);
        this.add(descArea);
        this.add(buttonArea);
    }
}
