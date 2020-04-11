package src;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PredictionT {
    private ArrayList<SalariesT> s;

    public PredictionT(ArrayList<SalariesT> salaries) {
        this.s = salaries;
    }

    private ArrayList<Double> changePerYear(String position) {
        ArrayList<Double> median = new ArrayList<>();
        ArrayList<Double> change = new ArrayList<>();
        for (SalariesT e: this.s) {
            median.add(e.positionMedian(position));
        }
        if (median.size() >= 2) {
            for (int i = 1; i < median.size(); i++) {
                change.add(median.get(i)/median.get(i - 1));
            }
        }
        return change;
    }

    public ArrayList<Double> predict(String position) {
        ArrayList<Double> trend = this.changePerYear(position);
        Double rateOfChange = ((trend.get(trend.size() - 1) - trend.get(trend.size() - 2)) + trend.get(trend.size() - 1));
        Double salary = this.s.get(this.s.size() - 1).positionMedian(position) + (rateOfChange * this.s.get(this.s.size() - 1).positionMedian(position));
        ArrayList<Double> prediction = new ArrayList<>();
        prediction.add(salary);
        rateOfChange = rateOfChange * 100;
        prediction.add(rateOfChange);
        return prediction;
    }
}
