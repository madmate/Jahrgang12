import java.util.Scanner;

/**
 * Created by markus on 13.09.17.
 */
public class BruchUmwandeln {
    public static void main(String[] args) {
        int g = eingabe("Ganzzahl");
        int z = eingabe("Zaehler");
        int n = eingabe("Nenner");
        z = umwandeln(g, z, n);
        ausgabe(z, n);
    }

    public static int eingabe(String s) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(s+ " eingeben: ");
        int x = Integer.parseInt(scanner.next());
        System.out.println();
        return x;
    }

    public static int umwandeln(int g, int z, int n) {
        return g*n+z;
    }

    public static void ausgabe(int z, int n) {
        System.out.println(z);
        System.out.println("---");
        System.out.println(n);
    }
}
