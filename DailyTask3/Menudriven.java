import java.util.Scanner;

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
        if (position == 0) {
            head = head.next;
            return;
        }
        Node temp = head;
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
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Linked List Menu ===");
            System.out.println("1. Add Node");
            System.out.println("2. Insert Node at Position");
            System.out.println("3. Delete Node at Position");
            System.out.println("4. Reverse List");
            System.out.println("5. Print List");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to add: ");
                    int dataToAdd = scanner.nextInt();
                    list.add(dataToAdd);
                    break;
                case 2:
                    System.out.print("Enter data to insert: ");
                    int dataToInsert = scanner.nextInt();
                    System.out.print("Enter position: ");
                    int insertPosition = scanner.nextInt();
                    list.insertAtPosition(dataToInsert, insertPosition);
                    break;
                case 3:
                    System.out.print("Enter position to delete: ");
                    int deletePosition = scanner.nextInt();
                    list.deleteAtPosition(deletePosition);
                    break;
                case 4:
                    list.reverse();
                    System.out.println("List reversed.");
                    break;
                case 5:
                    System.out.println("Current List:");
                    list.printList();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 6);

        scanner.close();
    }
}
