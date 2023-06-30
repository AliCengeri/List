import java.util.Arrays;

public class MyList<T> {
    private T[] arr;
    private int capacity = 10;
    private int size;

    public MyList() {
        this.capacity = 10;
        this.size = 0;
        this.arr = (T[]) new Object[capacity];
    }

    public MyList(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = (T[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(T data) {
        if (size >= capacity) {
            incCapacity();
        }
        arr[size++] = data;
    }

    public void incCapacity() {
        int newCapacity = capacity * 2;
        arr = Arrays.copyOf(arr, newCapacity);
    }

    public T get(int index) {
        return arr[index];
    }

    public void remove(int index) {
        if (index >= arr.length){
            return;
        }
        arr[index] = null;
    }

    public void set(int index, T data) {
        arr[index] = data;
    }

    public String toString() {
        return Arrays.toString(arr);
    }

    public int indexOf(T data) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == data) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        for (int i = arr.length-1; i > -1; i--) {
            if (arr[i] == data) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                return true;
            }
        }
        return false;
    }

    public T[] toArray() {
        T[] newArr = Arrays.copyOf(arr,size);
        return newArr;
    }

    public void clear() {
        Arrays.fill(arr, null);
        size = 0;
    }

    public MyList<T> sublist(int start, int finish){
        if (start < 0 || start > arr.length || finish < 0 || finish > arr.length){
            return null;
        }
        MyList<T> newArr = new MyList<>(finish - start);
        for (int i = start; i < finish; i++) {
            newArr.add(arr[i]);
        }
        return newArr;
    }

    public boolean contains(T data) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == data) {
                return true;
            }
        }
        return false;
    }
}
