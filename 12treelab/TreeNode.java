import java.util.*;

public class TreeNode<E>{
    
    private E data;
    private TreeNode<E> sib1;
    private TreeNode<E> sib2;
    
    Random r = new Random();

    public TreeNode(){
    }

    public TreeNode(E value){
	data = value;
    }
    
    public void setData(E value){
	data = value;
    }

    public E getData(){
	return data;
    }

    public void setSib(TreeNode<E> node){
	if (sib1 == null && sib2 == null){
	    if (r.nextInt(2) == 0){
		sib1 = node;
	    }else{
		sib2 = node;
	    }
	    
	}else if (sib1 == null){
	    sib1 = node;
	}else{
	    sib2 = node;
	}
    }
}