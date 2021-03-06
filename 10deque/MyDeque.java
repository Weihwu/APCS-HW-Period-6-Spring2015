import java.util.*;

public class MyDeque<T>{

    Object[] ary;
    int head;
    int tail;

    public MyDeque(){
	ary = new Object[10];
	head = ary.length/2;
	tail = head;
    }

    public void addFirst(T value){
	if ((head == 0 && tail == ary.length-1) || (head == tail+1)){
	    resize();
	}
	if (ary[head] != null){
	    head--;
	    if (head < 0){
		head = ary.length-1;
	    }
	}
	ary[head] = value;
    }

    public void addLast(T value){
	if ((head == 0 && tail == ary.length-1) || (head == tail+1)){
	    resize();
	}
	if (ary[head] != null){
	    tail++;
	    if (tail >= ary.length){
		tail = 0;
	    }
	}
	ary[tail] = value;
    }

    public T removeFirst(){
	if (ary[head] == null){
	    throw new NoSuchElementException();
	}
	T holder = (T)ary[head];
	ary[head] = null;
	if(head >= ary.length-1){
	    head = 0;
	}else if (head != tail){
	    head++;
	}
	return holder;
    }

    public T removeLast(){
	if (ary[tail] == null){
	    throw new NoSuchElementException();
	}
	T holder = (T)ary[tail];
	ary[tail] = null;
	if (tail == 0){
	    tail = ary.length-1;
	}else if (head != tail){
	    tail--;
	}
	return holder;
    }

    public T getFirst(){
	if (ary[head] == null){
	    throw new NoSuchElementException();
	}
	return (T)ary[head];
    }

    public T getLast(){
	if (ary[tail] == null){
	    throw new NoSuchElementException();
	}
	return (T)ary[tail];
    }

    private void resize(){
	Object[] newAry = new Object[ary.length*2];
	if (tail > head){
	    System.arraycopy(ary, 0, newAry, ary.length/2, ary.length);
	}else{
	    System.arraycopy(ary, head, newAry, ary.length/2, ary.length-head);
	    System.arraycopy(ary, 0, newAry, ary.length*3/2-head, head);
	}
	head = ary.length/2;
	tail = head + ary.length-1;
	ary = newAry;
	
    }
    public String toString(){
	return Arrays.toString(ary);
    }

    public static void main(String[] args){
	
	MyDeque<String> a = new MyDeque<String>();

	a.addFirst("hi");
	out(a);
	a.addFirst("hello");
	out(a);
	a.addLast("bye");
	out(a);
	a.addLast("srly");
	out(a);
	a.removeFirst();
	out(a);
	a.removeLast();
	out(a);
	out(a.getFirst());
	out(a.getLast());
	a.addFirst("7");
	a.addFirst("6");
	a.addFirst("5");
	a.addFirst("4");
	a.addFirst("3");
	a.addFirst("2");       
	a.addFirst("1");
	a.addFirst("0");
	a.addFirst("the doubler");
	out(a);
    }

    public static void out(Object phrase){
	System.out.println(phrase);
    }
}