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
        int[] tipp1 = sixOfFortynineV1();
        endTime = System.nanoTime();
        for (int i : tipp1) {
          System.out.print(i+ " ");
        }
        System.out.println("\nTime elapsed: "+(endTime-startTime));

        System.out.println("Version 2:");
        startTime = System.nanoTime();
        int[] tipp2 = sixOfFortynineV2();
        endTime = System.nanoTime();
        for (int i : tipp2) {
            System.out.print(i+ " ");
        }
        System.out.println("\nTime elapsed: "+(endTime-startTime));
    }

    public static int[] sixOfFortynineV1() {
        Random random = new Random();
        int[] tipp = new int[6];
        tipp[0] = random.nextInt(6) + 1;
        int tmp = 0;
        for (int i = 1; i < tipp.length; i++) {

            do {
              tmp = random.nextInt(6) + 1;
            } while (checkForDoubles(tipp, i, tmp));
            tipp[i] = tmp;
        }
        return tipp;

    }

    public static int[] sixOfFortynineV2() {
        Random random = new Random();
        int[] tipp = new int[6];
        tipp[0] = random.nextInt(6) + 1;
        Arrays.sort(tipp);
        int tmp = 0;
        for (int i = 1; i < tipp.length; i++) {

            do {
                tmp = random.nextInt(6) + 1;
            } while (Arrays.binarySearch(tipp, tmp) > 0);
            tipp[0] = tmp;
            Arrays.sort(tipp);
        }
        return tipp;

    }

    private static boolean checkForDoubles(int[] tipp, int i, int tmp) {
        int j = 0;
        while (tipp[j] != tmp && j < i) {
            j++;
        }
        return tipp[j] == tmp;

    }
}
