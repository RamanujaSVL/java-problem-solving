package practice.datastrcutures;

class Node<T> {
    static int count;
    T data;
    Node<T> next;

    Node(T t){
        ++count;
        this.data = t;
        next = null;
    }

}

public class SingleLinkedListOps<T> {

    Node<T> head;

    SingleLinkedListOps(){
        head = null;
    }


    private void addElement(T data) {

        if (this.head == null) {
            head = new Node<T>(data);
        } else {
            Node<T> curr = this.head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node<T>(data);
        }
    }

    //TODO - TBD
    private void removeElement(T t) {
        if(this.head == null) {
            System.out.println("List is empty");
        } else {
            Node<T> curr = this.head;
            while(curr.next != null) {
                if(curr.data == t) {
                    curr.data = (T) new Integer(582);
                }
            }
        }
    }

    private void printAllNodes() {

        if(this.head == null) {
            System.out.println("List is empty");
        } else {
            Node<T> curr = this.head;
            while(curr.next != null) {
                System.out.print(curr.data+"->");
                curr = curr.next;
            }
            System.out.println(curr.data);
        }

    }

    @SuppressWarnings("UnnecessaryBoxing")
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

        list.removeElement(2);

        list.printAllNodes();
    }
}
