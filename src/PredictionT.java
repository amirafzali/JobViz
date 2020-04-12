package src;

import java.util.ArrayList;

/**
 * A class for predicting the future salary of a position
 *
 */
public class PredictionT {
	private final ArrayList<SalariesT> s;

	/**
	 * Constructor for PredictionT
	 * 
	 * @param salaries A list of SalariesT that represent a unique year
	 */
	public PredictionT(ArrayList<SalariesT> salaries) {
		this.s = salaries;
	}

	/**
	 * Predicts the next year salary and the next year rate of change for salary for
	 * a given position
	 * 
	 * @param position The position for which calculations are being done
	 * @return ArrayList<Double> A list including the salary and the rate of change
	 *         of the salary
	 */
	public ArrayList<Double> predict(String position) {
		ArrayList<Double> trend = this.changePerYear(position);
		double rateOfChange = ((trend.get(trend.size() - 1) - trend.get(trend.size() - 2))
				+ trend.get(trend.size() - 1));
		double salary = this.s.get(this.s.size() - 1).positionMean(position) * rateOfChange;
		ArrayList<Double> prediction = new ArrayList<>();
		prediction.add(salary);
		prediction.add(rateOfChange);
		return prediction;
	}

	/**
	 * Calculates the rate of change in salary per year
	 * 
	 * @param position The position for which calculations are being done
	 * @return ArrayList<Double> A list of the rate of change in salary for the
	 *         position
	 */
	private ArrayList<Double> changePerYear(String position) {
		ArrayList<Double> mean = new ArrayList<>();
		ArrayList<Double> change = new ArrayList<>();
		for (SalariesT e : this.s) {
			mean.add(e.positionMean(position));
		}
		if (mean.size() >= 2) {
			for (int i = 1; i < mean.size(); i++) {
				change.add(mean.get(i) / mean.get(i - 1));
			}
		}
		return change;
	}
}
