package Chap02.OrderedArray;

import java.util.Arrays;

// orderedArray.java
// demonstrates ordered array class
// to run this program: C>java OrderedApp
////////////////////////////////////////////////////////////////
class OrdArray
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
   //-----------------------------------------------------------
   public OrdArray(int max)          // constructor
      {
      a = new long[max];             // create array
      nElems = 0;
      }
   //-----------------------------------------------------------
   public int size()
      { return nElems; }
   //-----------------------------------------------------------
   public int find(long searchKey)
      {
      int lowerBound = 0;
      int upperBound = nElems-1;
      int curIn;

      while(true)
         {
         curIn = (lowerBound + upperBound ) / 2;
         if(a[curIn]==searchKey)
            return curIn;              // found it
         else if(lowerBound > upperBound)
            return nElems;             // can't find it
         else                          // divide range
            {
            if(a[curIn] < searchKey)
               lowerBound = curIn + 1; // it's in upper half
            else
               upperBound = curIn - 1; // it's in lower half
            }  // end else divide range
         }  // end while
      }  // end find()
   //-----------------------------------------------------------
   public void insert(long value)    // put element into array
   {
//      for(j=0; j<nElems; j++)        // find where it goes
//         if(a[j] > value)            // (linear search)
//            break;
       int j = binaryIndexSearch(value);
      for(int k=nElems; k>j; k--)    // move bigger ones up
         a[k] = a[k-1];
      a[j] = value;                  // insert it
      nElems++;                      // increment size
   }  // end insert()

       private int binaryIndexSearch(long value) {
           if (nElems == 0)
               return 0;
           int lowerBound = 0;
           int upperBound = nElems - 1;
           int index = 0;
           while (true) {
               index = (upperBound + lowerBound) / 2;
               if (a[index] == value) {
                   return index;
               } else if (a[index] < value) {
                   lowerBound = index + 1;
                   if (lowerBound > upperBound)
                       return index + 1;
               } else {
                   upperBound = index - 1;
                   if (lowerBound > upperBound)
                       return index;
               }
           }
       }
   //-----------------------------------------------------------
   public boolean delete(long value)
      {
      int j = find(value);
      if(j==nElems)                  // can't find it
         return false;
      else                           // found it
         {
         for(int k=j; k<nElems; k++) // move bigger ones down
            a[k] = a[k+1];
         nElems--;                   // decrement size
         return true;
         }
      }  // end delete()
   //-----------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }

       public static int[] merge(int[] x, int[] y) {
           int[] result = new int[x.length + y.length];

           int i = 0, j = 0, k = 0;

           while (i < x.length && j < y.length) {
               if (x[i] < y[j]) {
                   result[k++] = x[i++];
               } else {
                   result[k++] = y[j++];
               }
           }

           while (i < x.length) {
               result[k++] = x[i++];
           }

           while (j < y.length) {
               result[k++] = y[j++];
           }

           return result;
       }

// maybe the best approach!!
//       public static int[] merge(int[] a, int[] b) {
//           int[] answer = new int[a.length + b.length]
//           int i = a.length - 1, j = b.length - 1, k = answer.length;
//
//           while (k > 0)
//               answer[--k] =
//                       (j < 0 || (i >= 0 && a[i] >= b[j])) ? a[i--] : b[j--];
//       return answer;
//       }
   //-----------------------------------------------------------
   }  // end class OrdArray
////////////////////////////////////////////////////////////////
class OrderedApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;             // array size
      OrdArray arr;                  // reference to array
      arr = new OrdArray(maxSize);   // create the array

      arr.insert(77);                // insert 10 items
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(0);
      arr.insert(66);
      arr.insert(33);

          arr.display();                 // display items

      int searchKey = 55;            // search for item
      if( arr.find(searchKey) != arr.size() )
         System.out.println("Found " + searchKey);
      else
         System.out.println("Can't find " + searchKey);

      arr.delete(0);                // delete 3 items
      arr.delete(55);
      arr.delete(99);
          System.out.println("Deleting...");
      arr.display();                 // display items again

          System.out.println("------");
          int[] x = new int[6];
          int[] y = new int[4];

//          for (int i = 0; i < 10; i++) {
//              x[i] = (int) (Math.random() * 100);
//          }
//
//          for (int i = 0; i < 15; i++) {
//              y[i] = (int) (Math.random() * 100);
//          }
            x[0] = 1;
            x[1] = 17;
            x[2] = 25;
            x[3] = 36;
            x[4] = 50;
            x[5] = 90;

          y[0] = 3;
          y[1] = 7;
          y[2] = 9;
          y[3] = 31;

          System.out.println(Arrays.toString(x));
          System.out.println(Arrays.toString(y));

          System.out.println("Merging....");
          int[] mergedArray = OrdArray.merge(x, y);

          System.out.println(Arrays.toString(mergedArray));

      }  // end main()
   }  // end class OrderedApp
