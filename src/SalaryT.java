
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
}