package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import src.SalaryT;
import src.SalariesT;

public class TestSalariesT {
	private SalaryT[] s1, s2, s3, s4;

    private String[] fn1, fn2, fn3, fn4;
    private String[] ln1, ln2, ln3, ln4;
    private String[] p1, p2, p3, p4;
    private String[] e1, e2, e3, e4;
    private String[] se1, se2, se3, se4;
    private double[] sa1, sa2, sa3;
    private double[] b1, b2, b3;
    private int[] y1, y2, y3, y4;
    
    private SalariesT ss1, ss2, ss3, ss4;
    private SalariesT ss1Alt, ss2Alt, ss3Alt, ss4Alt;
    
	private ArrayList<SalaryT> sLst1, sLst2, sLst3, sLst4;
	
	@Before
	public void setUp() throws Exception {
		s1 = new SalaryT[4];
		s2 = new SalaryT[4];
		s3 = new SalaryT[4];
		s4 = new SalaryT[4];
				
		fn1 = new String[] {"Sadiq", "Mary", "Michael", "Luca S.", }; 
    	fn2 = new String[] {"Bob", "Bob", "Bob", "Bob"}; 
    	fn3 = new String[] {"! &!@, $1,2g_(&!@ , `~|   52\"';a1?", "98@^(*^@$HJ@(*^    asDKLh!B@*&\"", "2g_(& *!", "{]a~!|,'>A     k       ds1+"};
    	fn4 = new String[] {"", "", "", ""};
    	
    	ln1 = new String[] {"Abbas", "Coady", "Ogg", "Dacey"}; 
    	ln2 = new String[] {"Bob", "Bob", "Bob", "Bob"};
    	ln3 = new String[] {"|}{<!@, > 7,  ,  !a,  b,,?<(&(!", "y| C~D", " }{%J%V", "D>A{~Rr[x6W[9p__5*  -axm*0S ka+4`l1OR"};
    	ln4 = new String[] {"", "", "", ""};
    	
    	p1 = new String[] {"Professor", "Constable", "Sergeant", "Head, Curriculum"}; 
    	p2 = new String[] {"Bob", "Bob", "Bob", "Bob"}; 
    	p3 = new String[] {",1 23#1 >/>,., ++= 12", "';ujyF< G>HS7uiK,J", " ,a$", "h;(B/yJm4"};
    	p4 = new String[] {"", "", "", ""};
    	
    	e1 = new String[] {"Algonquin College Of Applied Arts and Technology", "City Of Ottawa", "Conseil Scolaire Catholique Providence", "University Of Toronto"}; 
    	e2 = new String[] {"Bob", "Bob", "Bob", "Bob"};
    	e3 = new String[] {"7 ,", ",1%6^)(1  >/>,., +|~`= 41", "Q8W' 9R d5\r\n    2$  %   a!b875 0%", "!} k{ a s@#$P{*&F l;&YI!@$`GJAa"};
    	e4 = new String[] {"", "", "", ""};
    	
    	se1 = new String[] {"Universities", "Other Public Sector Employers", "Municipalities & Services", "Hospitals & Boards of Public Health"}; 
    	se2 = new String[] {"Bob", "Bob", "Bob", "Bob"}; 
    	se3 = new String[] {"!, $<!1,@7,  ,  6!a         j", "Y}Si", "Q8W' 9R d", "'V,7-N a+pr;hRy8*- Ij mz/L%A-BWk"};
    	se4 = new String[] {"", "", "", ""};;
    	
    	sa1 = new double[] {111442.39, 113332.96, 394259.32, 157322.35};
    	sa2 = new double[] {162236.3, 104791.75, 131774.14, 111644.17}; 
    	sa3 = new double[] {100000.00, 100000.00, 100000.00, 100000.00}; 
    	
    	
    	b1 = new double[] {68.16, 387, 11136.52, 441.5};	
    	b2 = new double[] {10.0, 145.12, 642.00, 221.24}; 
    	b3 = new double[] {0, 0, 0, 0};
    	
    	y1 = new int[] {2019, 2019, 2019, 2019}; 
    	y2 = new int[] {2016, 2017, 2019, 2021};
    	y3 = new int[] {124, 643, 21, 201521};
    	y4 = new int[] {0, 0, 0, 0};
    	
    	
        s1[0] = new SalaryT(se1[0], fn1[0], ln1[0], sa1[0], b1[0], e1[0], p1[0], y1[0]);
        s1[1] = new SalaryT(se1[1], fn1[1], ln1[1], sa1[1], b1[1], e1[1], p1[1], y1[1]);
        s1[2] = new SalaryT(se1[2], fn1[2], ln1[2], sa1[2], b1[2], e1[2], p1[2], y1[2]);
        s1[3] = new SalaryT(se1[3], fn1[3], ln1[3], sa1[3], b1[3], e1[3], p1[3], y1[3]);
        
        s2[0] = new SalaryT(se2[0], fn2[0], ln2[0], sa2[0], b2[0], e2[0], p2[0], y2[0]);
        s2[1] = new SalaryT(se2[1], fn2[1], ln2[1], sa2[1], b2[1], e2[1], p2[1], y2[1]);
        s2[2] = new SalaryT(se2[2], fn2[2], ln2[2], sa2[2], b2[2], e2[2], p2[2], y2[2]);
        s2[3] = new SalaryT(se2[3], fn2[3], ln2[3], sa2[3], b2[3], e2[3], p2[3], y2[3]);
        
        s3[0] = new SalaryT(se3[0], fn3[0], ln3[0], sa1[0], b1[0], e3[0], p3[0], y3[0]);
        s3[1] = new SalaryT(se3[1], fn3[1], ln3[1], sa1[1], b1[1], e3[1], p3[1], y3[1]);
        s3[2] = new SalaryT(se3[2], fn3[2], ln3[2], sa1[2], b1[2], e3[2], p3[2], y3[2]);
        s3[3] = new SalaryT(se3[3], fn3[3], ln3[3], sa1[3], b1[3], e3[3], p3[3], y3[3]);
        
        s4[0] = new SalaryT(se4[0], fn4[0], ln4[0], sa3[0], b3[0], e4[0], p4[0], y4[0]);
        s4[1] = new SalaryT(se4[1], fn4[1], ln4[1], sa3[1], b3[1], e4[1], p4[1], y4[1]);
        s4[2] = new SalaryT(se4[2], fn4[2], ln4[2], sa3[2], b3[2], e4[2], p4[2], y4[2]);
        s4[3] = new SalaryT(se4[3], fn4[3], ln4[3], sa3[3], b3[3], e4[3], p4[3], y4[3]);
        
        sLst1 = new ArrayList<SalaryT>(Arrays.asList(s1));
        sLst2 = new ArrayList<SalaryT>(Arrays.asList(s2));
        sLst3 = new ArrayList<SalaryT>(Arrays.asList(s3));
        sLst4 = new ArrayList<SalaryT>(Arrays.asList(s4));
        
        ss1 = new SalariesT(sLst1, y1[0], se1, e1, p1);
        ss2 = new SalariesT(sLst2, y2[0], se2, e2, p2);
        ss3 = new SalariesT(sLst3, y3[0], se3, e3, p3);
        ss4 = new SalariesT(sLst4, y4[0], se4, e4, p4);
        		
        ss1Alt = new SalariesT(sLst1, y1[0]);
        ss2Alt = new SalariesT(sLst2, y2[0]);
        ss3Alt = new SalariesT(sLst3, y3[0]);
        ss4Alt = new SalariesT(sLst4, y4[0]);
	}

