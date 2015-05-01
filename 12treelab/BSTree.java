import java.io.*;
import java.util.*;

public class BSTree<T extends Comparable>{
    
    private BSTreeNode<T> root;
    
    public BSTree(){
	root = null;
    }

    public boolean isEmpty(){
	return root == null;
    }

    public boolean isLeaf(BSTreeNode<T> t){
	return (t.getLeft() == null && t.getRight() == null);
    }

    public void add(T c){
	root = add(root, new BSTreeNode<T>(c));
    }

    private BSTreeNode<T> add(BSTreeNode<T> curr, BSTreeNode<T> t){
	return null;
    }

    public void remove(T c){
	root = remove(root, c);
    }

    private BSTreeNode<T> remove(BSTreeNode<T> curr, T c){
	return null;
    }

    public void inOrder(){
	inOrderHelper(root);
	System.out.println();
    }

    public void inOrderHelper(BSTreeNode<T> t){
	if (t == null){
	    return;
	}
	inOrderHelper(t.getLeft());
	System.out.println(t.getData() + " ");
	inOrderHelper(t.getRight());
    }

    public static void main(String[] args){
    }
}

    