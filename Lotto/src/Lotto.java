import java.util.Random;

/**
 * Created by markus on 20.12.17.
 */
public class Lotto {
    public static void main(String[] args) {
        int[] tipp = sixOfFortynine();
        for (int i : tipp) {
          System.out.print(i+ " ");
        }
    }

    public static int[] sixOfFortynine() {
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

    private static boolean checkForDoubles(int[] tipp, int i, int tmp) {
        int j = 0;
        while (tipp[j] != tmp && j < i) {
            j++;
        }
        return tipp[j] == tmp;

    }
}
