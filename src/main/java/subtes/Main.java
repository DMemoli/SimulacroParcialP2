package subtes;

import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        String ip = "localhost";
        String bd = "subte_b";
        Modelo m = new Modelo(ip, bd);



        Vista v = new Vista(m);

        Controlador c = new Controlador(m, v);
        c.ejecutar();;
    }
}