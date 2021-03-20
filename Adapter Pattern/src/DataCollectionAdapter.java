import java.util.ArrayList;
import java.util.Iterator;

public class DataCollectionAdapter<T> implements DataCollection<T> {
    final int SIZE = 3;
    private int length;
    private int capacity;
    private ArrayList<T> data;

    public DataCollectionAdapter(){
        data = new ArrayList<T>(SIZE);
        length = 0;
        capacity = SIZE;
    }
    @Override
    public boolean put(T t) {
        if (length >= capacity) {
            boolean b = resizeArray(); // 재할당
            if (b) {
                data.add(t);
                length++;
            }
            return b;
        }
        else {
            data.add(t);
            length++;
        }
        return true;
    }

    @Override
    public T elemAt(int index) {
        if (index >= 0 && index < length) {
            return (T) data.get(index);
        }
        return null;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public Iterator createIterator() {
        Iterator<T> itr = data.iterator();
        return itr;
    }

    private boolean resizeArray() {
        ArrayList<T> newData = new ArrayList<T>(capacity + SIZE);
        if (newData == null) {
            return false;
        }
        for (int i = 0; i < capacity; i++) {
            newData.add(data.get(i));
        }
        data = newData;
        capacity += SIZE;
        return true;
    }
}
