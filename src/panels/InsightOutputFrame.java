package src.panels;

import src.SalariesT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class for the Insight page output frame
 */
public class InsightOutputFrame extends JFrame {

    private JPanel buttonPanel, tablePane;
    private final SalariesT data;
    private boolean sector = false, employer = false, job = false, salary = false;

    /**
     * Constructor for InsightOutputFrame. Instantiates the JFrame and defines properties on the frame.
     * @param outputData Data from which the output table is generated.
     */
    public InsightOutputFrame(SalariesT outputData) {
        this.data = outputData;

        setTitle("Output");
        setResizable(false);
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(800,600));

        refresh();

        pack();
        setVisible(true);
    }

    /**
     * Sets up the table panel with the SalariesT output, and adds it to the frame.
     */
    private void setupTablePane() {
        int max = data.size();
        String[][] rows = new String[max][4];

        for(int i=0; i<max; i++) {
            rows[i] = data.getSalaries().get(i).toStringArray();
        }

        String[] columnNames = { "Sector", "Employer", "Job", "Salary" };

        JTable j = new JTable(rows, columnNames);

        JScrollPane sp = new JScrollPane(j);
        sp.setPreferredSize(new Dimension(790,520));

        tablePane = new JPanel();
        tablePane.add(sp);
    }

    /**
     * Refreshes the table after a change in the data sorting.
     */
    private void refresh() {
        getContentPane().removeAll();

        setupTablePane();
        setupButtons();

        JPanel outPanel = new JPanel();
        outPanel.setLayout(new FlowLayout());
        outPanel.add(buttonPanel);
        outPanel.add(tablePane);

        add(outPanel);

        revalidate();
        repaint();
    }

    /**
     * Creates the table sorting buttons and adds their action listening logic.
     * Adds the buttons to the frame.
     */
    private void setupButtons() {
        buttonPanel = new JPanel();
        Button s1 = new Button("Sort Sector"), s2 = new Button("Sort Employer"), s3 = new Button("Sort Job"), s4 = new Button("Sort Salary");
        s1.setName("sectorsort");
        s2.setName("employersort");
        s3.setName("jobsort");
        s4.setName("salarysort");

        ActionListener ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Button pressed = (Button) e.getSource();
                if(pressed.getName().equals("sectorsort")) {
                    sector = !sector;
                    data.sortSector(sector);
                    refresh();
                } else if(pressed.getName().equals("employersort")) {
                    employer = !employer;
                    data.sortEmployer(employer);
                    refresh();
                } else if(pressed.getName().equals("jobsort")) {
                    job = !job;
                    data.sortPosition(job);
                    refresh();
                } else if(pressed.getName().equals("salarysort")) {
                    salary = !salary;
                    data.sortSalary(salary);
                    refresh();
                }
            }
        };

        s1.addActionListener(ac);
        s2.addActionListener(ac);
        s3.addActionListener(ac);
        s4.addActionListener(ac);

        buttonPanel.add(s1);
        buttonPanel.add(s2);
        buttonPanel.add(s3);
        buttonPanel.add(s4);
    }
}
