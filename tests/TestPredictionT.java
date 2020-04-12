package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import src.ParseT;
import src.PredictionT;
import src.SalariesT;

public class TestPredictionT {
	private ParseT p1, p2, p3;
	private PredictionT pred1;
	
	@Before
	public void setUp() throws Exception {
		p1 = new ParseT("data/data2019.csv");
		p2 = new ParseT("data/data2018.csv");
		p3 = new ParseT("data/data2017.csv");
		ArrayList<SalariesT> salLst = new ArrayList<SalariesT>();
		salLst.add(p1.getAllSalaries());
		salLst.add(p2.getAllSalaries());
		salLst.add(p3.getAllSalaries());
		pred1 = new PredictionT(salLst);
	}

	@After
	public void tearDown() throws Exception {
		p1 = null;
		p2 = null;
		p3 = null;
		pred1 = null;
	}

	@Test
	public void testPredict() {
		double mean19 = p1.getAllSalaries().positionMean("Professor");
		double mean18 = p2.getAllSalaries().positionMean("Professor");
		ArrayList<Double> meanLst = pred1.predict("Professor");
		//Positive rate of change
		if (meanLst.get(1) > 1) {
			//Up from latest year
			assertTrue(meanLst.get(0) > mean19);
			//Rate of change should be > 1
			assertTrue(mean19 > mean18);
		}
		else {
			//Down from latest year
			assertTrue(meanLst.get(0) < mean19);
			//Rate of change should be <= 1
			assertTrue(mean19 > mean18);
		}
		
		//Insufficient data
		mean19 = p1.getAllSalaries().positionMean("1st Class Firefighter / Acting Captain");
		mean18 = p2.getAllSalaries().positionMean("1st Class Firefighter / Acting Captain");
		double mean17 = p3.getAllSalaries().positionMean("1st Class Firefighter / Acting Captain");
		//Position existed in 2019
		assertTrue(mean19 == mean19);
		//Position did not exist in 2017 or 2018
		assertFalse(mean18 == mean18);
		assertFalse(mean17 == mean17);
		meanLst.clear();
		meanLst = pred1.predict("1st Class Firefighter / Acting Captain");
		//Prediction does not exist because data is insufficient
		double predSal = meanLst.get(0);
		double predROC = meanLst.get(1);
		assertFalse(predSal == predSal);
		assertFalse(predROC == predROC);
	}
}
