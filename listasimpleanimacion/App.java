package listasimpleanimacion;
import javax.swing.*;
import java.awt.*;

public class App extends JPanel {
	private ListaSimple lista;
    private Nodo actual;
    private Timer timer;

    public App() {
        lista = new ListaSimple();
        generarTrayectoria(100, 100, 10, 50);
        actual = lista.getCabeza();

        timer = new Timer(200, e -> {
            if (actual.siguiente != null) {
                actual = actual.siguiente;
                repaint();
            }
        });
        timer.start();
    }

    public void generarTrayectoria(int startX, int startY, int pasos, int separacion) {
        for (int i = 0; i < pasos; i++) {
            lista.insertar(startX + i * separacion, startY);
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(actual.x - 10, actual.y - 10, 20, 20);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Animación Lista Simple");
        App panel = new App();
        frame.add(panel);
        frame.setSize(800, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
