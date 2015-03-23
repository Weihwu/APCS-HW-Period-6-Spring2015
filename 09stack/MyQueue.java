import java.util.*;

public class MyQueue<T>{

    private MyLinkedList<T> list;

    public boolean enqueue(T e){
	return true;
    }

    public T dequeue(T e){
	return e;
    }

}