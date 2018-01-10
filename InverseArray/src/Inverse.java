public class Inverse {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        for (int x : arr) System.out.print(x + " ");
        System.out.println();
        int tmp;
        int lastIndex = arr.length - 1;

        for (int i = 0; i < arr.length / 2; i++) {
            tmp = arr[i];
            arr[i] = arr[lastIndex - i];
            arr[lastIndex - i] = tmp;
        }
        for (int x : arr) System.out.print(x + " ");
    }
}
