package Chap02.HighArray;

import java.util.Arrays;

// highArray.java
// demonstrates array class with high-level interface
// to run this program: C>java HighArrayApp
////////////////////////////////////////////////////////////////
class HighArray
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
   //-----------------------------------------------------------
   public HighArray(int max)         // constructor
      {
      a = new long[max];                 // create the array
      nElems = 0;                        // no items yet
      }
   //-----------------------------------------------------------
   public boolean find(long searchKey)
      {                              // find specified value
      int j;
      for(j=0; j<nElems; j++)            // for each element,
         if(a[j] == searchKey)           // found item?
            break;                       // exit loop before end
      if(j == nElems)                    // gone to end?
         return false;                   // yes, can't find it
      else
         return true;                    // no, found it
      }  // end find()
   //-----------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      a[nElems] = value;             // insert it
      nElems++;                      // increment size
      }
   //-----------------------------------------------------------
   public boolean delete(long value)
      {
      int j;
      for(j=0; j<nElems; j++)        // look for it
         if( value == a[j] )
            break;
      if(j==nElems)                  // can't find it
         return false;
      else                           // found it
         {
         for(int k=j; k<nElems; k++) // move higher ones down
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

      public long getMax() {
         if (nElems == 0) return -1;
         long max = a[0];
         for (long l : a) {
            if (l > max) {
               max = l;
            }
         }
         return max;
      }

      public long removeMax() {
          long max = getMax();
          delete(max);
          return max;
      }

       public int getLength() {
           return nElems;
       }

      public void removeDups() {
         int l = a.length;
         for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
               if (a[i] == a[j] && a[i] != Long.MAX_VALUE) {
                  a[j] = Long.MAX_VALUE;
                  l--;
               }
            }
         }
         Arrays.sort(a);
         long[] result = Arrays.copyOf(a, l);
         for (long i : result) {
            System.out.print(i + " ");
         }
      }
       //-----------------------------------------------------------
   }  // end class HighArray
////////////////////////////////////////////////////////////////
class HighArrayApp
   {
   public static void main(String[] args)
      {
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
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);

      arr.display();                // display items
         System.out.println("Max is: " + arr.getMax());

      int searchKey = 35;           // search for item
      if( arr.find(searchKey) )
         System.out.println("Found " + searchKey);
      else
         System.out.println("Can't find " + searchKey);

      arr.delete(00);               // delete 3 items
      arr.delete(55);
      arr.delete(99);

      arr.display();                // display items again
          System.out.println("Max is: " + arr.getMax());
          System.out.println("Max " + arr.getMax() + " has been removed!");
          arr.removeMax();
          arr.display();
          System.out.println("Max is: " + arr.getMax());

          System.out.println("Sorting...");

          int length = arr.getLength();
          long[] newArray = new long[length];

          for (int i = 0; i < length; i++) {
              newArray[i] = arr.removeMax();
              System.out.print(newArray[i] + " ");
          }
         System.out.println();
          for (int i = newArray.length - 1; i >= 0; i--) {
              System.out.print(newArray[i] + " ");
          }
         System.out.println();
         System.out.println("New array: ");
         arr = new HighArray(12);
         arr.insert(3);
         arr.insert(11);
         arr.insert(3);
         arr.insert(8);
         arr.insert(11);
         arr.insert(99);
         arr.insert(33);
         arr.insert(11);
         arr.insert(99);
         arr.insert(25);
         arr.insert(46);
         arr.insert(99);
         arr.display();
         System.out.println("Removing dups....");
         arr.removeDups();

      }  // end main()
   }  // end class HighArrayApp
