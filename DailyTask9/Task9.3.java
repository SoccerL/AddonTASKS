package Day_9;
import java.util.Arrays;
import java.util.Scanner;
public class Task_4 {
	public int findRank(int target) {
		int[] arr = {4, 6, 10, 12, 18, 18, 20, 20, 30, 45};
		int low = 0;
        int high = arr.length;
        Arrays.sort(arr);
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
	public static void main(String[] args) {
		Task_4 ts = new Task_4();
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Target:");
		int target = sc.nextInt();
        System.out.println("Rank of " + target + " is: " + ts.findRank(target));
        sc.close();
	}
}
