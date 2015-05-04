import java.io.*;
import java.util.*;

public class BSTree<T extends Comparable>{
    
    private BSTreeNode<T> root;
    private Random r;
    
    public BSTree(){
	root = null;
	r = new Random();
    }
    
    public BSTree(long seed){
	root = null;
	r = new Random(seed);
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
	if (curr == null){
	    return t;
	}
	if (curr.compareTo(t) < 0){
	    curr.setRight(add(curr.getRight(), t));
	}else{
	    curr.setLeft(add(curr.getLeft(), t));
	}
	return curr;
    }

    public void remove(T c){
	root = remove(root, c);
    }

    private BSTreeNode<T> remove(BSTreeNode<T> curr, T c){
	if (curr == null){
	    return null;
	}
	if (curr.getData().compareTo(c) == 0){
	    if (isLeaf(curr)){
		return null;
	    }else if (curr.getRight() == null){
		return curr.getLeft();
	    }else if (curr.getLeft() == null){
		return curr.getRight();
	    }else{
		BSTreeNode<T> holder;
		if (r.nextInt(2) == 0){
		    holder = curr.getRight();
		    while (holder.getLeft() != null){
			holder = holder.getLeft();
		    }
		    curr.setData(holder.getData());
		    curr.setRight(remove(curr.getRight(), holder.getData()));
		}else{
		    holder = curr.getLeft();
		    while (holder.getRight() != null){
			holder = holder.getRight();
		    }
		    curr.setData(holder.getData());
		    curr.setLeft(remove(curr.getLeft(), holder.getData()));
		}
	    }
	}
	else if (curr.getData().compareTo(c) < 0){
	    curr.setRight(remove(curr.getRight(), c));
	}else if (curr.getData().compareTo(c) > 0){
	    curr.setLeft(remove(curr.getLeft(), c));
	}
	return curr;
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
	BSTree a = new BSTree<Integer>();
	a.add(5);
	a.add(7);
	a.add(20);
	a.add(3);
	a.add(6);
	System.out.println(a);
	a.remove(5);
	System.out.println(a);
    }

    /**
     * Donated by: Dennis Yatunin
     */
    
    public int getHeight(){
	return getHeight(root);
    }
    
    private int getHeight(BSTreeNode<T> r ){
	if(r == null){
	    return 0;
		}else{
	    //System.out.println("recursion height");
	    return 1 + Math.max(getHeight(r.getLeft()),
				getHeight(r.getRight()));
	}
    }
    
    private int maxLength() {
	// returns the minimum number of characters required
	// to print the data from any node in the tree
	if (root == null)
	    return 0;
	return maxLength(root);
    }
    
    private int maxLength(BSTreeNode<T> curr) {
	int max = curr.toString().length();
	int temp;
	if (curr.getLeft() != null) {
	    temp = maxLength(curr.getLeft());
	    if (temp > max)
		max = temp;
	}
	if (curr.getRight() != null) {
	    temp = maxLength(curr.getRight());
	    if (temp > max)
		max = temp;
	}
	return max;
    }
    
    private String spaces(double n) {
	// returns a String of n spaces
	String result = "";
	for (int i = 0; i < n; i++)
	    result += " ";
	return result;
    }
    
    /*
      getLevel will produce a String for each level of the tree.
      The resulting Strings will look like this:
      
      ._______________________________
      ._______________._______________
      ._______._______._______._______
      .___.___.___.___.___.___.___.___
	._._._._._._._._._._._._._._._._
	
	toString will combine those Strings and provide an output that
	will look like this:
	
	_______________.
	_______._______________.
	___._______._______._______.
	_.___.___.___.___.___.___.___.
	._._._._._._._._._._._._._._._.
	In these diagrams, each dot represents wordLength characters,
	each underscore represents wordLength spaces, and, for any nodes
	that are null, the dots will be "replaced" by underscores.
    */
    
    private String getLevel(BSTreeNode<T> curr, int currLevel, int targetLevel, int height, int wordLength) {
	if (currLevel == 1){
	    return curr.toString() + 
		spaces(wordLength - curr.toString().length()) +
		spaces(wordLength * 
		       Math.pow(2, height - targetLevel + 1) - 
		       wordLength);
	}
	String result = "";
	if (curr.getLeft() != null){
	    result += getLevel(curr.getLeft(), currLevel - 1, targetLevel, height, wordLength);
		}else{
	    result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
	}
	if (curr.getRight() != null){
	    result += getLevel(curr.getRight(), currLevel - 1, targetLevel, height, wordLength);
	}else{ 
	    result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
	}
	return result;
    }
    
    public String toString() {
	if (root == null)
	    return "";
	String result = "";
	int height = getHeight();
	int wordLength = maxLength();
	// add the every level of the tree except the last one
	for (int level = 1; level < height; level++){
	    // remove extra spaces from the end of each level's String to prevent lines from
	    // getting unnecessarily long and add spaces to the front of each level's String
	    // to keep everything centered
	    result += spaces(wordLength * Math.pow(2, height - level) - wordLength) +
		getLevel(root, level, level, height, wordLength).replaceFirst("\\s+$", "") +
		"\n";
	}
		// now add the last level (level = height)
	result += getLevel(root, height, height, height, wordLength).replaceFirst("\\s+$", "");
	
	return result;
    }
}

