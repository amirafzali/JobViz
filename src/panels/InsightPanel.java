package src.panels;

import lib.AutoCompletion;
import src.SalariesT;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

/**
 * Class for the Insight page panel. Extension of the JPanel class.
 */
public class InsightPanel extends JPanel {
    private final SalariesT data;
    private JCheckBox sBox, eBox, posBox, salBox;
    private JComboBox<String> sList, eList, posList;
    private JFormattedTextField min, max;
    private AppFrame main;

    /**
     * Constructor for InsightPanel. Instantiates the panel and defines properties on the object.
     * @param data Main data set of SalariesT to be used for lookup.
     * @param main Reference to the original AppFrame object.
     */
    public InsightPanel(SalariesT data, AppFrame main) {
        this.data = data;
        this.main = main;
        setFocusable(true);
        setVisible(true);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        welcomeText();
        setupSector();
        setupEmployer();
        setupPosition();
        setupSalary();
        setupSubmit();

        repaint();
    }

    /**
     * Setup the welcome and explanation text, and add them to the panel.
     */
    private void welcomeText() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.PAGE_AXIS));
        Label h1 = new Label("Job Insight", SwingConstants.CENTER);
        h1.setAlignment(Label.CENTER);
        h1.setFont(AppFrame.standardFont.deriveFont(30f));
        Label p1 = new Label("Please select your filtered categories.");
        Label p2 = new Label("If nothing is selected, then all data is shown,");
        p1.setAlignment(Label.CENTER);
        p2.setAlignment(Label.CENTER);
        header.add(h1);
        header.add(p1);
        header.add(p2);
        this.add(header);
    }

    /**
     * Setup the sector selection checkbox and combobox, then add them to the panel.
     */
    private void setupSector() {
        JPanel sector = new JPanel();
        sector.setLayout(new FlowLayout());
        sList = new JComboBox<>(data.getSectors());
        sList.setPreferredSize(new Dimension(350,sList.getPreferredSize().height));
        sector.add(new Label("Sector: "));
        sBox = new JCheckBox();
        sector.add(sBox);
        sector.add(sList);
        AutoCompletion.enable(sList);
        this.add(sector);
    }

    /**
     * Setup the employer selection checkbox and combobox, then add them to the panel.
     */
    private void setupEmployer() {
        JPanel employer = new JPanel();
        employer.setLayout(new FlowLayout());
        eList = new JComboBox<>(data.getEmployers());
        eList.setPreferredSize(new Dimension(350,eList.getPreferredSize().height));
        employer.add(new Label("Employer: "));
        eBox = new JCheckBox();
        employer.add(eBox);
        employer.add(eList);
        AutoCompletion.enable(eList);
        this.add(employer);
    }

    /**
     * Setup the jon position selection checkbox and combobox, then add them to the panel.
     */
    private void setupPosition() {
        JPanel position = new JPanel();
        position.setLayout(new FlowLayout());
        posList = new JComboBox<>(data.getPositions());
        posList.setPreferredSize(new Dimension(350,posList.getPreferredSize().height));
        position.add(new Label("Position: "));
        posBox = new JCheckBox();
        position.add(posBox);
        position.add(posList);
        AutoCompletion.enable(posList);
        this.add(position);
    }

    /**
     * Setup the salary range formatted input boxes, then add them to the panel.
     */
    private void setupSalary() {
        JPanel salary = new JPanel();
        salary.setLayout(new FlowLayout());

        NumberFormat format = NumberFormat.getIntegerInstance();
        format.setGroupingUsed(false);
        NumberFormatter numFormat = new NumberFormatter(format);
        numFormat.setValueClass(Long.class);
        numFormat.setAllowsInvalid(false);
        min = new JFormattedTextField(numFormat);
        min.setPreferredSize(new Dimension(100, min.getPreferredSize().height));
        max = new JFormattedTextField(numFormat);
        max.setPreferredSize(new Dimension(100, min.getPreferredSize().height));
        salBox = new JCheckBox();
        min.setValue(0);
        max.setValue(1000000);
        salary.add(new Label("Salary: "));
        salary.add(salBox);
        salary.add(new Label("Min $"));
        salary.add(min);
        salary.add(new Label("Max $"));
        salary.add(max);
        this.add(salary);
    }

    /**
     * Setup the submit and go back buttons, then add them to the panel.
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

        this.add(buttonRow);
    }

    /**
     * Instantiate a InsightOutputFrame object with some desired output data.
     */
    public void outputBox(SalariesT outputData) {
        new InsightOutputFrame(outputData);
    }

    /**
     * Determine which filters have been selected, and apply filters to the data accordingly.
     * Then, call outputBox with the data.
     */
    private void showResults() {
        System.out.println(data.size());
        SalariesT copy = data.copy();
        System.out.println(copy.size());

        if(sBox.isSelected()) {
            copy = copy.filterSector(String.valueOf(sList.getSelectedItem()));
        }
        if(eBox.isSelected()) {
            copy = copy.filterEmployer(String.valueOf(eList.getSelectedItem()));
        }
        if(posBox.isSelected()) {
            copy = copy.filterPosition(String.valueOf(posList.getSelectedItem()));
        }
        if(salBox.isSelected()) {
            int l = Integer.parseInt(String.valueOf(min.getValue()));
            int h = Integer.parseInt(String.valueOf(max.getValue()));
            copy = copy.filterSalary(l, h);
        }

        copy.sortSalary(false);
        outputBox(copy);
    }
}
