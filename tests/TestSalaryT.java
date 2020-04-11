package tests;

import org.junit.*;

import exceptions.InvalidDataLineException;

import static org.junit.Assert.*;

import java.util.ArrayList;

import src.SalaryT;

public class TestSalaryT {
    private SalaryT s1, s2, s3, s4, s5, s6;

    private String fn1, fn2, fn3, fn4, fn5, fn6;
    private String ln1, ln2, ln3, ln4, ln5, ln6;
    private String p1, p2, p3, p4, p5, p6;
    private String e1, e2, e3, e4, e5, e6;
    private String se1, se2, se3, se4, se5, se6;
    private double sa1, sa2, sa3, sa4, sa5, sa6;
    private double b1, b2, b3, b4, b5, b6;
    private int y1, y2, y3, y4, y5, y6;

    @Before
    public void setUp(){
    	fn1 = "Sadiq"; 
    	fn2 = "Bob"; 
    	fn3 = "! &!@, $1,2g_(&!@ , `~|   52\"';a1?";
    	fn4 = "";
    	fn5 = "Luca S.";
    	fn6 = null;
    	
    	ln1 = "Abbas"; 
    	ln2 = "Bob";
    	ln3 = "|}{<!@, > 7,  ,  !a,  b,,?<(&(!";
    	ln4 = "";
    	ln5 = "Militello";
    	ln6 = null;
    	
    	p1 = "Professor"; 
    	p2 = "Bob"; 
    	p3 = ",1 23#1 >/>,., ++= 12";
    	p4 = "";
    	p5 = "Paramedic Level 1";
    	p6 = null;
    	
    	e1 = "Algonquin College Of Applied Arts and Technology"; 
    	e2 = "Bob"; 
    	e3 = ",1%6^)(1 >/>,., +|~`= 41";
    	e4 = "";
    	e5 = "City Of Toronto";
    	e6 = null;
    	
    	se1 = "Colleges"; 
    	se2 = "Bob"; 
    	se3 = "!, $<!1,@7,  ,  6!a         j";
    	se4 = "";
    	se5 = "Municipalities & Services";
    	se6 = null;
    	
    	sa1 = 111442.39; 
    	sa2 = 10; 
    	sa3 = 99999.812479;
    	sa4 = 524012.64;
    	sa5 = 0.00;
    	sa6 = -137412.12;
    	
    	b1 = 68.16;	
    	b2 = 10; 
    	b3 = 423.014125;
    	b4 = 39.48;
    	b5 = 0.0000;
    	b6 = -749290.42;
    	
    	y1 = 2019; 
    	y2 = 10;
    	y3 = 14214;
    	y4 = 2017;
    	y5 = 0;
    	y6 = -237918;
    	
        s1 = new SalaryT(se1, fn1, ln1, sa1, b1, e1, p1, y1);
        s2 = new SalaryT(se2, fn2, ln2, sa2, b2, e2, p2, y2);
        s3 = new SalaryT(se3, fn3, ln3, sa3, b3, e3, p3, y3);
        s4 = new SalaryT(se4, fn4, ln4, sa4, b4, e4, p4, y4);
        s5 = new SalaryT(se5, fn5, ln5, sa5, b5, e5, p5, y5);
        s6 = new SalaryT(se6, fn6, ln6, sa6, b6, e6, p6, y6);
    }

    @After
    public void tearDown(){
    	fn1 = null; 
    	fn2 = null; 
    	fn3 = null;
    	fn4 = null;
    	fn5 = null;
    	fn6 = null;
    	
    	ln1 = null; 
    	ln2 = null;
    	ln3 = null;
    	ln4 = null;
    	ln5 = null;
    	ln6 = null;
    	
    	p1 = null; 
    	p2 = null; 
    	p3 = null;
    	p4 = null;
    	p5 = null;
    	p6 = null;
    	
    	e1 = null; 
    	e2 = null; 
    	e3 = null;
    	e4 = null;
    	e5 = null;
    	e6 = null;
    	
    	se1 = null; 
    	se2 = null; 
    	se3 = null;
    	se4 = null;
    	se5 = null;
    	se6 = null;
    	    	
        s1 = null;
        s2 = null;
        s3 = null;
        s4 = null;
        s5 = null;
        s6 = null;
    }

