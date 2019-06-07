package LinkedList;

public class MyList<E extends Comparable<E>> {

    // khai báo private để Node chỉ dùng cho riêng class list
    private static class Node<E> {

        // Kiểu E là một object có thể truyền đối tượng
        private E info;
        private Node<E> next;

        public Node() {
        }

        public Node(E info, Node<E> next) {
            this.info = info;
            this.next = next;
        }

        public Node(E info) {
            this.info = info;
            this.next = null;
        }

        public E getInfo() {
            return info;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setInfo(E info) {
            this.info = info;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    Node<E> head, tail;
    Node<E> sorted;

    public void myList() {
        head = tail = null;
    }

    // check linked is empty or not
    public boolean isEmpty() {
        return (head == null);
    }

    // clear linked list
    public void clear() {
        head = tail = null;
    }

    // Add to head of lineked list
    public void addToHead(E x) {
        if (isEmpty()) {
            head = tail = new Node(x);
        } else {
            Node newNode = new Node(x);
            newNode.next = head;
            head = newNode;
        }
    }
//
//    public E search(int code) {
//        //E current = head;
//        Node<E> current = head;
//        while (current != null) {
//            if (current.info. == code) { // làm thế nào để get code từ đối tượng??
//                current;
//            }
//            else current = current.next;
//
//        }
//    }

    // Add to tail of linked list
    public void addToTail(E x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
        } else {
            tail.next = q;
            tail = q;
        }
    }

    // Print all info in linked list
    public void traverse() {
        Node<E> p = head;
        while (p != null) {
            System.out.println(p.info);
            p = p.next;
        }
        System.out.println();
    }

    // serch Object in Linked list
    public E search(E x) {
        if (isEmpty()) {
            System.out.println("The list is empty.");
        }
        boolean check = false;
        Node<E> currentNode = head;
        while (currentNode != null) {
            // when Object exits in lined list
            if (currentNode.info.equals(x)) {
                check = true;
                break;
            }
            currentNode = currentNode.next;
        }
        // when Object not exits in linked list
        if (!check) {
            System.out.println("The given list does not have x object.");
            return null;
        }
        return currentNode.info;
    }

    // sort linked list
    public void sort() {
        sorted = null;
        Node<E> currentNode = head;

        while (currentNode != null) {
            Node<E> next = currentNode.next;
            sortInsert(currentNode);
            currentNode = next;
        }
        head = sorted;
    }

    void sortInsert(Node<E> newNode) {
        // Specail case for head end
        if (sorted == null || sorted.info.compareTo(newNode.info) <= 0) { //>=
            newNode.next = sorted;
            sorted = newNode;
        } else {
            Node<E> currentNode = sorted;
            /* Locate the node before the point of insertion */
            while (currentNode.next != null && currentNode.next.info.compareTo(newNode.info) > 0) { //<
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
    }

    // delete Node have info = Object(pcode, ccode)
    public void delete(E x) {
        if (head == null) {
            System.err.println("The list is empty");
            return;
        }

        Node<E> currentNode = head;
        Node<E> pre_Node = new Node();
        if (head.info.equals(x)) {
            head = head.next;
            System.err.println("Deleted!");

            return;
        }

        //find the node previous of the the node want to delete
        while (!currentNode.info.equals(x) && currentNode.next != null) {
            pre_Node = currentNode;
            currentNode = currentNode.next;
        }

        if (currentNode.next == null && !currentNode.info.equals(x)) {
            System.err.println("The given list does not have x value.");
            return;
        }
        pre_Node.next = currentNode.next;
        System.err.println("Deleted!");
    }

    public void addAfterPosition(int position, E x) {
        Node<E> newNode = new Node(x);
        // calulate position
        int d = 0;
        Node<E> currentNode = head;
        while (currentNode != null && d < position) {
            currentNode = currentNode.next;
            d++;
        }
        // if position is higher than size of linked list 
        if (currentNode == null && d < position) {
            System.err.println("Position is higher than size of linked list.");
            return;
        }
        Node<E> preNode = currentNode.next;
        newNode.next = preNode;
        currentNode.next = newNode;
    }

    public void deleteAfterNode(E x) {
        if (isEmpty()) {
            System.err.println("The list is empty.");
        }
        boolean check = false;
        Node<E> currentNode = head;
        Node<E> deletedNode = new Node();
        while (currentNode != null) {
            // when Object exits in lined list
            if (currentNode.info.equals(x)) {
                check = true;
                break;
            }
            currentNode = currentNode.next;
        }
        // when Object not exits in linked list
        if (!check) {
            System.err.println("The given list does not have x object.");
            return;
        }
        if (currentNode.next == null) {
            System.err.println("Tail of linked list is null.");
            return;
        }
        deletedNode = currentNode.next;
        currentNode.next = deletedNode.next;
        System.err.println("Delete sucessfull.");
    }

    //get Object by position
    public E getObject(int position) {
        if (isEmpty()) {
            System.out.println("The list is empty.");
        }
        boolean check = false;
        int count = 0;
        Node<E> currentNode = head;
        while (currentNode != null) {
            // when Object exits in lined list
            if (position == count) {
                check = true;
                break;
            }
            currentNode = currentNode.next;
            count++;
        }
        // when Object not exits in linked list
        return currentNode.info;
    }

    //get length of linkedList
    public  int length() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
        }
        int count = 0;
        Node<E> currentNode = head;
        while (currentNode != null) {
            currentNode = currentNode.next;
            count++;
        }
        return count;
    }
}
