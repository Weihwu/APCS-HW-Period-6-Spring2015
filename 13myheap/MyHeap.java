public class MyHeap{

    private boolean isMax;
    private ArrayList<Integer> heap = new ArrayList<Integer>();

    public MyHeap(){
	MyHeap(true);
    }

    public MyHeap(boolean isMax){	       
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
	if (isMax == true){
	    addMax(int e);
	}else{
	    addMin(int e);
	}
    }

    private addMax(int e){
    }
    
    private addMin(int e){
    }

    public int peek(){
    }
}
