public class MyHeap{

    private ArrayList<Integer> heap = new ArrayList<Integer>();
    private boolean isMax;
    private boolean hasRoot;

    public MyHeap(){
	hasRoot = false;
	isMax = true;
    }

    public MyHeap(boolean isMax){
	this();
	this.isMax = isMax;
    }

    public String toString(){
    }

    //For Remove
    public int remove(){
	if (isMax == true){
	    removeMax(int e);
	}else{
	    removeMin(int e);
	}
    }

    private removeMax(int e){
    }

    private removeMin(int e){
    }

    //For Add
    public void add(int e){
	if (!hasRoot){
	    heap.set(1, e);
	    hasRoot = true;
	}else if (isMax == true){
	    addMax(int e);
	}else{
	    addMin(int e);
	}
    }

    private addMax(int e){
	int place = heap.size() + 1;
	while (place != 1 && e > heap.get(place/2)){
	    heap.set(place, heap.get(place/2));
	    place /= 2;
	}
	heap.set(place, e);
    }
    
    private addMin(int e){
	int place = heap.size() + 1;
	while (place != 1 && e < heap.get(place/2)){
	    heap.set(place, heap.get(place/2));
	    place /= 2;
	}
	heap.set(place, e);
    }

    public int peek(){
	return heap.get(1);
    }
}
