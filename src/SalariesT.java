package src;

import java.util.ArrayList;
import java.util.Arrays;

public class SalariesT extends SortT{
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
        return this.getSalaries().size();
    }

    public ArrayList<SalaryT> getSalaries() {
        return this.s;
    }

    public SalaryT getSalary(String name) {
        for (SalaryT e: this.getSalaries()) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return null;
    }

    public void add(SalaryT salary) {
        this.getSalaries().add(salary);
    }

    public void sortSalary(boolean ascending) {
        mergeSort(this.getSalaries(),0, this.getSalaries().size() - 1, ascending, new sortBySalary());
    }

    public void sortPosition(boolean ascending) {
        mergeSort(this.getSalaries(),0, this.getSalaries().size() - 1, ascending, new sortByPosition());
    }

    public void sortSector(boolean ascending) {
        mergeSort(this.getSalaries(),0, this.getSalaries().size() - 1, ascending, new sortBySector());
    }

    public void sortEmployer(boolean ascending) {
        mergeSort(this.getSalaries(),0, this.getSalaries().size() - 1, ascending, new sortByEmployer());
    }

    public boolean isSorted() {
        for (int i = 1; i < this.size(); i++) {
            if (this.getSalaries().get(i - 1).getSalary() > this.getSalaries().get(i).getSalary()) {
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
        for (SalaryT e: this.getSalaries()) {
            if (low < e.getSalary() && e.getSalary() < high) {
                salaries.add(e);
            }
        }
        return salaries;
    }

    public SalariesT filterSector(String name) {
        SalariesT salaries = new SalariesT(new ArrayList<SalaryT>(), this.year);
        for (SalaryT e: this.getSalaries()) {
            if (e.getSector().equals(name)) {
                salaries.add(e);
            }
        }
        return salaries;
    }

    public SalariesT filterEmployer(String name) {
        SalariesT salaries = new SalariesT(new ArrayList<SalaryT>(), this.year);
        for (SalaryT e: this.getSalaries()) {
            if (e.getEmployer().equals(name)) {
                salaries.add(e);
            }
        }
        return salaries;
    }

    public SalariesT filterPosition(String name) {
        SalariesT salaries = new SalariesT(new ArrayList<SalaryT>(), this.year);
        for (SalaryT e: this.getSalaries()) {
            if (e.getPosition().equals(name)) {
                salaries.add(e);
            }
        }
        return salaries;
    }

    public double positionMedian(String position) {
        double median = 0.0;
        for (SalaryT e: this.filterPosition(position).getSalaries()) {
            median += e.getSalary();
        }
        median = median/this.filterPosition(position).getSalaries().size();
        return median;
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

