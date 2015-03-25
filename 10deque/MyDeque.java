public class MyDeque<T>{

    Object[] ary;
    int head;
    int tail;

    public MyDeque(){
	ary = new Object[100];
	head = ary.length/2;
	tail = head;
    }

    public void addFirst(T value){
	if (ary[head] == null){
	    ary[head] = value;
	}else{
	    ary[--head] = value;
	}
    }

    public void addLast(T value){
	if (ary[head] == null){
	    ary[head] = value;
	}else if (ary[tail] == null){
	    ary[head] = value;
	}else{
	    ary[++tail] = value;
	}
    }
    
    public static void main(String[] args){
	
	MyDeque<String> a = new MyDeque<String>();

	a.addFirst("hi");
	a.addFirst("hello");
	a.addLast("bye");
	a.addLast("srly");
    }
}