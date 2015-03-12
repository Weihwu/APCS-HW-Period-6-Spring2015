public class LinkedList{

    private LNode entry;

    public LinkedList(){
        entry = new LNode();
    }

    public Object get(int index){
	if (index < 0){
	    throw new IndexOutOfBoundsException();
	}

        LNode place = entry.getNext();

        for (int x = 0; x < index; x++){
	    place = place.getNext();
	    if (place == null){
		throw new IndexOutOfBoundsException();
	    }
	}

        return place.getData();
    }

    public void add(int e){
        LNode place = entry;

        while (place.getNext() != null){
            place = place.getNext();
	}

        place.setNext(new LNode(e));
    }

     public void add(int index, int value){
	 if (index < 0){
	     throw new IndexOutOfBoundsException();
	 }

        LNode place = entry;

        for (int x = 0; x < index; x++) {
            place = place.getNext();
            if (place == null){
                throw new IndexOutOfBoundsException();
	    }
        }

        LNode a = new LNode(value);

        a.setNext(place.getNext());
        place.setNext(a);
    }

    public void remove(){
	remove(0);
    }

    public void remove(int index){
	 if (index < 0){
	     throw new IndexOutOfBoundsException();
	 }

        LNode place = entry;

        for (int x = 0; x < index; x++){
            place = place.getNext();
            if (place == null){
		throw new IndexOutOfBoundsException();
	    }
        }

        place.setNext(place.getNext().getNext());
    }

    public int indexOf(int value){
        LNode place = entry.getNext();
	
        for (int x = 0; place != null; x++) {
            if (place.getData().equals(value)){
                return x;
	    }
            place = place.getNext();
        }

        return -1;
    }

    public void set(int index, int e){
	if (index < 0){
	    throw new IndexOutOfBoundsException();
	}

        LNode place = entry;

        for (int x = 0; x < index; x++){
            place = place.getNext();
	    if (place == null){
		throw new IndexOutOfBoundsException();
	    }
	}

        place.setData(e);
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
        return entry.getNext() == null;
    }

    public String toString(){
        LNode place = entry.getNext();
        String str = "[ ";

        while (place != null){
            str += place.getData() + " ";
            place = place.getNext();
        }
        str += "]";

        return str;
    }

    public static void main(String[] args){
	LinkedList a = new LinkedList();

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
	
	a.remove(0);
	a.remove(0);

	System.out.println(a.isEmpty());
    }
}