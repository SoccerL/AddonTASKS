public class RecursiveFibonacci {
    public static int fibonacci(int n) {
        if (n == 0)
            return 0;  // Base case
        if (n == 1)
            return 1;  // Base case
        return fibonacci(n - 1) + fibonacci(n - 2);  // Recursive step
    }
 
    public static void main(String[] args) {
        int terms = 7;
        System.out.print("Fibonacci series up to " + terms + " terms: ");
        for (int i = 0; i < terms; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
}