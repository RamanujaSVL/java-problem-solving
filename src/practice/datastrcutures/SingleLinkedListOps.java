package practice.datastrcutures;

class Node<T> {
    static int count;
    T data;
    Node next;

    Node(T t){
        ++count;
        this.data = t;
        next = null;
    }

}

public class SingleLinkedListOps<T> {

    Node head;

    SingleLinkedListOps(){
        head = null;
    }


    private void addElement(T t) {

        if (head == null) {
            head = new Node(t);
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node(t);
        }

    }

    private void removeElement(T t) {

    }

    private void printAllNodes() {
        if(head == null) {
            System.out.println("List is empty");
        } else {
            while(head.next != null) {
                System.out.print(head.data+"->");
                head = head.next;
            }
            System.out.println(head.data);
        }

    }

    public static void main(String[] args) {

        SingleLinkedListOps<Integer> list = new SingleLinkedListOps<Integer>();

        list.addElement(new Integer(1));
        list.addElement(new Integer(2));
        list.addElement(new Integer(3));
        list.addElement(new Integer(4));
        list.addElement(new Integer(5));
        list.addElement(new Integer(6));
        list.addElement(new Integer(7));
        list.addElement(new Integer(8));
        //System.out.println(Node.count);

        list.printAllNodes();



    }
}
