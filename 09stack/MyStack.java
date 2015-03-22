import java.util.*;

public class MyStack<T>{

    LNode<T> top;

    public boolean empty(){
	return top == null;
    }
    
    public T peek(){
	if (top == null){
	    throw new EmptyStackException();
	}

	return top.getData();
    }

    public T pop(){
	if (top == null){
	    throw new EmptyStackException();
	}

	T holder = top.getData();
	top = top.getNext();
	return holder;
    }

    public T push(T item){
	LNode<T> interest = new LNode<T>(item);

	if (top != null){
	    interest.setNext(top);
	}

	top = interest;
	return item;
    }

    public int search(Object o){
	LNode<T> interest = top;

	int place = 1;

	while (interest != null){
	    if (interest.getData().equals(o)){
		return place;
	    }
	    place++;
	    interest = interest.getNext();
	}
	
	return -1;
    }

    public static void main(String[] args){
	
	MyStack<String> a = new MyStack<String>();
	
	out(a.empty());

	out(a.push("first"));
	out(a.push("second"));
	out(a.peek());
	out(a.empty());
	out(a.search("first"));
    }

    public static void out(Object phrase){
	System.out.println(phrase);
    }
}