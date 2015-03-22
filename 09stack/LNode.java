public class LNode<T>{

    private T data;
    private LNode<T> next;

    public LNode() { }

    public LNode(T e) {
        data = e;
    }

    public void setData(T e){
        data = e;
    }

    public T getData() {
        return data;
    }

    public void setNext(LNode<T> node) {
        next = node;
    }

    public LNode<T> getNext() {
        return next;
    }
}