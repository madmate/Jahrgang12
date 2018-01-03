import java.util.Arrays;
import java.util.Random;

/**
 * Created by markus on 20.12.17.
 */
public class Lotto {
    public static void main(String[] args) {
        System.out.println("Version 1:");
        int[] tipp1 = sixOfFortynineV1();
        for (int i : tipp1) {
          System.out.print(i+ " ");
        }

        System.out.println("\nVersion 2:");
        int[] tipp2 = sixOfFortynineV2();
        for (int i : tipp2) {
            System.out.print(i+ " ");
        }
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
