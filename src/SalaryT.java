package src;
public class SalaryT {
    private String name; //Format as lastname, firstname
    private String pos;
    private String employer;
    private String sect;
    private String city;
    private int sal;
    private int year;

    public SalaryT(String name, int salary, String sector, String employer, String position, String city, int year){
        this.name = name;
        this.sal = salary;
        this.sect = sector;
        this.employer = employer;
        this.pos = position;
        this.city = city;
        this.year = year;
    }

    public String getName(){
        return this.name;
    }

    public String getPosition(){
        return this.pos;
    }

    public String getEmployer(){
        return this.employer;
    }

    public String getSector(){
        return this.sect;
    }

    public String getCity(){
        return this.city;
    }

    public int getSalary(){
        return this.sal;
    }

    public int getYear(){
        return this.year;
    }

    /**
     * Checks if two SalaryT objects are equal to each other
     */
    @Override
    public boolean equals(Object object){
        if (this == object) 
            return true;

        if (object == null) 
            return false;

        if (this.getClass() != object.getClass())
            return false;

        SalaryT that = (SalaryT) object;

        return (this.name.contentEquals(that.getName()) &&
                this.pos.contentEquals(that.getPosition()) &&
                this.employer.contentEquals(that.getEmployer()) &&
                this.sect.contentEquals(that.getSector()) &&
                this.city.contentEquals(that.getCity()) &&
                this.sal == that.getSalary() &&
                this.year == that.getYear());
    }

    /**
     * Computes a hashCode for a SalaryT object. 
     * A collision will occur if two people have the same name, employer and salary.
     */
    @Override
    public int hashCode(){
        int result = this.name.hashCode();
        result *= 31 * (int) (this.sal ^ (this.sal >>> 32));
        result *= 31 * this.employer.hashCode();
        return result;
    }
}