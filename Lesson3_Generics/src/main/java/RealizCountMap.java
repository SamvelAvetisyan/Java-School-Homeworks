import java.util.HashMap;
import java.util.Map;

public class RealizCountMap<T> implements CountMap<T> {
    final HashMap<T, Integer> value;

    public RealizCountMap() {
        this.value = new HashMap<T, Integer>();
    }

    @Override
    public void add(T t) {
        int count = this.getCount(t);
        count++;
        this.value.put(t, count);

    }

    @Override
    public int getCount(T t) {
        return this.value.getOrDefault(t, 0);
    }

    @Override
    public int remove(T t) {
        int newValue = this.getCount(t);
        this.value.remove(t);
        return newValue;
    }

    @Override
    public int size() {
        return this.value.size();
    }

    @Override
    public void addAll(CountMap<T> source) {
        for (Map.Entry<T, Integer> elements : source.toMap().entrySet()) {
            this.value.put(elements.getKey(), this.value.getOrDefault(elements.getKey(),
                    0) + elements.getValue());
        }
    }

    @Override
    public Map<T, Integer> toMap() {
        return this.value;
    }

    @Override
    public void toMap(Map destination) {
        destination.putAll(this.toMap());
    }
}