    @Test (expected = NullPointerException.class)
    public void testFirstName(){
    	assertTrue(s1.getFirstName().contentEquals("Sadiq"));
    	assertTrue(s1.getFirstName().equals(new String("Sadiq")));
    	assertFalse(s1.getFirstName() == new String("Sadiq"));
    	
    	assertTrue(s2.getFirstName().contentEquals("Bob"));
    	
    	assertTrue(s3.getFirstName().contentEquals("! &!@, $1,2g_(&!@ , `~|   52\"';a1?"));
    	assertTrue(s3.getFirstName().equals(new String("! &!@, $1,2g_(&!@ , `~|   52\"';a1?")));
    	assertFalse(s3.getFirstName() == new String("! &!@, $1,2g_(&!@ , `~|   52\"';a1?"));
    	
    	assertTrue(s4.getFirstName().contentEquals(""));
    	assertTrue(s4.getFirstName().equals(new String("")));
    	assertFalse(s4.getFirstName() == new String(""));
    	
    	assertTrue(s5.getFirstName().contentEquals("Luca S."));
    	
    	assertTrue(s6.getFirstName() == null);
    	assertTrue(s6.getFirstName().equals(null));  	
    }
    
    @Test (expected = NullPointerException.class)
    public void testLastName(){
    	assertTrue(s1.getLastName().contentEquals("Abbas"));
    	assertTrue(s1.getLastName().equals(new String("Abbas")));
    	assertFalse(s1.getLastName() == new String("Abbas"));
    	
    	assertTrue(s2.getLastName().contentEquals("Bob"));
    	
    	assertTrue(s3.getLastName().contentEquals("|}{<!@, > 7,  ,  !a,  b,,?<(&(!"));
    	assertTrue(s3.getLastName().equals(new String("|}{<!@, > 7,  ,  !a,  b,,?<(&(!")));
    	assertFalse(s3.getLastName() == new String("|}{<!@, > 7,  ,  !a,  b,,?<(&(!"));
    	
    	assertTrue(s4.getLastName().contentEquals(""));
    	assertTrue(s4.getLastName().equals(new String("")));
    	assertFalse(s4.getLastName() == new String(""));
    	
    	assertTrue(s5.getLastName().contentEquals("Militello"));
    	
    	assertTrue(s6.getLastName() == null);
    	assertTrue(s6.getLastName().equals(null));  	
    }
    
    @Test
    public void testRemainingStringGetters(){
    	assertTrue(s1.getPosition().contentEquals("Professor"));
    	assertTrue(s3.getEmployer().contentEquals(",1%6^)(1 >/>,., +|~`= 41"));
    	assertTrue(s5.getSector().contentEquals("Municipalities & Services"));
    }
    
    @Test (expected = InvalidDataLineException.class)
    public void testSalary(){
    	assertTrue(s1.getSalary() == 111442.39);
    	try {
    		assertTrue(s3.getSalary() == 99999.812479);
    	} catch (InvalidDataLineException e1) {
    		try {
    			assertTrue(s5.getSalary() == 0.00);
    		} catch (InvalidDataLineException e2) {
    			assertTrue(s6.getSalary() == -137412.12);
    		}
    	}
    }
    
    @Test (expected = InvalidDataLineException.class)
    public void testBenefits(){
    	assertTrue(s1.getBenefits() == 68.16);
    	assertTrue(s3.getBenefits() == 423.014125);
    	assertTrue(s5.getSalary() == 0.00);
    	assertTrue(s6.getSalary() == -749290.42);
    }
    
    @Test (expected = InvalidDataLineException.class)
    public void testYear(){
    	assertTrue(s1.getYear() == 2019);
    	assertTrue(s3.getYear() == 14214);
    	assertTrue(s5.getYear() == 0.00);
    	assertTrue(s6.getYear() == -237918);
    }
}