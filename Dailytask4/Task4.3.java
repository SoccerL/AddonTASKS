class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

// Doubly Linked List with deleteAtMiddle
class DoublyLinkedList {
    Node head;

    // Append at the end
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Count the number of nodes
    public int getLength() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Delete the middle node
    public void deleteAtMiddle() {
        int length = getLength();
        if (length == 0) {
            System.out.println("List is empty.");
            return;
        }

        int mid = length / 2;
        Node temp = head;

        // Traverse to the middle node
        for (int i = 0; i < mid; i++) {
            temp = temp.next;
        }

        // If deleting the head (only 1 element)
        if (temp.prev == null) {
            head = temp.next;
            if (head != null) head.prev = null;
        }
        // If deleting a middle/tail node
        else {
            temp.prev.next = temp.next;
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }
        }

        System.out.println("Deleted node with value: " + temp.data);
    }

    // Display forward
    public void displayForward() {
        Node temp = head;
        System.out.print("Forward Traversal: ");
        while (temp != null) {
            System.out.print(temp.data + (temp.next != null ? " <-> " : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    // Display backward
    public void displayBackward() {
        Node temp = head;
        if (temp == null) {
            System.out.println("List is empty.");
            return;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        System.out.print("Backward Traversal: ");
        while (temp != null) {
            System.out.print(temp.data + (temp.prev != null ? " <-> " : ""));
            temp = temp.prev;
        }
        System.out.println();
    }

    // Main method inside the same file
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        // Append some nodes
        dll.append(10);
        dll.append(20);
        dll.append(30);
        dll.append(40);
        dll.append(50);

        // Display the list
        dll.displayForward();
        dll.displayBackward();

        // Delete the middle node
        dll.deleteAtMiddle();

        // Display the list after deletion
        dll.displayForward();
        dll.displayBackward();
    }
}
