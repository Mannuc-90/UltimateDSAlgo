package ds.array;

public class Array {
    private int[] items;
    private int capacity;
    private int length = 0;

    public Array() {
        this.capacity = 10;
        items = new int[capacity];
    }

    public Array(int capacity) {
        this.capacity = capacity;
        items = new int[capacity];
    }

    public void insert(int item) {
        if (length == capacity) {
            capacity = capacity * 2;
            int[] newItems = new int[capacity];
            for (int i = 0; i < length; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
        items[length] = item;
        length++;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= length) {
            throw new IllegalArgumentException("Index out of range!!!");
        } else if (index == length - 1) {
            length--;
        }else{
            for (int i = index; i < length-1; i++) {
                items[i] = items[i + 1];
            }
            length--;
        }
    }

    public int indexOf(int item){
        for(int i=0;i<length;i++){
            if(items[i]==item){
                return i;
            }
        }
    return -1;
    }
    public void print() {
        for (int i = 0; i < length; i++) {
            System.out.println(items[i] + " ");
        }
    }
}
