public class RunningMedian{

    private MyHeap minHeap = new MyHeap(false);
    private MyHeap maxHeap = new MyHeap();

    private int counter = 0;

    public double getMedian(){
	if (counter%2 ==0){
	    return (minHeap.peek() + maxHeap.peek())/2;
	}else{
	    return maxHeap.peek();
	}
    }

    public void add(int    e){
	if (counter%2 ==0){
	    maxHeap.add(e);
	}else if (e >= getMedian()){
	    minHeap.add(e);
	}else{
	    int temp = maxHeap.peek();
	    maxHeap.remove();
	    minHeap.add(temp);
	    maxHeap.add(e);
	}
	counter++;
    }

    public static void main(String[] args){
	
	RunningMedian a = new RunningMedian();

	a.add(3);
	System.out.println(a.getMedian());
	a.add(10);
	System.out.println(a.getMedian());
	a.add(23);
	System.out.println(a.getMedian());
	a.add(2);
	System.out.println(a.getMedian());
	a.add(5);
	System.out.println(a.getMedian());
    }
}