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
     *
     * @param capacity
     */
    public Array(int capacity) {
        this.capacity = capacity;
        items = new int[capacity];
    }

    /**
     * Method to insert items into array
     *
     * @param item If the number of elements exceeds capacity of array, then
     *             -- capacity is doubled
     *             -- a new array is initialized with new(doubled) capacity
     *             -- items from old array is copied to new array
     *             -- old array is pointed to new array
     *             <p>
     *             new item is placed at current index, ie length
     *             index ie length is incremented
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
     *
     * @param index If the index specified is invalid, ie, out of the array range, an exception is thrown
     *              If the index specified is last index, ie index==length-1, no need to shift elems, just decrement the length
     *              if its valid index<last index
     *              --loop the array from index till last index(length-1)
     *              --copy the index+1 values to index value in a loop
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
     *
     * @param item
     * @return index
     * loop through the array from 0 index till length and match each array value against the item
     * passed
     * --If value found , return the index
     * --If value not found, return -1
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

    /**
     * Array Utility method to find the max item in array elements
     *
     * @return maxItem
     * Algo :
     * -- initialize maxItem =0
     * -- loop through array and compare the current array item to maxItem
     * -- If current array item > maxItem, assign maxItem = current array item
     */
    public static int max(Array array) {
        int maxItem = 0;
        for (int item : array.items) {
            if (item > maxItem) {
                maxItem = item;
            }
        }
        return maxItem;
    }

    /**
     * Method to find common elements in 2 arrays
     *
     * @param firstArray
     * @param secondArray
     * @return intersectArray
     * algo :
     * -- Find the max of of intersections ==> smaller array size
     * -- loop through firstArray and for each array element for firstArray, call indexOf
     * method on secondArray to find the first arrayElement exists in secondArray
     * -- If indexOf!=-1(ie firstArray item found in secondArray) insert the item to
     * intersectArray
     */
    public static Array intersect(Array firstArray, Array secondArray) {
        int maxIntersects = 0;
        if (firstArray.length < secondArray.length) {
            maxIntersects = firstArray.length;
        } else {
            maxIntersects = secondArray.length;
        }
        Array intersectArray = new Array(maxIntersects);
        for (int item : firstArray.items) {
            if (secondArray.indexOf(item) != -1) {
                intersectArray.insert(item);
            }
        }
        return intersectArray;
    }

    /**
     * Method to reverse a given array
     *
     * @param array algo: Two poimter technique
     *              -- take the first index
     *              -- take the last index
     *              -- while firstIndex<lastIndex
     *              -- swap array's elements first and last index values
     *              -- increment firstIndex, decrement lastIndex
     */
    public static void reverse(Array array) {
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            swap(array, i, j);
            i++;
            j--;
        }
    }

    /**
     * Helper method to swap 2 values in array --  to be used by reverse method
     *
     * @param array
     * @param i
     * @param j
     * @return
     */
    private static Array swap(Array array, int i, int j) {
        int temp = array.items[i];
        array.items[i] = array.items[j];
        array.items[j] = temp;
        return array;
    }

    /**
     * Method to insert a value at a aparticlur index in array
     *
     * @param array
     * @param index
     * @param newItem logic :
     *                corner case: If the length and capacity are same, we cant just insert new item
     *                -- set new capacity to oldCapacity*2
     *                -- create a new array with new capacity
     *                -- copy prev array elements to new array
     *                -- assign new array to array's object items array
     *                loop the array from last element till the index provided
     *                -- copy the last elem to position of last elem+1
     *                once the index reach breaks the loop;
     *                assign the value at index with value provided
     *                increase the length of array
     */
    public static void insertAt(Array array, int index, int newItem) {
        if (array.length == array.capacity) {
            int newCapacity = array.capacity * 2;
            int[] newArray = new int[newCapacity];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array.items[i];
            }
            array.capacity = newCapacity;
            array.items = newArray;
        }

        for (int i = array.length - 1; i >= index; i--) {
            array.items[i + 1] = array.items[i];
        }
        array.items[index] = newItem;
        array.length++;
    }
}
