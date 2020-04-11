package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SortT {

    class sortBySalary implements Comparator<SalaryT> {

        @Override
        public int compare(SalaryT o1, SalaryT o2) {
            if (o1.getSalary() > o2.getSalary()) {
                return 1;
            } else if (o1.getSalary() < o2.getSalary()) {
                return 1;
            }
            return 0;
        }
    }

    class sortBySector implements Comparator<SalaryT> {

        @Override
        public int compare(SalaryT o1, SalaryT o2) {
            return o1.getSector().compareTo(o2.getSector());
        }
    }

    class sortByPosition implements Comparator<SalaryT> {

        @Override
        public int compare(SalaryT o1, SalaryT o2) {
            return o1.getPosition().compareTo(o2.getPosition());
        }
    }

    class sortByEmployer implements Comparator<SalaryT> {

        @Override
        public int compare(SalaryT o1, SalaryT o2) {
            return o1.getEmployer().compareTo(o2.getEmployer());
        }
    }

    private void merge(ArrayList<SalaryT> array, int l, int m, int h, boolean ascending, Comparator c) {
        int l1 = m - l + 1;
        int l2 = h - m;
        ArrayList<SalaryT> leftArray = new ArrayList<>(l1);
        ArrayList<SalaryT> rightArray = new ArrayList<>(l2);
        for (int i = 0; i < l1; i++) {
            leftArray.add(array.get(l + i));
        }
        for (int i = 0; i < l2; i++) {
            rightArray.add(array.get(m + i + 1));
        }
        int i = 0;
        int j = 0;
        int k = l;
        while (i < l1 && j < l2) {
            if (ascending) {
                if (c.compare(leftArray.get(i), rightArray.get(j)) <= 0) {
                    array.set(k, leftArray.get(i));
                    i++;
                } else if (c.compare(leftArray.get(i), rightArray.get(j)) > 0) {
                    array.set(k, rightArray.get(j));
                    j++;
                }
            } else {
                if (c.compare(leftArray.get(i), rightArray.get(j)) > 0) {
                    array.set(k, leftArray.get(i));
                    i++;
                } else if (c.compare(leftArray.get(i), rightArray.get(j)) <= 0) {
                    array.set(k, rightArray.get(j));
                    j++;
                }
            }
            k++;
        }
        while (i < l1) {
            array.set(k, leftArray.get(i));
            k++;
            i++;
        }
        while (j < l2) {
            array.set(k, rightArray.get(j));
            k++;
            j++;
        }
    }

    private void mergeSort(ArrayList<SalaryT> array, int l, int h, boolean ascending, Comparator c) {
        if (l < h) {
            int m = (l + h)/2;
            mergeSort(array, l, m, ascending, c);
            mergeSort(array, m+1, h, ascending, c);
            merge(array, l, m, h, ascending, c);
        }
    }

    public void sortSalary(ArrayList<SalaryT> array, boolean ascending) {
        mergeSort(array,0, array.size() - 1, ascending, new sortBySalary());
    }

    public void sortPosition(ArrayList<SalaryT> array, boolean ascending) {
        mergeSort(array,0, array.size() - 1, ascending, new sortByPosition());
    }

    public void sortSector(ArrayList<SalaryT> array, boolean ascending) {
        mergeSort(array,0, array.size() - 1, ascending, new sortBySector());
    }

    public void sortEmployer(ArrayList<SalaryT> array, boolean ascending) {
        mergeSort(array,0, array.size() - 1, ascending, new sortByEmployer());
    }
}
