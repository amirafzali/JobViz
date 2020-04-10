package src;

import lib.AutoCompletion;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InsightPanel extends JPanel {
    private JPanel header, sector, employer, position;
    private SalariesT data;
    private final Font standardFont = new Font("serif", Font.PLAIN, 20);

    public InsightPanel(SalariesT data) {
        this.data = data;
        setFocusable(true);
        setVisible(true);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        welcomeText();
        setupSector();
        setupEmployer();
        setupPosition();
        setupSubmit();

        repaint();
    }

    private void welcomeText() {
        header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.PAGE_AXIS));
        Label h1 = new Label("Job Insight", SwingConstants.CENTER);
        h1.setAlignment(Label.CENTER);
        h1.setFont(standardFont.deriveFont(30f));
        Label p1 = new Label("Please select your filtered categories.");
        Label p2 = new Label("If nothing is selected, then all data is used.");
        p1.setAlignment(Label.CENTER);
        p2.setAlignment(Label.CENTER);
        header.add(h1);
        header.add(p1);
        header.add(p2);
        this.add(header);
    }


    private void setupSector() {
        sector = new JPanel();
        sector.setLayout(new FlowLayout());
        JComboBox<String> sectorList = new JComboBox<>(data.getSectors());
        sectorList.setPreferredSize(new Dimension(350,sectorList.getPreferredSize().height));
        sector.add(new Label("Sector: "));
        sector.add(new Checkbox());
        sector.add(sectorList);

        this.add(sector);
        System.out.println("x");
    }

    private void setupEmployer() {
        employer = new JPanel();
        employer.setLayout(new FlowLayout());
        JComboBox<String> employerList = new JComboBox<>(data.getEmployers());
        employerList.setPreferredSize(new Dimension(350,employerList.getPreferredSize().height));
        employer.add(new Label("Employer: "));
        employer.add(new Checkbox());
        employer.add(employerList);

        this.add(employer);
        System.out.println("x");
    }

    private void setupPosition() {
        position = new JPanel();
        position.setLayout(new FlowLayout());
        JComboBox<String> positionList = new JComboBox<>(data.getPositions());
        positionList.setPreferredSize(new Dimension(350,positionList.getPreferredSize().height));
        position.add(new Label("Position: "));
        position.add(new Checkbox());
        position.add(positionList);
        AutoCompletion.enable(positionList);
        this.add(position);
        System.out.println("x");
    }

    private void setupSubmit() {
        Button submit = new Button("Show Results!");
        this.add(submit);
    }
}
