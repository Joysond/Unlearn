public class DoublyLinkedList {

    public static void main(String... args) {
        Node root = new Node("root");
        Node first = new Node("first");
        root.setNext(first);
        first.setPrevious(root);
        //System.out.println(root);
        printList(root);
    }

    public static void printList(Node root) {
        Node temp = root;
        while (temp != null) {
            System.out.print(temp + " -> ");
            temp = temp.getNext();
        }
    }

    private static class Node {
        private Node next;
        private Node previous;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return this.next;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public Node getPrevious() {
            return this.previous;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}
