package Chap02.HighArray;

// HighArray.java
// demonstrates array class with high-level interface
// to run this program: C>java HighArrayApp
////////////////////////////////////////////////////////////////
class HighArray {
    private long[] array;                 // ref to array array
    private int nElems;               // number of data items

    //-----------------------------------------------------------
    public HighArray(int max)         // constructor
    {
        array = new long[max];                 // create the array
        nElems = 0;                        // no items yet
    }

    //-----------------------------------------------------------
    public boolean find(long searchKey) {       // find specified value
        int j;
        for (j = 0; j < nElems; j++)            // for each element,
            if (array[j] == searchKey)           // found item?
                break;                       // exit loop before end
        return j != nElems;
    }  // end find()

    //-----------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        array[nElems] = value;             // insert it
        nElems++;                      // increment size
    }

    //-----------------------------------------------------------
    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++)        // look for it
            if (value == array[j])
                break;
        if (j == nElems)                  // can't find it
            return false;
        else                           // found it
        {
            for (int k = j; k < nElems; k++) // move higher ones down
                array[k] = array[k + 1];
            nElems--;                   // decrement size
            return true;
        }
    }  // end delete()

    //-----------------------------------------------------------
    public void display()             // displays array contents
    {
        for (int j = 0; j < nElems; j++)       // for each element,
            System.out.print(array[j] + " ");  // display it
        System.out.println("");
    }

    public long getMax() {
        if (array.length == 0) {
            return -1;
        }
        long max = array[0];
        for (long l : array) {
            if (l > max) {
                max = l;
            }
        }
        return max;
    }

    public long removeMax() {
        if (array.length == 0) {
            return -1;
        }
        long max = array[0];
        for (long l : array) {
            if (l > max) {
                max = l;
            }
        }
        delete(max);
        return max;
    }

    public void sort() {
        int out, in, min;
        for (out = 0; out < nElems - 1; out++) {
            min = out;
            for (in = out + 1; in < nElems; in++) {
                if (array[in] < array[min]) {
                    long temp = array[in];
                    array[in] = array[out];
                    array[out] = temp;
                }
            }
        }
        display();
    }
}  // end class HighArray

class HighArrayApp {
    public static void main(String[] args) {
        int maxSize = 100;            // array size
        HighArray arr;                // reference to array
        arr = new HighArray(maxSize); // create the array

        arr.insert(77);               // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(0);
        arr.insert(66);
        arr.insert(33);

        arr.display();                // display items

        int searchKey = 35;           // search for item
        if (arr.find(searchKey))
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);

        System.out.println("Max: " + arr.getMax());
        arr.display();                // display items again

        arr.delete(0);               // delete 3 items
        arr.delete(55);
        arr.delete(99);

        arr.display();                // display items again

        System.out.println("Max: " + arr.removeMax());
        arr.display();                // display items again

        HighArray arr2 = new HighArray(0);
        System.out.println("Max: " + arr2.getMax());
        System.out.println("--------");
        arr.sort();
    }  // end main()
}  // end class HighArrayApp
