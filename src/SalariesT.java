package src;

import java.util.ArrayList;
import java.util.Arrays;

public class SalariesT {
    private final ArrayList<SalaryT> s;
    private final int year;
    private final String[] sectors, employers, positions;

    public SalariesT(ArrayList<SalaryT> salaries, int year, String[] sectors, String[] employers, String[] positions) {
        this.s = salaries;
        this.year = year;
        this.sectors = sectors;
        this.employers = employers;
        this.positions = positions;
        Arrays.sort(this.sectors);
        Arrays.sort(this.employers);
        Arrays.sort(this.positions);
    }

    public SalariesT(ArrayList<SalaryT> salaries, int year) {
        this.s = salaries;
        this.year = year;
        this.sectors = null;
        this.employers = null;
        this.positions = null;
    }

    public int size() {
        return this.s.size();
    }

    public ArrayList<SalaryT> getSalaries() {
        return this.s;
    }

    public SalaryT getSalary(String name) {
        for (SalaryT e: this.s) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return null;
    }

    public void add(SalaryT salary) {
        this.s.add(salary);
    }

    public boolean isSorted() {
        for (int i = 1; i < this.s.size(); i++) {
            if (this.s.get(i - 1).getSalary() > this.s.get(i).getSalary()) {
                return false;
            }
        }
        return true;
    }

    public SalariesT copy() {
        return new SalariesT(new ArrayList<SalaryT>(this.getSalaries()), this.year);
    }

    public SalariesT filterSalary(int low, int high) {
        SalariesT salaries = new SalariesT(new ArrayList<SalaryT>(), this.year);
        for (SalaryT e: this.s) {
            if (low < e.getSalary() && e.getSalary() < high) {
                salaries.add(e);
            }
        }
        return salaries;
    }

    public SalariesT filterSector(String name) {
        SalariesT salaries = new SalariesT(new ArrayList<SalaryT>(), this.year);
        for (SalaryT e: this.s) {
            if (e.getSector().equals(name)) {
                salaries.add(e);
            }
        }
        return salaries;
    }

    public SalariesT filterEmployer(String name) {
        SalariesT salaries = new SalariesT(new ArrayList<SalaryT>(), this.year);
        for (SalaryT e: this.s) {
            if (e.getEmployer().equals(name)) {
                salaries.add(e);
            }
        }
        return salaries;
    }

    public SalariesT filterPosition(String name) {
        SalariesT salaries = new SalariesT(new ArrayList<SalaryT>(), this.year);
        for (SalaryT e: this.s) {
            if (e.getPosition().equals(name)) {
                salaries.add(e);
            }
        }
        return salaries;
    }

    public String[] getSectors() {
        return sectors;
    }

    public String[] getEmployers() {
        return employers;
    }

    public String[] getPositions() {
        return positions;
    }
}

