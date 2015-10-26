package Chap03.BubbleSort;

// bubbleSort.java
// demonstrates bubble sort
// to run this program: C>java BubbleSortApp
////////////////////////////////////////////////////////////////
class ArrayBub {
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items

    //--------------------------------------------------------------
    public ArrayBub(int max)          // constructor
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

    public void oddEventSort() {
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int j = 0; j < nElems - 1; j = j + 2) {
                if (a[j] > a[j + 1]) {
                    swap(j, j + 1);
                    sorted = false;
                }
            }

            for (int j = 1; j < nElems - 1; j = j + 2) {
                if (a[j] > a[j + 1]) {
                    swap(j, j + 1);
                    sorted = false;
                }
            }
        }
    }

    public void bubbleSort() {
// cocktail sort
        for (int i = nElems - 1, k = 0; i > k; i--, k++) {
            int j = 0;
            while (j < i) {
                if (a[j] > a[j + 1]) {
                    swap(j, j + 1);
                }
                j++;
            }

            for (int m = --j; m > k; m--) {
                if (a[m] < a[m - 1]) {
                    swap(m, m - 1);
                }
            }
        }
// max to the end
//        for (int i = nElems - 1; i > 1; i--) {
//            for (int j = 0; j < i; j++) {
//                if (a[j] > a[j + 1]) {
//                    swap(j, j+1);
//                }
//            }
//        }
// min to start
//        for (int i = 0; i < nElems; i++) {
//            for (int j = i + 1; j < nElems; j++) {
//                if (a[i] > a[j]) {
//                    swap(i, j);
//                }
//            }
//        }
    }  // end bubbleSort()

    //--------------------------------------------------------------
    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
//--------------------------------------------------------------
}  // end class ArrayBub

////////////////////////////////////////////////////////////////
class BubbleSortApp {
    public static void main(String[] args) {
        int maxSize = 100;            // array size
        ArrayBub arr;                 // reference to array
        arr = new ArrayBub(maxSize);  // create the array

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

//        arr.bubbleSort();             // bubble sort them
        arr.oddEventSort();             // odd event sort

        arr.display();                // display them again
    }  // end main()
}  // end class BubbleSortApp
////////////////////////////////////////////////////////////////