	@After
	public void tearDown() throws Exception {
		s1 = null;
		s2 = null;
		s3 = null;
		s4 = null;
				
		fn1 = null; 
    	fn2 = null; 
    	fn3 = null;
    	fn4 = null;
    	
    	ln1 = null; 
    	ln2 = null;
    	ln3 = null;
    	ln4 = null;
    	
    	p1 = null; 
    	p2 = null; 
    	p3 = null;
    	p4 = null;
    	
    	e1 = null; 
    	e2 = null;
    	e3 = null;
    	e4 = null;
    	
    	se1 = null; 
    	se2 = null; 
    	se3 = null;
    	se4 = null;
    	
    	sa1 = null;
    	sa2 = null; 
    	sa3 = null; 
    	
    	b1 = null;	
    	b2 = null; 
    	b3 = null;
    	
    	y1 = null; 
    	y2 = null;
    	y3 = null;
    	y4 = null;
    	
        s1 = null;
        s2 = null;
        s3 = null;
        s4 = null;
        
        sLst1 = null;
        sLst2 = null;
        sLst3 = null;
        sLst4 = null;
        
        ss1 = null;
        ss2 = null;
        ss3 = null;
        ss4 = null;
        		
        ss1Alt = null;
        ss2Alt = null;
        ss3Alt = null;
        ss4Alt = null;
	}
	
	@Test
	public void testSize() {
		assertTrue(ss1.size() == 4);
		assertTrue(ss2.size() == 4);
		assertTrue(ss3.size() == 4);
		assertTrue(ss4.size() == 4);
		
		assertTrue(ss1Alt.size() == 4);
		assertTrue(ss2Alt.size() == 4);
		assertTrue(ss3Alt.size() == 4);
		assertTrue(ss4Alt.size() == 4);
	}
	
