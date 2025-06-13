class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    Node head;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void insertAtPosition(int data, int position) {
        if (position < 0) {
            System.out.println("Invalid position!");
            return;
        }
        Node newNode = new Node(data);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node temp = head;
        int index = 0;
        while (temp != null && index < position - 1) {
            temp = temp.next;
            index++;
        }
        if (temp == null) {
            System.out.println("Position out of bounds!");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteAtPosition(int position) {
        if (head == null || position < 0) {
            System.out.println("Invalid position or empty list!");
            return;
        }
        Node temp = head;
        if (position == 0) {
            head = head.next;
            return;
        }
        int index = 0;
        while (temp != null && index < position - 1) {
            temp = temp.next;
            index++;
        }
        if (temp == null || temp.next == null) {
            System.out.println("Position out of bounds!");
            return;
        }
        temp.next = temp.next.next;
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        System.out.println("Original list:");
        list.printList();

        list.insertAtPosition(25, 2);
        System.out.println("After inserting 25 at position 2:");
        list.printList();

        list.deleteAtPosition(3);
        System.out.println("After deleting node at position 3:");
        list.printList();

        list.reverse();
        System.out.println("After reversing the list:");
        list.printList();
    }
}
