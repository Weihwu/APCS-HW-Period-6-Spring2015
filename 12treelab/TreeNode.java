public class TreeNode<E>{
    
    private E data;
    private TreeNode<E> left;
    private TreeNode<E> right;

    public TreeNode(){
    }

    public TreeNode(E value){
	data = value;
    }

    public TreeNode(E value, TreeNode<E> valuel, TreeNode<E> valuer){
	data = value;
	left = valuel;
	right = valuer;
    }
    
    public void setData(E value){
	data = value;
    }

    public E getData(){
	return data;
    }

    public void setLeft(TreeNode<E> value){
	left = value;
    }
    
    public TreeNode<E> getLeft(){
	return left;
    }

    public void setRight(TreeNode<E> value){
	right = value;
    }

    public TreeNode<E> getRight(){
	return right;
    }
}