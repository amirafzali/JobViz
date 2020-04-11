package src;

import java.util.ArrayList;
import java.util.Arrays;

public class SalariesT extends SortT {
	private final ArrayList<SalaryT> s;
	private final int year;
	private final String[] sectors, employers, positions;

	/**
	 * Constructor for SalariesT
	 * 
	 * @param salaries  The salaries being stored
	 * @param year      The year the salaries are from
	 * @param sectors   The array of sectors present in the salaries
	 * @param employers The array of employers present in the salaries
	 * @param positions The array of positions present in the salaries
	 */
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

	/**
	 * Constructor for SalariesT
	 * 
	 * @param salaries The salaries being stored
	 * @param year     The year the salaries are from
	 */
	public SalariesT(ArrayList<SalaryT> salaries, int year) {
		this.s = salaries;
		this.year = year;
		this.sectors = null;
		this.employers = null;
		this.positions = null;
	}

	/**
	 * Size method for SalariesT
	 * 
	 * @return int The number of salaries
	 */
	public int size() {
		return this.getSalaries().size();
	}

	/**
	 * Get method for salaries
	 * 
	 * @return ArrayList<SalaryT> The list of salaries
	 */
	public ArrayList<SalaryT> getSalaries() {
		return this.s;
	}

	/**
	 * Get method for an individual's Salary
	 * 
	 * @param name The name of the individual who's salary is being retrieved
	 * @return SalaryT The individual's SalaryT object if it exists, null otherwise
	 */
	public SalaryT getSalary(String name) {
		for (SalaryT e : this.getSalaries()) {
			if (e.getName().equals(name)) {
				return e;
			}
		}
		return null;
	}

	/**
	 * Method that adds a salary to the list of salaries
	 * 
	 * @param salary The salary to be added
	 */
	public void add(SalaryT salary) {
		this.getSalaries().add(salary);
	}

	/**
	 * The public interface for sorting salary
	 * 
	 * @param ascending A boolean representing sort order
	 */
	public void sortSalary(boolean ascending) {
		mergeSort(this.getSalaries(), 0, this.getSalaries().size() - 1, ascending, new sortBySalary());
	}

	/**
	 * The public interface for sorting position
	 * 
	 * @param ascending A boolean representing sort order
	 */
	public void sortPosition(boolean ascending) {
		mergeSort(this.getSalaries(), 0, this.getSalaries().size() - 1, ascending, new sortByPosition());
	}

	/**
	 * The public interface for sorting sector
	 * 
	 * @param ascending A boolean representing sort order
	 */
	public void sortSector(boolean ascending) {
		mergeSort(this.getSalaries(), 0, this.getSalaries().size() - 1, ascending, new sortBySector());
	}

	/**
	 * The public interface for sorting employer
	 * 
	 * @param ascending A boolean representing sort order
	 */
	public void sortEmployer(boolean ascending) {
		mergeSort(this.getSalaries(), 0, this.getSalaries().size() - 1, ascending, new sortByEmployer());
	}

	/**
	 * Method to check if the salaries are sorted in ascending order
	 * 
	 * @return boolean True if the salaries are sorted, false otherwise
	 */
	public boolean isSorted() {
		for (int i = 1; i < this.size(); i++) {
			if (this.getSalaries().get(i - 1).getSalary() > this.getSalaries().get(i).getSalary()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Method to copy a SalariesT object into another
	 * 
	 * @return SalariesT New SalariesT with copied values
	 */
	public SalariesT copy() {
		return new SalariesT(new ArrayList<SalaryT>(this.getSalaries()), this.year);
	}

	/**
	 * Creates a new Salaries object and adds only those with salaries between the
	 * upper and lower bounds
	 * 
	 * @param low  The lower bound on salary
	 * @param high The upper bound on salary
	 * @return SalariesT All of the salaries that fall between the lower and upper
	 *         bounds
	 */
	public SalariesT filterSalary(int low, int high) {
		SalariesT salaries = new SalariesT(new ArrayList<SalaryT>(), this.year);
		for (SalaryT e : this.getSalaries()) {
			if (low < e.getSalary() && e.getSalary() < high) {
				salaries.add(e);
			}
		}
		return salaries;
	}

	/**
	 * Creates a new Salaries object and adds only those that have the same sector
	 * as the parameter
	 * 
	 * @param sector The name of the desired sector
	 * @return SalariesT All of the salaries that are in the desired sector
	 */
	public SalariesT filterSector(String sector) {
		SalariesT salaries = new SalariesT(new ArrayList<SalaryT>(), this.year);
		for (SalaryT e : this.getSalaries()) {
			if (e.getSector().equals(sector)) {
				salaries.add(e);
			}
		}
		return salaries;
	}

	/**
	 * Creates a new Salaries object and adds only those that have the same employer
	 * as the parameter
	 * 
	 * @param employer The name of the desired employer
	 * @return SalariesT All of the salaries with the desired employer
	 */
	public SalariesT filterEmployer(String employer) {
		SalariesT salaries = new SalariesT(new ArrayList<SalaryT>(), this.year);
		for (SalaryT e : this.getSalaries()) {
			if (e.getEmployer().equals(employer)) {
				salaries.add(e);
			}
		}
		return salaries;
	}

	/**
	 * Creates a new Salaries object and adds only those that have the same position
	 * as the parameter
	 * 
	 * @param position The name of the desired position
	 * @return SalariesT All of the salaries with the desired position
	 */
	public SalariesT filterPosition(String position) {
		SalariesT salaries = new SalariesT(new ArrayList<SalaryT>(), this.year);
		for (SalaryT e : this.getSalaries()) {
			if (e.getPosition().equals(position)) {
				salaries.add(e);
			}
		}
		return salaries;
	}

	/**
	 * Finds the mean salary for a position
	 * 
	 * @param position The position for which a mean is being found
	 * @return double The mean salary of the position
	 */
	public double positionMean(String position) {
		double median = 0.0;
		for (SalaryT e : this.filterPosition(position).getSalaries()) {
			median += e.getSalary();
		}
		median = median / this.filterPosition(position).getSalaries().size();
		return median;
	}

	/**
	 * Get method for the sorted sectors
	 * 
	 * @return String[] The sorted string array of sectors
	 */
	public String[] getSectors() {
		return sectors;
	}

	/**
	 * Get method for the sorted sectors
	 * 
	 * @return String[] The sorted string array of employers
	 */
	public String[] getEmployers() {
		return employers;
	}

	/**
	 * Get method for the sorted positions
	 * 
	 * @return String[] The sorted string array of positions
	 */
	public String[] getPositions() {
		return positions;
	}
}
