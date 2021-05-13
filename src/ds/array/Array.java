package ds.array;

/**
 * Customized Resizable Array class implementation and helper methods
 */
public class Array {
    //array holding the elements
    private int[] items;

    //capacity of the Array.
    //Initialized in constructor and grown twice if arrays exceeds its capcity.
    private int capacity;

    //number of elements in array
    private int length = 0;

    /**
     * Defalt constructr initializing capcity to 10
     */
    public Array() {
        this.capacity = 10;
        items = new int[capacity];
    }

    /**
     * Parameterized constructor taking user defined capcity
     * @param capacity
     */
    public Array(int capacity) {
        this.capacity = capacity;
        items = new int[capacity];
    }

    /**
     * Method to insert items into array
     * @param item
     * If the number of elements exceeds capacity of array, then
     *      -- capacity is doubled
     *      -- a new array is initialized with new(doubled) capacity
     *      -- items from old array is copied to new array
     *      -- old array is pointed to new array
     *
     * new item is placed at current index, ie length
     * index ie length is incremented
     */
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

    /**
     * Method to remove an element on specified index
     * @param index
     * If the index specified is invalid, ie, out of the array range, an exception is thrown
     * If the index specified is last index, ie index==length-1, no need to shift elems, just decrement the length
     * if its valid index<last index
     *      --loop the array from index till last index(length-1)
     *      --copy the index+1 values to index value in a loop
     */
    public void removeAt(int index) {
        if (index < 0 || index >= length) {
            throw new IllegalArgumentException("Index out of range!!!");
        } else if (index == length - 1) {
            length--;
        } else {
            for (int i = index; i < length - 1; i++) {
                items[i] = items[i + 1];
            }
            length--;
        }
    }

    /**
     * Method to find the index of a value in array
     * @param item
     * @return index
     * loop through the array from 0 index till length and match each array value against the item
     * passed
     *      --If value found , return the index
     *      --If value not found, return -1
     */
    public int indexOf(int item) {
        for (int i = 0; i < length; i++) {
            if (items[i] == item) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Method to print the values inside array
     * Loop through the array starting from 0 index till length and print each value
     */
    public void print() {
        for (int i = 0; i < length; i++) {
            System.out.println(items[i] + " ");
        }
    }


}
