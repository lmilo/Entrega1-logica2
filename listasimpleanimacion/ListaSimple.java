package listasimpleanimacion;

public class ListaSimple {
	private Nodo cabeza = null;
    private Nodo cola = null;

    public void insertar(int x, int y) {
        Nodo nuevo = new Nodo(x, y);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
        }
    }
    public Nodo getCabeza() {
        return cabeza;
    }
}
