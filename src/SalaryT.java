package src;
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

    public SalaryT(String sector, String firstName, String lastName, double salary, double benefits, String employer, String position, int year){
        this.firstName = firstName;
        this.lastName = lastName;
        this.name = this.lastName + " " + this.firstName;
        this.salary = salary;
        this.benefits = benefits;
        this.sector = sector;
        this.employer = employer;
        this.pos = position;
        this.year = year;
    }

    public String getName(){
        return this.name;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }
    public String getPosition(){
        return this.pos;
    }

    public String getEmployer(){
        return this.employer;
    }

    public String getSector(){
        return this.sector;
    }

    public double getSalary(){
        return this.salary;
    }

    public int getYear(){
        return this.year;
    }

    public double getBenefits() {
        return benefits;
    }

    public String toString() {
        return String.format("%s %s %s %s", this.sector, this.employer, this.pos, this.salary);
    }

    public String[] toStringArray() {
        return new String[] {this.sector, this.employer, this.pos, String.valueOf(this.salary)};
    }

    /**
     * Checks if two SalaryT objects are equal to each other
     */
    @Override
    public boolean equals(Object object){
        if (this == object)
            return true;

        if (object == null || this.getClass() != object.getClass())
            return false;

        SalaryT that = (SalaryT) object;

        return (this.name.contentEquals(that.getName()) &&
                this.pos.contentEquals(that.getPosition()) &&
                this.employer.contentEquals(that.getEmployer()) &&
                this.sector.contentEquals(that.getSector()) &&
                this.city.contentEquals(that.getCity()) &&
                this.salary == that.getSalary() &&
                this.year == that.getYear());
    }

    /**
     * Computes a hashCode for a SalaryT object.
     * A collision will occur if two people have the same name, employer and benefits.
     */
    @Override
    public int hashCode(){
        int result = this.name.hashCode();
        result *= 31 * (int) Double.hashCode(this.salary);
        result *= 31 * (int) Double.hashCode(this.benefits);
        return result;
    }
}
