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
        tipp[0] = random.nextInt(49) + 1;
        int tmp = 0;
        for (int i = 1; i < tipp.length; i++) {

            for (int j = 0; j < i; j++) {
              tmp = random.nextInt(49) + 1;
              if (tmp == tipp[j]) break;
            }
            tipp[i] = tmp;
        }
        return tipp;

    }
}
