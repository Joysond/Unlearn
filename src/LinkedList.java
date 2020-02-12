import java.util.Random;

public class LinkedList {
    public static void main(String[] args) {
        Node root = new Node("root");
        /*Node first = new Node("first");
        Node second = new Node("second");
        Node third = new Node("third");
        Node fourth = new Node("fourth");
        Node fifth = new Node("fifth");*/
        buildList(root, 10);
        printList(root);
        System.out.println();
        root = pushFirst(root, "first");
        printList(root);
    }

    private static void buildList(Node root, int length) {
        Node temp = root;
        Random rand = new Random();
        for(int i=0;i<length;i++) {
            temp.setNext(new Node(rand.nextInt() % length+""));
            temp = temp.getNext();
        }
    }

    private static void printList(Node root) {
        Node temp = root;
        for(;temp!=null;) {
            System.out.print(temp.getData() + "->");
            temp = temp.getNext();
        }
    }

    private static Node pushFirst(Node root, String value) {
        Node temp = new Node(value);
        temp.setNext(root);
        return temp;
    }

    public static class Node {
        private String data;

        public Node(String data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        Node next;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
}
