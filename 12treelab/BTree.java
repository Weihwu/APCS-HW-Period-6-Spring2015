import java.io.*;
import java.util.*;

public class BTree<E>{
   
    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;

    private TreeNode<E> root;

    Random r = new Random();

    public BTree(){
	root = null;
    }

    public void add(E d){
	TreeNode<E> node = new TreeNode(d);
	add(root, node);
    }

    private void add(TreeNode<E> curr, TreeNode<E> bn){\
	if (curr == null){
	    curr = bn;
	}else{
	    if (curr.getLeft() == null && curr.getRight() == null){
		if (r.nextInt(2) == 0){
		    curr.setLeft(bn);
		}else{
		    curr.setRight(bn);
		}
	    }else if (getLeft() == null){
		curr.setLeft(bn);
	    }else{
		curr.setRight(bn);
	    }
	}
    }

    public void traverse(int mode){
	if (mode == PRE_ORDER){
	    preOrder(root);
	}else if(mode == IN_ORDER){
	    inOrder(root);
	}else{
	    postOrder(root);
	}
	System.out.println();
    }

    public void preOrder(TreeNode<E> curr){
	
    }

    public void inOrder(TreeNode<E> curr){
    }

    public void postOrder(TreeNode<E> curr){
    }

    public int getHeight(){
	return getHeight(root);
    }

    private int getHeight(TreeNode<E> curr){
    }
    
    private String getLevel(TreeNode<E> curr, int level, int currLevel){
    }

    public String toString(){
    }

    public static void main(String[] args){
	
	BTree<Integer> t = new BTree<Integer>();
	
	for (int i = 0; i < 8; i++){
	    t.add(i);
	    System.out.println("Pre_Order:");
	    t.traverse(PRE_ORDER);
	    System.out.println("In-Order:");
	    t.traverse(IN_ORDER);
	    System.out.println("Post-Order:");
	    t.traverse(POST_ORDER);
	    System.out.println("Height: " + t.getHeight());

	    System.out.println(t);
	}
    }
}