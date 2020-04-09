
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
}