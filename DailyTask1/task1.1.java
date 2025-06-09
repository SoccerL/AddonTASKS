import java.util.ArrayList;
 
public class ArrayOperations {
 
    public static void displayArray(ArrayList<Integer> arr) {
        System.out.println("Current Array: " + arr);
    }
 
    // Insertion
    public static void insertElement(ArrayList<Integer> arr, int element, int position) {
        if (position < 0 || position > arr.size()) {
            System.out.println("Invalid position for insertion.");
        } else {
            arr.add(position, element);
            System.out.println("Inserted " + element + " at position " + position);
        }
    }
 
    // Updation
    public static void updateElement(ArrayList<Integer> arr, int position, int newValue) {
        if (position < 0 || position >= arr.size()) {
            System.out.println("Invalid position for update.");
        } else {
            int oldValue = arr.get(position);
            arr.set(position, newValue);
            System.out.println("Updated position " + position + " from " + oldValue + " to " + newValue);
        }
    }
 
    // Deletion
    public static void deleteElement(ArrayList<Integer> arr, int position) {
        if (position < 0 || position >= arr.size()) {
            System.out.println("Invalid position for deletion.");
        } else {
            int removed = arr.remove(position);
            System.out.println("Deleted element " + removed + " from position " + position);
        }
    }
 
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(40);
        arr.add(50);
 
        displayArray(arr);
 
        insertElement(arr, 99, 2);
        displayArray(arr);
 
        updateElement(arr, 3, 77);
        displayArray(arr);
 
        deleteElement(arr, 1);
        displayArray(arr);
    }
}