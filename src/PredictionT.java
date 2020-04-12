package src;

import java.util.ArrayList;

public class PredictionT {
    private final ArrayList<SalariesT> s;

	public PredictionT(ArrayList<SalariesT> salaries) {
		this.s = salaries;
	}

	public ArrayList<Double> predict(String position) {
		ArrayList<Double> trend = this.changePerYear(position);
		double rateOfChange = ((trend.get(trend.size() - 1) - trend.get(trend.size() - 2)) + trend.get(trend.size() - 1));
		double salary = this.s.get(this.s.size() - 1).positionMean(position) * rateOfChange;
		ArrayList<Double> prediction = new ArrayList<>();
		prediction.add(salary);
		prediction.add(rateOfChange);
		return prediction;
	}

	private ArrayList<Double> changePerYear(String position) {
		ArrayList<Double> median = new ArrayList<>();
		ArrayList<Double> change = new ArrayList<>();
		for (SalariesT e : this.s) {
			median.add(e.positionMean(position));
		}
		if (median.size() >= 2) {
			for (int i = 1; i < median.size(); i++) {
				change.add(median.get(i) / median.get(i - 1));
			}
		}
		return change;
	}
}
