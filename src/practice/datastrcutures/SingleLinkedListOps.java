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

    private void removeElement(T data) {
        if(this.head == null) {
            System.out.println("List is empty");
        } else {
            Node<T> curr = this.head;
            Node<T> prev = this.head;

            while(curr.next != null) {
                if(curr.data.equals(data)) {
                    prev.next = curr.next;
                    Node.count--;
                }
                prev = curr;
                curr = curr.next;
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

    private void sizeOfTheList() {
        System.out.println("Size Of LinkedList - "+ Node.count);
    }

    @SuppressWarnings("UnnecessaryBoxing")
    public static void main(String[] args) {

        SingleLinkedListOps<Integer> integerList = new SingleLinkedListOps<>();
        SingleLinkedListOps<String> stringList = new SingleLinkedListOps<>();

        integerList.addElement(new Integer(1));
        integerList.addElement(new Integer(2));
        integerList.addElement(new Integer(3));
        integerList.addElement(new Integer(4));
        integerList.addElement(new Integer(5));
        integerList.addElement(new Integer(6));
        integerList.addElement(new Integer(7));
        integerList.addElement(new Integer(8));

        integerList.sizeOfTheList();

        integerList.printAllNodes();

        integerList.removeElement(2);
        integerList.removeElement(5);
        integerList.removeElement(7);

        integerList.sizeOfTheList();

        integerList.printAllNodes();

        stringList.addElement("A");
        stringList.addElement("B");
        stringList.addElement("C");
        stringList.addElement("D");
        stringList.addElement("E");

        stringList.printAllNodes();

    }
}
