import java.util.*;

public class MyHeap{

    private ArrayList<Integer> heap = new ArrayList<Integer>();
    private boolean isMax;

    public MyHeap(){
	isMax = true;
    }

    public MyHeap(boolean isMax){
	this();
	this.isMax = isMax;
    }

    public String toString(){
	return heap.toString();
    }

    //For Remove
    public int remove(){
	int root = heap.get(0);

	if (heap.size() == 0){
	    removeMax();
	}else{
	    removeMin();
	}

	return root;
    }

    private void removeMax(){
	int place = 0;
	int newPlace;

	while (place*2+1 < heap.size()){
	    if (heap.size() == place*2+2){
		newPlace = place*2+1;
	    }else if (heap.get(place*2+1) > heap.get(place*2+2)){
		newPlace = place*2+1;
	    }else{
		newPlace = place*2+2;
	    }
	    heap.set(place, heap.get(newPlace));
	    place = newPlace;
	}
	heap.remove(place);
    }

    private void removeMin(){
	int place = 0;
	int newPlace;

	while (place*2+1 < heap.size()){
	    if (heap.size() == place*2+2){
		newPlace = place*2+1;
	    }else if (heap.get(place*2+1) < heap.get(place*2+2)){
		newPlace = place*2+1;
	    }else{
		newPlace = place*2+2;
	    }
	    heap.set(place, heap.get(newPlace));
	    place = newPlace;
	}
	heap.remove(place);
    }

    //For Add
    public void add(int e){
	if (heap.size() == 0){
	    heap.add(e);
	}else if (isMax){
	    addMax(e);
	}else{
	    addMin(e);
	}
    }

    private void addMax(int e){
	int place = heap.size();
	heap.add(e);
	while (place != 0 && e > heap.get((place-1)/2)){
	    heap.set(place, heap.get((place-1)/2));
	    place = (place-1)/2;
	}
	heap.set(place, e);
    }
    
    private void addMin(int e){
	int place = heap.size();
	heap.add(e);
	while (place != 0 && e < heap.get((place-1)/2)){
	    heap.set(place, heap.get((place-1)/2));
	    place = (place-1)/2;
	}
	heap.set(place, e);
    }

    public int peek(){
	return heap.get(0);
    }
}