import java.util.Random;

public class Helper {

    public static int[] randomArray(int n, int lastBound) {
        return randomArray(n, 0, lastBound);
    }

    public static int[] randomArray(int n, int firstBound, int lastBound) {
        Random random = new Random();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(lastBound - firstBound) + firstBound;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = randomArray(10, 4);
        for (int x : arr) {
            System.out.println(x);
        }
    }
}
