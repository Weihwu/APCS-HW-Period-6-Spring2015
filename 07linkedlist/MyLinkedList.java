import java.util.*;

public class MyLinkedList<T> implements Iterable<T>{

    private int size;
    private LNode<T> entry;
    private LNode<T> end;

    public MyLinkedList(){
    }

    public boolean add(T e){
	if(entry == null){
	    entry = new LNode<T>(e);
	    end = entry;
	}else{
	    end.setNext(new LNode<T>(e));
	    end = end.getNext();
	}

	size++;
	return true;
    }

     public void add(int index, T e){
	 LNode<T> adjunct = new LNode<T>(e);

	 if (index < 0 || size < index){
	     throw new IndexOutOfBoundsException();
	 }else if(index == size){
	     add(e);
	 }else if (index == 0){
	     adjunct.setNext(entry);
	     entry = adjunct;
	     size++;
	 }else{
	     LNode<T> place = entry;

	     for (int x = 0; x < index; x++) {
		 place = place.getNext();
	     }

	     adjunct.setNext(place.getNext());
	     place.setNext(adjunct);
	     size++;
	 }
    }

    public T remove(){
	if (entry == null){
	    throw new NoSuchElementException();
	}
	
	T holder = entry.getData();
	entry = entry.getNext();
	
	size--;
	return holder;
    }

    public T remove(int index){
	if (index < 0 || size <= index){
	    throw new IndexOutOfBoundsException();
	}else if(index == 0){
	     return remove();
	}else{	        
	     LNode<T> place = entry;
	     T holder = place.getData();
	     
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

	     size--;
	     return holder;
	}
    }

    public int indexOf(T e){
        LNode<T> place = entry;
	
        for (int x = 0; place != null; x++) {
            if (place.getData().equals(e)){
                return x;
	    }
            place = place.getNext();
        }

        return -1;
    }

    public T get(int index){
	if (index < 0 || size <= index){
	    throw new IndexOutOfBoundsException();
	}

        LNode<T> place = entry;

        for (int x = 0; x < index; x++){
	    place = place.getNext();
	}

        return place.getData();
    }

    public T set(int index, T e){
	if (index < 0 || size <= index){
	    throw new IndexOutOfBoundsException();
	}

        LNode<T> place = entry;

        for (int x = 0; x < index; x++){
            place = place.getNext();
	}
	
	T holder = place.getData();
        place.setData(e);
	return holder;
    }

    public int size(){
        LNode<T> place = entry.getNext();
        int count = 0;

        while (place != null){
            count++;
            place = place.getNext();
        }
        return count;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public String toString(){
        LNode<T> place = entry;
        String str = "[ ";

        while (place != null){
            str += place.getData() + " ";
            place = place.getNext();
        }
        str += "]";

        return str;
    }

    public static void main(String[] args){
	MyLinkedList<Integer> a = new MyLinkedList<Integer>();

	System.out.println(a.isEmpty());

	a.add(8);
	a.add(3);
	a.add(13);

	System.out.println(a.toString());

	for (int x:a){
	    System.out.println(x);
	}

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

    public String name(){
	return "wu.weihou";
    }

    public class MyLLIterator implements Iterator<T>{

	LNode<T> interest;

	public MyLLIterator(){
	    interest = entry;
	}

	public MyLLIterator(LNode<T> node){
	    interest = node;
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}

	public boolean hasNext(){
	    return interest != null;
	}

	public T next(){
	    if (hasNext()){
		T holder = interest.getData();
	        interest = interest.getNext();
		return holder;
	    }else{
		throw new NoSuchElementException();
	    }
	}
    }

    public Iterator<T> iterator(){
	return new MyLLIterator();
    }
}
