import java.util.*;

public class MyQueue<T>{

    private MyLinkedList<T> list;

    public MyQueue(){
	list = new MyLinkedList<T>();
    }

    public boolean enqueue(T e){
	list.add(e);
	return true;
    }

    public T dequeue(){
	return list.remove();
    }

    public static void main(String[] args){
	MyQueue<String> a = new MyQueue<String>();
	
	out(a.enqueue("Hi"));
	out(a.enqueue("Bye"));

	out(a.dequeue());
    }

    public static void out(Object phrase){
	System.out.println(phrase);
    }
}