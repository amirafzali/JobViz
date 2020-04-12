package src;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * A class containing sorting algorithms for SalaryT arrays
 *
 */
public class SortT {

	/**
	 * A comparator for salary based sorting
	 */
	static class sortBySalary implements Comparator<SalaryT> {
		@Override
		public int compare(SalaryT o1, SalaryT o2) {
			if (o1.getSalary() > o2.getSalary()) {
				return -1;
			} else if (o1.getSalary() < o2.getSalary()) {
				return 1;
			}
			return 0;
		}
	}

	/**
	 * A comparator for sector based sorting
	 */
	static class sortBySector implements Comparator<SalaryT> {
		@Override
		public int compare(SalaryT o1, SalaryT o2) {
			return o1.getSector().compareTo(o2.getSector());
		}
	}

	/**
	 * A comparator for position based sorting
	 */
	static class sortByPosition implements Comparator<SalaryT> {
		@Override
		public int compare(SalaryT o1, SalaryT o2) {
			return o1.getPosition().compareTo(o2.getPosition());
		}
	}

	/**
	 * A comparator for employer based sorting
	 */
	static class sortByEmployer implements Comparator<SalaryT> {
		@Override
		public int compare(SalaryT o1, SalaryT o2) {
			return o1.getEmployer().compareTo(o2.getEmployer());
		}
	}

	/**
	 * Merges two sorted segments of the array into one sorted segment
	 *
	 * @param array     The array being sorted and merged
	 * @param l         The lower index
	 * @param m         The mid point
	 * @param h         The upper index
	 * @param ascending A boolean to determine if sorting is ascending or descending
	 * @param c         The comparator being used for the sort
	 */
	private void merge(ArrayList<SalaryT> array, int l, int m, int h, boolean ascending, Comparator<SalaryT> c) {
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

	/**
	 * Merge sort implementation
	 *
	 * @param array     The array to be sorted
	 * @param l         The lower index bound
	 * @param h         The upper index bound
	 * @param ascending A boolean value to determine whether ascending or descending
	 *                  sort
	 * @param c         The comparator being used
	 */
	public void mergeSort(ArrayList<SalaryT> array, int l, int h, boolean ascending, Comparator<SalaryT> c) {
		if (l < h) {
			int m = (l + h) / 2;
			mergeSort(array, l, m, ascending, c);
			mergeSort(array, m + 1, h, ascending, c);
			merge(array, l, m, h, ascending, c);
		}
	}
}
