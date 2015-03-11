public class LinkedList {

    private LNode entry;

    public LinkedList() {
        entry = new LNode();
    }


    public Object get(int index) {
        LNode place = entry.getNext();

        for (int x = 0; x < index; x++){
            if (place != null)
                place = place.getNext();
	}

        return place.getData();
    }

    public void add(Object e) {
        LNode place = entry;

        while (place.getNext() != null){
            place = place.getNext();
	}

        place.setNext(new LNode(e));
    }

    public void remove(int index) {
        LNode place = entry;

        for (int x = 0; x < index; x++){
            place = place.getNext();
            if (place == null){
                return;
	    }
        }

        place.setNext(place.getNext().getNext());
    }

    public int size() {
        LNode place = entry.getNext();
        int count = 0;

        while (place != null){
            count++;
            place = place.getNext();
        }
        return count;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public String toString() {
        LNode place = entry.getNext();
        String str = "[ ";

        while (place != null){
            str += place.getData() + " ";
            place = place.getNext();
        }
        str += "]";

        return str;
    }

    public void set(int index, Object e) {
        LNode place = entry.getNext();

        for (int x = 0; x < index; x++){
            place = place.getNext();
	}

        place.setData(e);
    }
}