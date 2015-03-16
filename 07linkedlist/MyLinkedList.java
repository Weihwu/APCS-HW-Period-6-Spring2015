import java.util.*;

public class MyLinkedList{

    private int size;
    private LNode entry;
    private LNode end;

    public MyLinkedList(){
    }

    public boolean add(int e){
	if(entry == null){
	    entry = new LNode(e);
	    end = entry;
	}else{
	    end.setNext(new LNode(e));
	    end = end.getNext();
	}

	size++;
	return true;
    }

     public boolean add(int index, int e){
	 LNode adjunct = new LNode(e);

	 if (index < 0 || size < index){
	     throw new IndexOutOfBoundsException();
	 }else if(index == size){
	     return add(e);
	 }else if (index == 0){
	     adjunct.setNext(entry);
	     entry = adjunct;
	 }else{
	     LNode place = entry;

	     for (int x = 0; x < index; x++) {
		 place = place.getNext();
	     }

	     adjunct.setNext(place.getNext());
	     place.setNext(adjunct);
	 }
	 
	 size++;
	 return true;
    }

    public Object remove(){
	if (entry == null){
	    throw new NoSuchElementException();
	}
	
	Object holder = entry.getData();
	entry = entry.getNext();
	
	size--;
	return holder;
    }

    public Object remove(int index){
	Object holder = new Object();

	 if (index < 0 || size <= index){
	     throw new IndexOutOfBoundsException();
	 }else if(index == 0){
	     return remove();
	 }else{	        
	     LNode place = entry;

	     for (int x = 1; x < index; x++){
		 place = place.getNext();
		 holder = place.getNext().getData();
	     }

	     if(place.getNext() == end){
		 place.setNext(null);
		 end = place;
	     }else{
		 place.setNext(place.getNext().getNext());
	     }
	 }
	 
	 size--;
	 return holder;
    }

    public int indexOf(int e){
        LNode place = entry;
	
        for (int x = 0; place != null; x++) {
            if (place.getData().equals(e)){
                return x;
	    }
            place = place.getNext();
        }

        return -1;
    }

    public Object get(int index){
	if (index < 0 || size <= index){
	    throw new IndexOutOfBoundsException();
	}

        LNode place = entry;

        for (int x = 0; x < index; x++){
	    place = place.getNext();
	}

        return place.getData();
    }

    public Object set(int index, int e){
	if (index < 0 || size <= index){
	    throw new IndexOutOfBoundsException();
	}

        LNode place = entry;

        for (int x = 0; x < index; x++){
            place = place.getNext();
	}
	
	Object holder = place.getData();
        place.setData(e);
	return holder;
    }

    public int size(){
        LNode place = entry.getNext();
        int count = 0;

        while (place != null){
            count++;
            place = place.getNext();
        }
        return count;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public String toString(){
        LNode place = entry;
        String str = "[ ";

        while (place != null){
            str += place.getData() + " ";
            place = place.getNext();
        }
        str += "]";

        return str;
    }

    public static void main(String[] args){
	MyLinkedList a = new MyLinkedList();

	System.out.println(a.isEmpty());

	a.add(8);
	a.add(3);
	a.add(13);

	System.out.println(a.toString());

	System.out.println(a.get(1));
	
	a.remove(2);

	System.out.println(a.toString());

	System.out.println(a.indexOf(8));

	System.out.println(a.size());

	a.set(1, 9);

	System.out.println(a.toString());

	System.out.println(a.isEmpty());
	
	System.out.println(a.remove(0));
	System.out.println(a.remove(0));

	System.out.println(a.isEmpty());

	System.out.println(a.indexOf(0));
    }
}