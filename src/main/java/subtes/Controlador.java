package subtes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador {

    private Modelo m;
    private Vista v;

    public Controlador(Modelo m, Vista v) {
        this.m = m;
        this.v = v;
    }

    public void ejecutar() {

        v.botonAvanzar(new AvanzarListener());

    }

    private class AvanzarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            v.actualizar();
        }
    }
}