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
 
// Doubly Linked List class
class DoublyLinkedList {
    Node head;
 
    // Append node at the end
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
 
    // Traverse forward
    public void displayForward() {
        Node temp = head;
        System.out.print("Forward Traversal: ");
        while (temp != null) {
            System.out.print(temp.data + (temp.next != null ? " <-> " : ""));
            temp = temp.next;
        }
        System.out.println();
    }
 
    // Traverse backward
    public void displayBackward() {
        Node temp = head;
        if (temp == null) {
            System.out.println("List is empty.");
            return;
        }
 
        // Go to the tail node
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
 
// Main class to test the DLL
public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
 
        dll.append(10);
        dll.append(20);
        dll.append(30);
 
        dll.displayForward();   // Output: 10 <-> 20 <-> 30
        dll.displayBackward();  // Output: 30 <-> 20 <-> 10
    }
}