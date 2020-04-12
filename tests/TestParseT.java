package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import src.ParseT;
import src.SalariesT;

public class TestParseT {
	private ParseT pt1;
	@Before
	public void setUp() throws Exception {
		pt1 = new ParseT("data/data2019.csv");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test (expected = Exception.class)
	public void testInvalidFile() throws Exception {
		pt1 = new ParseT("data/badFile.csv");
	}
	
	@Test
	public void testGetAllSalaries() {
		SalariesT sals = pt1.getAllSalaries();
		assertTrue(sals.size() > 0);
		//arbitrarily picked from data2019.csv
		assertTrue(sals.getSalary("Janice Emmerson").getSalary() == 106491.21);
		assertTrue(sals.filterSalary(750000, 1000000).getSalary("Kevin Smith").getEmployer().contentEquals("University Health Network"));
		assertTrue(sals.filterSalary(750000, 1000000).size() == 10);
	}
	
	@Test
	public void testLocateDataSets() {
		//Fails if any dataset files are not available
		try {
			pt1 = new ParseT("data/data2019.csv");
			pt1 = new ParseT("data/data2018.csv");
			pt1 = new ParseT("data/data2017.csv");
		} catch(Exception e) {
			fail("Data files not found");
		}
	}
}
