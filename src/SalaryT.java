package src;

import exceptions.InvalidDataLineException;

/**
 * Blah blah blah
 * 
 * @author jarrodcolwell
 *
 */
public class SalaryT {
	private final String name;
	private final String pos;
	private final String employer;
	private final String sector;
	private final double salary;
	private final double benefits;
	private final int year;
	private final String firstName;
	private final String lastName;

	/**
	 * Constructor for SalaryT
	 * 
	 * @param sector    A string with the name of the sector
	 * @param firstName A string of the first name of the individual
	 * @param lastName  A string of the last name of the individual
	 * @param salary    A double representing the salary
	 * @param benefits  A double of the taxable benefits
	 * @param employer  A string with the name of the employer
	 * @param position  A string with the name of the position
	 * @param year      An int representing the year
	 * @throws InvalidDataLineException If salary < 100000, year < 0, or benefits <
	 *                                  0
	 */
	public SalaryT(String sector, String firstName, String lastName, double salary, double benefits, String employer,
			String position, int year) throws InvalidDataLineException {
		this.firstName = firstName;
		this.lastName = lastName;
		this.name = this.lastName + " " + this.firstName;
		this.salary = salary;
		this.benefits = benefits;
		this.sector = sector;
		this.employer = employer;
		this.pos = position;
		this.year = year;
		if (this.salary < 100000)
			throw new InvalidDataLineException();
		if (this.year < 0)
			throw new InvalidDataLineException();
		if (this.benefits < 0)
			throw new InvalidDataLineException();
	}

	/**
	 * @return String The name of the individual
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return String The first name of the individual
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * @return String The last name of the individual
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * @return String The name of the position
	 */
	public String getPosition() {
		return this.pos;
	}

	/**
	 * @return String The name of the employer
	 */
	public String getEmployer() {
		return this.employer;
	}

	/**
	 * @return String The name of the sector
	 */
	public String getSector() {
		return this.sector;
	}

	/**
	 * @return double The salary
	 */
	public double getSalary() {
		return this.salary;
	}

	/**
	 * @return int The year
	 */
	public int getYear() {

		return this.year;
	}

	/**
	 * @return double The taxable benefits
	 */
	public double getBenefits() {
		return benefits;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s %s", this.sector, this.employer, this.pos, this.salary);
	}

	public String[] toStringArray() {
		return new String[] { this.sector, this.employer, this.pos, String.valueOf(this.salary) };
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;

		if (object == null || this.getClass() != object.getClass())
			return false;

		SalaryT that = (SalaryT) object;

		return (this.name.contentEquals(that.getName()) && this.pos.contentEquals(that.getPosition())
				&& this.employer.contentEquals(that.getEmployer()) && this.sector.contentEquals(that.getSector())
				&& this.salary == that.getSalary() && this.year == that.getYear());
	}

	@Override
	public int hashCode() {
		int result = this.name.hashCode();
		result *= 31 * Double.hashCode(this.salary);
		result *= 31 * Double.hashCode(this.benefits);
		return result;
	}
}
