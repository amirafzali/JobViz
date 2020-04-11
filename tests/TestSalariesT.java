package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import src.SalaryT;
import src.SalariesT;

public class TestSalariesT {
	private SalaryT s1, s2, s3, s4, s5, s6;

    private String[] fn1, fn2, fn3, fn4;
    private String[] ln1, ln2, ln3, ln4;
    private String[] p1, p2, p3, p4;
    private String[] e1, e2, e3, e4;
    private String[] se1, se2, se3, se4;
    private double sa1, sa2, sa3, sa4;
    private double b1, b2, b3, b4;
    private int y1, y2, y3, y4;
    
    private SalariesT ss1, ss2, ss3, ss4;
    
	private ArrayList<SalaryT> sLst1, sLst2, sLst3, sLst4;
	private String[] seLst, seLst2, seLst3, seLst4;
	private String[] eLst1, eLst2, eLst3, eLst4;
	private String[] pLst1, pLst2, pLst3, pLst4;
	
	@Before
	public void setUp() throws Exception {
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
    	
    	sa1 = 111442.39; 
    	sa2 = 10; 
    	sa3 = 99999.812479;
    	sa4 = 0.00;
    	
    	b1 = 68.16;	
    	b2 = 10.0; 
    	b3 = 423.014125;
    	b4 = 0.00;
    	
    	y1 = 2019; 
    	y2 = 10;
    	y3 = 14214;
    	y4 = 0;
    	
        //s1 = new SalaryT(se1, fn1, ln1, sa1, b1, e1, p1, y1);
        //s2 = new SalaryT(se2, fn2, ln2, sa2, b2, e2, p2, y2);
        //s3 = new SalaryT(se3, fn3, ln3, sa3, b3, e3, p3, y3);
        //s4 = new SalaryT(se4, fn4, ln4, sa4, b4, e4, p4, y4);
        
        sLst1 = new ArrayList<SalaryT>();
        sLst2 = new ArrayList<SalaryT>();
        sLst3 = new ArrayList<SalaryT>();
        sLst4 = new ArrayList<SalaryT>();
        
        
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
