package subtes;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Vista {
   private Modelo m;
    private JButton boton;
    private JFrame f;
    private JTextField estacionActual, comentario;
    private JLabel etiquetaEst;
    public Vista(Modelo m) {
        this.m = m;
        m.primerEstacion();
        boton = new JButton("Avanzar");
        etiquetaEst = new JLabel("Estacion: ");
        estacionActual = new JTextField(m.getResultadoEst().getActual(), 15);
        comentario = new JTextField(m.getResultadoEst().getComentario(),40);

        f = new JFrame();
        f.getContentPane().setBackground(Color.red); // Establece el fondo del panel
        f.getContentPane().setLayout(new FlowLayout());

        f.getContentPane().add(etiquetaEst);
        f.getContentPane().add(estacionActual);
        f.getContentPane().add(comentario);
        f.getContentPane().add(boton);
        f.setTitle("Estaciones Subte B");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 100);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public void botonAvanzar(ActionListener av) {
        boton.addActionListener(av);
    }
    public void actualizar(){
        estacionActual.setText(m.estacionSiguiente());
        comentario.setText(m.getResultadoEst().getComentario());

    }
}