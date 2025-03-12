package listaCircularAnimacion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JPanel {
	private ListaCircular lista;
    private Nodo actual;
    private Timer timer;
    private Color colorActual;

    public App() {
        lista = new ListaCircular();
        for (int i = 0; i < 10; i++) {
            lista.insertar();
        }
        actual = lista.getCabeza();
        colorActual = Color.RED;

        timer = new Timer(500, e -> {
            actual = actual.siguiente;
            colorActual = new Color((int)(Math.random() * 0x1000000));
            repaint();
        });
        timer.start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(colorActual);
        g.fillOval(actual.x - 10, actual.y - 10, 30, 30);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Animación Circular Dinámica");
        App panel = new App();
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);

        JButton addButton = new JButton("Agregar Nodo");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.lista.insertar();
            }
        });
        frame.add(addButton, BorderLayout.SOUTH);
        
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
