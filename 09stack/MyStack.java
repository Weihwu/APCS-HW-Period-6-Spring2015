import java.util.*;

public class MyStack<T>{

    LNode<T> first;

    public boolean empty(){
	return first == null;
    }

    public static void main(String[] args){
	
	MyStack<String> a = new MyStack<String>();
	
	out(a.empty());
    }

    public static void out(Object phrase){
	System.out.println(phrase);
    }
}