import java.util.Arrays;
import java.util.Random;

/**
 * Created by markus on 20.12.17.
 */
public class Lotto {
    public static void main(String[] args) {
        long startTime;
        long endTime;

        System.out.println("Version 1:");
        startTime = System.nanoTime();
        int[] tip1 = sixOfFortynineV1();
        endTime = System.nanoTime();
        for (int i : tip1) {
          System.out.print(i+ " ");
        }
        System.out.println("\nTime elapsed: "+(endTime-startTime));

        System.out.println("Version 2:");
        startTime = System.nanoTime();
        int[] tip2 = sixOfFortynineV2();
        endTime = System.nanoTime();
        for (int i : tip2) {
            System.out.print(i+ " ");
        }
        System.out.println("\nTime elapsed: "+(endTime-startTime));

        System.out.println("Version 3:");
        startTime = System.nanoTime();
        int[] tip3 = sixOfFortynineV3();
        endTime = System.nanoTime();
        for (int i : tip3) {
            System.out.print(i+ " ");
        }
        System.out.println("\nTime elapsed: "+(endTime-startTime));

        System.out.println("Version 4:");
        startTime = System.nanoTime();
        int[] tip4 = sixOfFortynineV3();
        endTime = System.nanoTime();
        for (int i : tip4) {
            System.out.print(i + " ");
        }
        System.out.println("\nTime elapsed: " + (endTime - startTime));
    }
    //Version with checking all elements for doubles
    public static int[] sixOfFortynineV1() {
        Random random = new Random();
        int[] tip = new int[6];
        int tmp;
        for (int i = 0; i < tip.length; i++) {
            do {
                tmp = random.nextInt(49) + 1;
            } while (checkForDoubles(tip, i, tmp));
            tip[i] = tmp;
        }
        return tip;

    }
    //Version with BinarySearch and sorted return
    public static int[] sixOfFortynineV2() {
        Random random = new Random();
        int[] tip = new int[6];
        int tmp;
        for (int i = 0; i < tip.length; i++) {
            do {
                tmp = random.nextInt(49) + 1;
            } while (Arrays.binarySearch(tip, tmp) > 0);
            tip[0] = tmp;
            Arrays.sort(tip);
        }
        return tip;

    }
    //Version with BinarySearch and unsorted return
    public static int[] sixOfFortynineV3() {
        Random random = new Random();
        int[] tip = new int[6];
        int[] sortedTip = new int[6];
        int tmp;
        for (int i = 0; i < tip.length; i++) {
            do {
                tmp = random.nextInt(49) + 1;
            } while (Arrays.binarySearch(sortedTip, tmp) > 0);
            tip[i] = tmp;
            sortedTip[0] = tmp;
            Arrays.sort(sortedTip);
        }
        return tip;

    }

    public static int[] sixOfFortynineV4() {
        Random random = new Random();
        int[] tip = new int[6];
        for (int i = 0; i < 6; i++) {
            tip[i] = random.nextInt(6) + 1;
            for (int j = 0; j < i; j++) {
                if (tip[i] == tip[j]) {
                    i = i - 1;
                }
            }
        }
        return tip;
    }


    private static boolean checkForDoubles(int[] tip, int i, int tmp) {
        int j = 0;
        while (tip[j] != tmp && j < i) {
            j++;
        }
        return tip[j] == tmp;

    }
}