	@Test
	public void testGetSalaries() {
		assertTrue(ss1.getSalaries().equals(sLst1));
		assertTrue(ss2.getSalaries().equals(sLst2));
		assertTrue(ss3.getSalaries().equals(sLst3));
		assertTrue(ss4.getSalaries().equals(sLst4));
		
		assertTrue(ss1Alt.getSalaries().equals(sLst1));
		assertTrue(ss2Alt.getSalaries().equals(sLst2));
		assertTrue(ss3Alt.getSalaries().equals(sLst3));
		assertTrue(ss4Alt.getSalaries().equals(sLst4));
	}
	
	@Test
	public void testGetSalary() {
		assertTrue(ss1.getSalary(fn1[0] + " " + ln1[0]).equals(s1[0]));
		
		assertTrue(ss2.getSalary(fn2[0] + " " + ln2[0]).equals(s2[0]));
		//Duplicate names return the first occurrence
		assertFalse(ss2.getSalary(fn2[1] + " " + ln2[1]).equals(s2[1]));
		assertTrue(ss2.getSalary(fn2[1] + " " + ln2[1]).equals(s2[0]));
		assertFalse(ss2.getSalary(fn2[2] + " " + ln2[2]).equals(s2[2]));
		assertTrue(ss2.getSalary(fn2[2] + " " + ln2[2]).equals(s2[0]));
		assertFalse(ss2.getSalary(fn2[3] + " " + ln2[3]).equals(s2[3]));
		assertTrue(ss2.getSalary(fn2[3] + " " + ln2[3]).equals(s2[0]));
		
		assertTrue(ss3.getSalary(fn3[3] + " " + ln3[3]).equals(s3[3]));
		assertTrue(ss4.getSalary(fn4[0] + " " + ln4[0]).equals(s4[0]));

		//Works the same with alternate constructor
		assertTrue(ss1Alt.getSalary(fn1[0] + " " + ln1[0]).equals(s1[0]));
	}
	
	@Test
	public void testAdd() {
		//Add new value
		assertTrue(ss1.getSalary(s2[0].getName()) == null);
		ss1.add(s2[0]);
		assertTrue(ss1.getSalary(s2[0].getName()).equals(s2[0]));
		
		//Add duplicate
		assertTrue(ss1.size() == 5);
		ss1.add(s1[0]);
		assertTrue(ss1.size() == 6);
		
		//Works the same with alternate constructor
		assertTrue(ss2Alt.getSalary(s3[0].getName()) == null);
		ss2Alt.add(s3[0]);
		assertTrue(ss2Alt.getSalary(s3[0].getName()).equals(s3[0]));
	}
	
	@Test
	public void testCopy() {
		//Different object instance
		assertFalse(ss1.copy() == ss1);
		assertFalse(ss1.copy().equals(ss1));
		
		//Salaries are copied
		assertFalse(ss2.getSalaries().equals(ss1.getSalaries()));
		ss2 = ss1.copy();
		assertTrue(ss2.getSalaries().equals(ss1.getSalaries()));
	}
	
	@Test (expected = NullPointerException.class)
	public void testFilterEmployer() {
		ss2 = ss2.filterEmployer("Not A Real Employer");
		assertTrue(ss2.size() == 0);
		
		//Empty string filtering
		ss4 = ss4.filterEmployer("");
		assertTrue(ss4.size() == 4);
		ss4 = ss4.filterEmployer(" ");
		assertTrue(ss4.size() == 0);
		
		//Exists before filtering
		assertTrue(ss1.getSalary("Sadiq Abbas").getEmployer().contentEquals("Algonquin College Of Applied Arts and Technology"));
		ss1 = ss1.filterEmployer("City Of Ottawa");
		//Object still exists
		assertTrue(ss1.getSalary("Mary Coady").getEmployer().contentEquals("City Of Ottawa"));
		//Other object no longer exists
		assertFalse(ss1.getSalary("Sadiq Abbas").getEmployer().contentEquals("Algonquin College Of Applied Arts and Technology"));		
	}
	
