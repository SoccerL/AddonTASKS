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
 
// Doubly Linked List with insertAtMiddle
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
 
    // Count nodes
    public int getLength() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
 
    // Insert in the middle
    public void insertAtMiddle(int data) {
        int length = getLength();
        int mid = length / 2;
 
        Node newNode = new Node(data);
 
        if (head == null) {
            head = newNode;
            return;
        }
 
        Node temp = head;
        for (int i = 0; i < mid - 1; i++) {
            temp = temp.next;
        }
 
        // Insert after temp
        newNode.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
        newNode.prev = temp;
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
}
 
// Main class
public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.append(10);
        dll.append(20);
        dll.append(30);
        dll.append(40);
 
        dll.displayForward();   // Before insertion
 
        dll.insertAtMiddle(99); // Insert 99 in the middle
 
        dll.displayForward();   // After insertion
        dll.displayBackward();
    }
}