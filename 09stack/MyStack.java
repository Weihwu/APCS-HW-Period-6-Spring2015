import java.util.*;

public class MyStack<T>{

    LNode<T> top;

    public boolean empty(){
	return top == null;
    }

    public static void main(String[] args){
	
	MyStack<String> a = new MyStack<String>();
	
	out(a.empty());
	out(a.peek());
    }
    
    public T peek(){
	if (top == null){
	    throw new EmptyStackException();
	}

	return top.getData();
    }

    public static void out(Object phrase){

	System.out.println(phrase);

    }
}