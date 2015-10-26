package Chap03.InsertSort;

import java.util.Arrays;

// insertSort.java
// demonstrates insertion sort
// to run this program: C>java InsertSortApp
//--------------------------------------------------------------
class ArrayIns {
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items

    //--------------------------------------------------------------
    public ArrayIns(int max)          // constructor
    {
        a = new long[max];                 // create the array
        nElems = 0;                        // no items yet
    }

    //--------------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        a[nElems] = value;             // insert it
        nElems++;                      // increment size
    }

    //--------------------------------------------------------------
    public void display()             // displays array contents
    {
        for (int j = 0; j < nElems; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }

    //--------------------------------------------------------------
    public void insertionSort() {
        int in, out;

        for (out = 1; out < nElems; out++)     // out is dividing line
        {
            long temp = a[out];            // remove marked item
            in = out;                      // start shifts at out
            while (in > 0 && a[in - 1] >= temp) // until one is smaller,
            {
                if (temp == a[in - 1]) temp = -1; // each duplicate = -1
                a[in] = a[in - 1];            // shift item to right
                --in;                       // go left one position
            }
            a[in] = temp;                  // insert marked item
        }  // end for


//        for (int i = 1; i < nElems; i++) {
//            long temp = a[i];
//            int j = i;
//            while (j > 0 && temp <= a[j-1]) {
//                a[j] = a[j - 1];
//                j--;
//            }
//            a[j] = temp;
//        }
    }  // end insertionSort()

    public long median() {
        long median;
        int middle = nElems / 2;
        if (nElems % 2 == 0) {
            median = (a[middle] + a[middle - 1]) / 2;
        } else {
            median = a[middle];
        }
        return median;
    }

    public void noDups() {
        int j = 0;

        for (int i = 1; i < nElems; i++) {
            if (a[i] != a[i - 1]) {
                a[++j] = a[i];
            }
        }

        for (int i = 0; i <= j; i++) {
            System.out.print(a[i] + " ");
        }
    }
//--------------------------------------------------------------
}  // end class ArrayIns

////////////////////////////////////////////////////////////////
class InsertSortApp {
    public static void main(String[] args) {
        int maxSize = 100;            // array size
        ArrayIns arr;                 // reference to array
        arr = new ArrayIns(maxSize);  // create the array

        arr.insert(7);               // insert 10 items
        arr.insert(9);
        arr.insert(2);
        arr.insert(5);
        arr.insert(2);
        arr.insert(8);
        arr.insert(7);
        arr.insert(0);
        arr.insert(6);
        arr.insert(7);

        arr.display();                // display items
        System.out.println("Sorting...");
        arr.insertionSort();          // insertion-sort them

        arr.display();                // display them again

        System.out.println("median : " + arr.median());

        System.out.println("Processing no duplicates...");
        arr.noDups();

    }  // end main()
}  // end class InsertSortApp
