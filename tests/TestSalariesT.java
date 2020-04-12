package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exceptions.*;

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
    
    private SalariesT ss1, ss2, ss3, ss4, ss5, ss6;
    private SalariesT ss1Alt, ss2Alt, ss3Alt, ss4Alt, ss5Alt, ss6Alt;
    
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
        
        
        sLst1 = new ArrayList<SalaryT>(Arrays.asList(s1));
        sLst2 = new ArrayList<SalaryT>(Arrays.asList(s2));
        sLst3 = new ArrayList<SalaryT>(Arrays.asList(s3));
        sLst4 = new ArrayList<SalaryT>(Arrays.asList(s4));
        
        ss1 = new SalariesT(sLst1, y1[0], se1, e1, p1);
        ss2 = new SalariesT(sLst2, y2[0], se2, e2, p2);
        ss3 = new SalariesT(sLst3, y3[0], se3, e3, p3);
        ss4 = new SalariesT(sLst4, y4[0], se4, e4, p4);
        //ss5 = new SalariesT();
        		
        ss1Alt = new SalariesT(sLst1, y1[0]);
        ss2Alt = new SalariesT(sLst2, y2[0]);
        ss3Alt = new SalariesT(sLst3, y3[0]);
        ss4Alt = new SalariesT(sLst4, y4[0]);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test (expected = InvalidDataLineException.class)
	public void testConstructor() {
		
        
	}
	
	@Test
	public void testSize() {
		assertTrue(ss1.size() == 4);
		assertTrue(ss2.size() == 4);
		assertTrue(ss3.size() == 4);
		assertTrue(ss4.size() == 4);
		//assertTrue(ss5.size() == 0);
	}
	
	@Test
	public void testGetSalaries() {
		assertTrue(ss1.getSalaries().equals(sLst1));
		assertTrue(ss2.getSalaries().equals(sLst2));
		assertTrue(ss3.getSalaries().equals(sLst3));
		assertTrue(ss4.getSalaries().equals(sLst4));
	}
}
