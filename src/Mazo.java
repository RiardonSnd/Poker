public class Mazo {
    private Carta[] cartas;
    private int numCartas;

    public Mazo(int numBarajas) {
        numCartas = 52*numBarajas;
        cartas = new Carta[numCartas];
        int counter = 0;
        for (int i = 0; i < numBarajas; i++) {
            for (int p = 1; p <= 13; p++) {
                for (int n = 0; n < Carta.PALOS.length; n++) {
                    cartas[counter] = new Carta(p, Carta.PALOS[n]);
                    counter++;
                }
            }
        }
    }

    public void barajar() {
        for (int i = 0; i < cartas.length; i++) {
            int n1 = (int) (Math.random() * cartas.length);
            int n2 = (int) (Math.random() * cartas.length);
            Carta temp = cartas[n1];
            cartas[n1] = cartas[n2];
            cartas[n2] = temp;
        }
    }

    public Carta extraerCarta() {
        Carta carta = cartas[numCartas - 1];
        numCartas--;
        return carta;
    }

    @Override
    public String toString() {
        String s = "";
        boolean first = true;
        for (int i = 0; i <= 3; i++) {
            for (int p = 0; p < numCartas; p++) {
                if (cartas[p].getPalo().equals(Carta.PALOS[i])) {
                    if (first) {
                        s += cartas[p];
                        first = false;
                    } else {
                        s += ", " + cartas[p];
                    }
                }
            }
            s += "\n";
            first = true;
        }
        return s;
    }
}
