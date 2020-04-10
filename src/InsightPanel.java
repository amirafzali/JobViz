package src;

import lib.AutoCompletion;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsightPanel extends JPanel implements ActionListener {
    private JPanel header, sector, employer, position;
    private SalariesT data;
    private JCheckBox sBox, eBox,posBox;
    private JComboBox<String> sList, eList, posList;
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
        Label p2 = new Label("If nothing is selected, then the top 500 results are shown.");
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
        sList = new JComboBox<>(data.getSectors());
        sList.setPreferredSize(new Dimension(350,sList.getPreferredSize().height));
        sector.add(new Label("Sector: "));
        sBox = new JCheckBox();
        sector.add(sBox);
        sector.add(sList);

        this.add(sector);
        System.out.println("x");
    }

    private void setupEmployer() {
        employer = new JPanel();
        employer.setLayout(new FlowLayout());
        eList = new JComboBox<>(data.getEmployers());
        eList.setPreferredSize(new Dimension(350,eList.getPreferredSize().height));
        employer.add(new Label("Employer: "));
        eBox = new JCheckBox();
        employer.add(eBox);
        employer.add(eList);

        this.add(employer);
        System.out.println("x");
    }

    private void setupPosition() {
        position = new JPanel();
        position.setLayout(new FlowLayout());
        posList = new JComboBox<>(data.getPositions());
        posList.setPreferredSize(new Dimension(350,posList.getPreferredSize().height));
        position.add(new Label("Position: "));
        posBox = new JCheckBox();
        position.add(posBox);
        position.add(posList);
        AutoCompletion.enable(posList);
        this.add(position);
        System.out.println("x");
    }

    private void setupSubmit() {
        Button submit = new Button("Show Results!");
        submit.addActionListener(this);
        this.add(submit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        showResults();
    }

    public void outputBox(SalariesT outputData) {
        JFrame frame = new JFrame();
        frame.setTitle("Output");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800,500));
        String[][] data = new String[outputData.size()][4];

        for(int i=0; i<outputData.size(); i++) {
            data[i] = outputData.getSalaries().get(i).toStringArray();
        }


        // Column Names
        String[] columnNames = { "Sector", "Employer", "Job", "Salary" };

        //frame.add(t);
        JTable j = new JTable(data, columnNames);
        j.setBounds(30, 40, 200, 300);

        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j);
        frame.add(sp);
        frame.pack();
        frame.setVisible(true);
    }

    private void showResults() {
        System.out.println(data.size());
        SalariesT copy = data.copy();
        System.out.println(copy.size());
        System.out.println(sList.getSelectedItem());
        if(sBox.isSelected()) {
            copy = copy.filterSector(String.valueOf(sList.getSelectedItem()));
        }
        System.out.println(copy.size());
        copy.sort();
        outputBox(copy);
    }
}
