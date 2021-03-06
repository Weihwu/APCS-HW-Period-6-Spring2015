import java.io.*;
import java.util.*;

public class BTree<E>{
   
    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;

    private TreeNode<E> root;

    private Random r;

    public BTree(){
	root = null;
	r = new Random();
    }

    public BTree(long seed){
	root = null;
	r = new Random(seed);
    }

    public void add(E d){
	TreeNode<E> node = new TreeNode(d);
	if (root == null){
	    root = node;
	}else{
	    add(root, node);
	}
    }

    private void add(TreeNode<E> curr, TreeNode<E> bn){
	if (curr.getLeft() == null && curr.getRight() == null){
	    if (r.nextInt(2) == 0){
		curr.setLeft(bn);
	    }else{
		curr.setRight(bn);
	    }
	}else if (curr.getLeft() == null){
	    curr.setLeft(bn);
	}else if (curr.getRight() == null){
	    curr.setRight(bn);
	}else{
	    if (r.nextInt(2) == 0){
		add(curr.getLeft(), bn);
	    }else{
		add(curr.getRight(), bn);
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
	System.out.println(curr.getData() + " ");
	if (curr.getLeft() != null){
	    preOrder(curr.getLeft());
	}
	if (curr.getRight() != null){
	    preOrder(curr.getRight());
	}
    }

    public void inOrder(TreeNode<E> curr){
	if (curr.getLeft() != null){
	    inOrder(curr.getLeft());
	}
	System.out.println(curr.getData() + " ");
	if (curr.getRight() != null){
	    inOrder(curr.getRight());
	}
    }

    public void postOrder(TreeNode<E> curr){
	if (curr.getLeft() != null){
	    postOrder(curr.getLeft());
	}
	if (curr.getRight() != null){
	    postOrder(curr.getRight());
	}
	System.out.println(curr.getData() + " ");
    }

    public int getHeight(){
	return getHeight(root);
    }

    private int getHeight(TreeNode<E> curr){
	if (curr.getLeft() == null && curr.getRight() == null){
	    return 1;
	}
	
	int left;
	int right;

	if (curr.getLeft() == null){
	    left = 0;
	}else{
	    left = getHeight(curr.getLeft());
	}
	if (curr.getRight() == null){
	    right = 0;
	}else{
	    right = getHeight(curr.getRight());
	}
    
	if (left <= right){
		return 1 + right;
	}else{
	    return 1 + left;
	}
    }
    
    private String getLevel(TreeNode<E> curr, int level, int currLevel){
	if (curr == null){
	    return "";
	}
	if (level == currLevel){
	    return curr.getData() + " ";
	}
	
	return getLevel(curr.getLeft(), level, currLevel+1) + getLevel(curr.getRight(), level, currLevel+1);
    }
    
    public String toString(){
	String ans = "";
	for (int x = 1; x <= getHeight(); x++){
	    ans += getLevel(root, x, 1) + "\n";
	}
	return ans;
    }
    
    public static void main(String[] args){
	
	BTree<Integer> t = new BTree<Integer>();
	
	for (int i = 0; i < 8; i++){
	    t.add(i);
	}
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