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

    private void merge(int l, int m, int h, boolean ascending) {
        int l1 = m - l + 1;
        int l2 = h - m;
        ArrayList<SalaryT> leftArray = new ArrayList<>(l1);
        ArrayList<SalaryT> rightArray = new ArrayList<>(l2);
        for (int i = 0; i < l1; i++) {
            leftArray.add(this.s.get(l + i));
        }
        for (int i = 0; i < l2; i++) {
            rightArray.add(this.s.get(m + i + 1));
        }
        int i = 0;
        int j = 0;
        int k = l;
        while (i < l1 && j < l2) {
            if (ascending) {
                if (leftArray.get(i).getSalary() <= rightArray.get(j).getSalary()) {
                    this.s.set(k, leftArray.get(i));
                    i++;
                } else if (leftArray.get(i).getSalary() > rightArray.get(j).getSalary()) {
                    this.s.set(k, rightArray.get(j));
                    j++;
                }
            } else {
                if (leftArray.get(i).getSalary() > rightArray.get(j).getSalary()) {
                    this.s.set(k, leftArray.get(i));
                    i++;
                } else if (leftArray.get(i).getSalary() <= rightArray.get(j).getSalary()) {
                    this.s.set(k, rightArray.get(j));
                    j++;
                }
            }
            k++;
        }
        while (i < l1) {
            this.s.set(k, leftArray.get(i));
            k++;
            i++;
        }
        while (j < l2) {
            this.s.set(k, rightArray.get(j));
            k++;
            j++;
        }
    }

    private void mergeSort(int l, int h, boolean ascending) {
        if (l < h) {
            int m = (l + h)/2;
            mergeSort(l, m, ascending);
            mergeSort(m+1, h, ascending);
            merge(l, m, h, ascending);
        }
    }

    public void sort(boolean ascending) {
        mergeSort(0, this.s.size() - 1, ascending);
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

