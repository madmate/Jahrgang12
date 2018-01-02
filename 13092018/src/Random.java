/**
 * Created by markus on 13.09.17.
 */
public class Random {

    public static int randomInt(int sv, int ev) {
        java.util.Random random = new java.util.Random();
        return random.nextInt(ev-sv+1)+sv;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 50; i++) {
            System.out.println(randomInt(5, 10));
        }
    }
}
