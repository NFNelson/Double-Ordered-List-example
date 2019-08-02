package nelsonorderdlist;
//Create a double linked version of orderdlistadt interface.

/*
needs:
doubleNode-from last assignment
doublelist
iterator
doubleorderdlist



*/
import java.util.Iterator;
public class DoubleOrderedList<DubList> implements ListADT<DubList>
{
   protected final int startingSize = 100;
   private final int Missing = -1;
   protected int backOfList;
   protected DubList[] doubleList;
   //constructur
   public DoubleOrderedList()
   {
      backOfList = 0;
      doubleList = (DubList[])(new Object[startingSize]);
   }
   //constructer
   public DoubleOrderedList (int initialCapacity)
   {
      backOfList = 0;
      doubleList = (DubList[])(new Object[initialCapacity]);
   }
    //inadt
   public void add (DubList element)
   {
            backOfList++;
       }
//eceptions from given code.
   public DubList removeFirst() throws EmptyCollectionException
   {
      if (isEmpty())
         throw new EmptyCollectionException ("doubleList");
      DubList result = null;
      doubleList[backOfList] = null;
      return result;
   }
   
   
   
   public DubList removeLast () throws EmptyCollectionException                   
   {
      DubList result = null;

      if (isEmpty())
         throw new EmptyCollectionException ("doubleList");

      backOfList--;
      result = doubleList[backOfList];
      doubleList[backOfList] = null;
    

      return result;
   }
  
   public DubList remove (DubList element)
   {
      DubList result = null;
      backOfList--;
      return result;
   }
   public DubList first() throws EmptyCollectionException
   {
      if (isEmpty())
         throw new EmptyCollectionException ("doubleList");

      return doubleList[0];
   }
    public DubList last() throws EmptyCollectionException
   {
      if (isEmpty())
         throw new EmptyCollectionException ("doubleList");

      return doubleList[backOfList-1];
   }
    private int find (DubList pointer)
   {
      int scan = 0, result = Missing;
      boolean found = false;
        if (found)
         result = scan;

      return result;
   }
    
    
   public boolean contains (DubList pointer)
   {
      return (find(pointer) != Missing);
   }
   
   public boolean isEmpty()
   {
      return (backOfList == 0);
   }
   public int size()
   {
      return backOfList;
   }
   public Iterator<DubList> iterator()
   {
      return new ArrayIterator<DubList> (doubleList, backOfList);
   }
   @Override
   public String toString()
   {
      String result = "";

      for (int scan=0; scan < backOfList; scan++)
         result = result + doubleList[scan].toString() + "\n";

      return result;
   }
   protected void increaseSize()
   {
      DubList[] larger = (DubList[])(new Object[doubleList.length*2]);

      for (int scan=0; scan < doubleList.length; scan++)
         larger[scan] = doubleList[scan];

      doubleList = larger;
   }

}
class ArrayOrderedList<DubList> extends DoubleOrderedList<DubList> implements OrderedListADT<DubList>
{
public ArrayOrderedList()
   {
      super();
   }
   public ArrayOrderedList (int initialCapacity)
   {
      super(initialCapacity);
   }
   public void add (DubList element)
   {
      if (size() == doubleList.length)
         increaseSize();
         Comparable<DubList> newTempSize = (Comparable<DubList>)element;
         int scan = 0;
         while (scan < backOfList && newTempSize.compareTo(doubleList[scan]) > 0)
         scan++;
         for (int scan2=backOfList; scan2 > scan; scan2--)
         doubleList[scan2] = doubleList[scan2-1];
    
      doubleList[scan] = element;
      backOfList++;
    
   }
}

class ArrayIterator<DubList> implements Iterator
{
   private int count;    //Number of things in the list
   private int currunt; // this shows the posistion of the list
   private DubList[] items;
   public ArrayIterator (DubList[] collection, int size)
   {
      items = collection;
      count = size;
      currunt = 0;
   }
   //Checks to see if empty
   @Override
   public boolean hasNext()
   {
      return (currunt < count);
   }
   //gets next
   @Override
   public DubList next()
   {
      if (! hasNext())
    
    
         currunt++;
      return items[currunt - 1];

   }
//exception handeld by given code
   @Override
   public void remove() throws UnsupportedOperationException
   {
      throw new UnsupportedOperationException();
   }
}

