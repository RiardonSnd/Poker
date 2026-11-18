import java.util.Arrays;

public class Jugador {
    private String name;
    private Carta[] mano;
    private int numCartas;

    public Jugador(String name) {
        this.name = name;
        numCartas = 0;
        mano = new Carta[20];
        for (int i = 0; i < mano.length; i++) {
            mano[i] = null;
        }
    }

    public void repartirCarta(Carta carta) {
        mano[numCartas] = carta;
        numCartas++;
    }

    @Override
    public String toString() {
        String s = name + ": ";
        Boolean first = true;
        for (int i = 0; i < numCartas; i++) {
            if (first) {
                s += mano[i];
                first = false;
            } else {
                s += ", " + mano[i];
            }
        }
        s += ".";
        return s;
    }

    public int getPuntuacion() {
        int puntuacion = 0;
        for (int i = 0; i < numCartas; i++) {
            int numero = mano[i].getNumero();
            if (numero >= 2 && numero <= 10) {
                puntuacion += numero;
            } else if (numero >= 11) {
                puntuacion += 10;
            } else {
                puntuacion += 11;
                if (puntuacion > 21) {
                    puntuacion -= 10;
                }
            }
        }
        return puntuacion;
    }
}
