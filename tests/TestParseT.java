package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import src.ParseT;

public class TestParseT {
	private ParseT pt1, pt2, pt3;
	@Before
	public void setUp() throws Exception {
		pt1 = new ParseT("data/data2019.csv");
		pt2 = new ParseT("");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test (expected = Exception.class)
	public void testInvalidFile() throws Exception {
		ParseT invParse = new ParseT("data/badFile.csv");
	}
}
