public class LNode {

    private Object data;
    private LNode next;

    public LNode() { }

    public LNode(Object e) {
        data = e;
    }

    public void setData(Object e) {
        data = e;
    }

    public Object getData() {
        return data;
    }

    public void setNext(LNode node) {
        next = node;
    }

    public LNode getNext() {
        return next;
    }
}