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

    public T dequeue(T e){
	return list.remove();
    }

    public static void main(String[] args){
    }
}