package listaCircularAnimacion;
import java.util.Random;

public class ListaCircular {
	private Nodo cabeza = null;
    private Nodo cola = null;
    private Random rand = new Random();

    public void insertar() {
        int x = rand.nextInt(600) + 100;
        int y = rand.nextInt(400) + 100;
        Nodo nuevo = new Nodo(x, y);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            cabeza.siguiente = cabeza;
        } else {
            cola.siguiente = nuevo;
            nuevo.siguiente = cabeza;
            cola = nuevo;
        }
    }

    public Nodo getCabeza() {
        return cabeza;
    }
}
