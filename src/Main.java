import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        Mazo mazo = new Mazo(2);
        mazo.barajar();

        Jugador p1 = new Jugador("Flynn");
        for (int i = 1; i <= 2; i++) {
            p1.repartirCarta(mazo.extraerCarta());
        }

        while (!gameOver) {
            System.out.println(p1);
            System.out.println("Puntuación: " + p1.getPuntuacion());
            System.out.println("¿Otra carta? (S/N)");
            String respuesta = scanner.nextLine().toUpperCase();
            if (respuesta.equals("N")) {
                System.out.println("Te plantas.");
                System.out.println("Puntuación final: " + p1.getPuntuacion());
                gameOver = true;
            } else if (respuesta.equals("S")) {
                p1.repartirCarta(mazo.extraerCarta());
            }
            if (p1.getPuntuacion() > 21) {
                System.out.println(p1);
                System.out.println("Puntuación final: " + p1.getPuntuacion());
                System.out.println("Has perdido.");
                gameOver = true;
            }
        }
    }
}