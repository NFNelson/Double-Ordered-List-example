package nelsonorderdlist;


/**
 * DoubleOrderedList testing area.
 * 
 * @author (your name), Acuna
 * @version (version)
 */
public class Driver {
    public static void main(String [] args) {
        DoubleOrderedList<Integer> list = new DoubleOrderedList<>();
        
        //RA: These are _extremely_ simple tests - do not use them when doing
        //    your writeup.
        
        list.add(23);
        list.add(24);	
        list.add(16);
        list.add(3);	
        list.add(7);
        list.add(17);	
        list.add(9);	
        list.add(13);	
        list.add(14);	
        list.add(1);

        System.out.println(list);
        
        list.remove(7);
        list.removeFirst();
        list.remove(17);
        list.removeLast();
        list.remove(14);
        list.removeLast();
        
        System.out.println(list);
        
      
    }
}
