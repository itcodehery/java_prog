import java.util.ArrayList;
import java.util.List;

class DataSet<T extends Number> {
    private List<T> data;

    public DataSet() {
        this.data = new ArrayList<>();
    }

    public void add(T value) {
        data.add(value);
    }

    public List<T> getData() {
        return data;
    }

    public Number calculate(Analysis<T> analysis) {
        return analysis.perform(data);
    }
}
