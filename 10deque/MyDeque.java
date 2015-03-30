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

    public T removeFirst(){
	if (ary[head] == null){
	    throw new NoSuchElementException();
	}
	T holder = (T)ary[head];
	ary[head] = null;
	if(head >= ary.length-1){
	    head = 0;
	}else{
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
	}else{
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
    }

    public static void out(Object phrase){
	System.out.println(phrase);
    }
}