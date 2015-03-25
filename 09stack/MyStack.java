import java.util.*;

public class MyStack<T>{

    MyLinkedList<T> pile;

    public MyStack(){
	pile = new MyLinkedList<T>();
    }

    public boolean empty(){
	return pile.isEmpty();
    }
    
    public T peek(){
	if (empty()){
	    throw new EmptyStackException();
	}

	return pile.get(0);
    }

    public T pop(){
	if (empty()){
	    throw new EmptyStackException();
	}

	return pile.remove();
    }

    public T push(T item){
	pile.add(0, item);

	return item;
    }

    public int search(T e){
	return pile.indexOf(e);
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