	@Test (expected = NullPointerException.class)
	public void testFilterSalary() {
		ss2 = ss2.filterSalary(1000000, 1000001);
		assertTrue(ss2.size() == 0);
		
		//Edge case filtering
		SalariesT temp = ss4;
		ss4 = ss4.filterSalary(99999, 100001);
		assertTrue(ss4.size() == 4);
		ss4 = ss4.filterSalary(99999, 100000);
		assertTrue(ss4.size() == 0);
		ss4 = temp.filterSalary(100000, 100001);
		assertTrue(ss4.size() == 0);
		
		//Exists before filtering
		assertTrue(ss1.getSalary("Sadiq Abbas").getSalary() == 111442.39);
		assertTrue(ss1.getSalary("Mary Coady").getSalary() == 113332.96);
		ss1 = ss1.filterSalary(111440, 111445);
		//Object still exists
		assertTrue(ss1.getSalary("Sadiq Abbas").getSalary()  == 111442.39);
		//Other object no longer exists
		assertFalse(ss1.getSalary("Mary Coady").getSalary() == 113332.96);		
	}
	
	@Test (expected = NullPointerException.class)
	public void testFilterSector() {
		ss2 = ss2.filterSector("Not A Real Sector");
		assertTrue(ss2.size() == 0);
		
		//Empty string filtering
		ss4 = ss4.filterSector("");
		assertTrue(ss4.size() == 4);
		ss4 = ss4.filterSector(" ");
		assertTrue(ss4.size() == 0);
				
		//Exists before filtering
		assertTrue(ss1.getSalary("Sadiq Abbas").getSector().contentEquals("Universities"));
		assertTrue(ss1.getSalary("Mary Coady").getSector().contentEquals("Other Public Sector Employers"));
		ss1 = ss1.filterSector("Other Public Sector Employers");
		//Object still exists
		assertTrue(ss1.getSalary("Mary Coady").getSector().contentEquals("Other Public Sector Employers"));
		//Other object no longer exists
		assertFalse(ss1.getSalary("Sadiq Abbas").getSector().contentEquals("Universities"));		
	}
	
	@Test (expected = NullPointerException.class)
	public void testFilterPosition() {
		ss2 = ss2.filterPosition("Not A Real Position");
		assertTrue(ss2.size() == 0);
		
		//Empty string filtering
		ss4 = ss4.filterPosition("");
		assertTrue(ss4.size() == 4);
		ss4 = ss4.filterPosition(" ");
		assertTrue(ss4.size() == 0);
				
		//Exists before filtering
		assertTrue(ss1.getSalary("Sadiq Abbas").getPosition().contentEquals("Professor"));
		assertTrue(ss1.getSalary("Mary Coady").getPosition().contentEquals("Constable"));
		ss1 = ss1.filterPosition("Constable");
		//Object still exists
		assertTrue(ss1.getSalary("Mary Coady").getPosition().contentEquals("Constable"));
		//Other object no longer exists
		assertFalse(ss1.getSalary("Sadiq Abbas").getPosition().contentEquals("Professor"));	
	}
	
	@Test
	public void testPositionMean() {
		//Only professor
		double mean = ss1.positionMean("Professor");
		assertTrue(mean == ss1.getSalary("Sadiq Abbas").getSalary());
		
		//Mean changes with new professor
		ss1.add(new SalaryT(se1[2], fn1[2], ln1[2], sa1[2], b1[2], e1[2], "Professor", y1[2]));
		mean = ss1.positionMean("Professor");
		assertFalse(mean == ss1.getSalary("Sadiq Abbas").getSalary());
		
		mean = ss1.positionMean("Not A Real Position");
		assertFalse(mean == 0);
		//mean is NaN
		assertTrue(mean != mean);
	}
	
	@Test
	public void testGetters() {
		//getSectors
		String[] sectors1 = new String[] {se1[0], se1[1], se1[2], se1[3]};
		assertTrue(Arrays.equals(ss1.getSectors(), sectors1));
		String[] sectors2 = new String[] {se2[0], se2[1], se2[2], se2[3]};
		assertTrue(Arrays.equals(ss2.getSectors(), sectors2));
		
		//getEmployers
		String[] emp1 = new String[] {e1[0], e1[1], e1[2], e1[3]};
		assertTrue(Arrays.equals(ss1.getEmployers(), emp1));
		String[] emp2 = new String[] {e2[0], e2[1], e2[2], e2[3]};
		assertTrue(Arrays.equals(ss2.getEmployers(), emp2));
		
		//getPositions
		String[] pos1 = new String[] {p1[0], p1[1], p1[2], p1[3]};
		assertTrue(Arrays.equals(ss1.getPositions(), pos1));
		String[] pos2 = new String[] {p2[0], p2[1], p2[2], p2[3]};
		assertTrue(Arrays.equals(ss2.getPositions(), pos2));
		
		//Alternate constructor
		assertTrue(ss1Alt.getSectors() == null);
		assertTrue(ss1Alt.getEmployers() == null);
		assertTrue(ss1Alt.getPositions() == null);
	}
}
