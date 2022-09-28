package subtes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class Modelo {
    private String jdbcDriver;
    private String dbName;
    private String urlRoot;

    private Estacion resultadoEst;
    //private ArrayList<Estacion> resultado;
    private ActionListener listener;

    public Modelo(String url, String dbName) {
        jdbcDriver = "com.mysql.cj.jdbc.Driver";
        urlRoot = "jdbc:mysql://" + url + "/";
        this.dbName = dbName;
        listener = null;
        resultadoEst = new Estacion();
        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException e) {
           reportException(e.getMessage());
        }
    }

    public void primerEstacion(){

        try {
            Connection con = DriverManager.getConnection(urlRoot + dbName, "", "");
            Statement stmt = con.createStatement();
            stmt.execute("SELECT * FROM subte_b.estaciones LIMIT 1;");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                this.resultadoEst.setActual(rs.getString(1));
                this.resultadoEst.setSiguiente(rs.getString(2));
                this.resultadoEst.setAnterior(rs.getString(3));
                this.resultadoEst.setComentario(rs.getString(4));
                System.out.println(resultadoEst.getAnterior());            }
            con.close();

        } catch (SQLException e) {
            reportException(e.getMessage());
        }
    }
    public void estacionSiguiente(){

        try {
            Connection con = DriverManager.getConnection(urlRoot + dbName, "", "");
            Statement stmt = con.createStatement();
            stmt.execute("SELECT * FROM subte_b.estaciones WHERE Actual=\"" + resultadoEst.getSiguiente() + "\";");

            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                this.resultadoEst.setActual(rs.getString(1));
                this.resultadoEst.setSiguiente(rs.getString(2));
                this.resultadoEst.setAnterior(rs.getString(3));
                this.resultadoEst.setComentario(rs.getString(4));
                if(resultadoEst.getSiguiente().equalsIgnoreCase("No hay")) {
                resultadoEst.setVuelve(true);
                }
                ;
            }
            con.close();

        } catch (SQLException e) {
            reportException(e.getMessage());
        }


    }
    public void estacionAnterior(){

        try {
            Connection con = DriverManager.getConnection(urlRoot + dbName, "", "");
            Statement stmt = con.createStatement();
            stmt.execute("SELECT * FROM subte_b.estaciones WHERE Actual=\"" + resultadoEst.getAnterior() + "\";");

            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                this.resultadoEst.setActual(rs.getString(1));
                this.resultadoEst.setSiguiente(rs.getString(2));
                this.resultadoEst.setAnterior(rs.getString(3));
                this.resultadoEst.setComentario(rs.getString(4));
                if(resultadoEst.getAnterior().equalsIgnoreCase("No hay")) {
                    resultadoEst.setVuelve(false);
                }

                ;
            }
            con.close();

        } catch (SQLException e) {
            reportException(e.getMessage());
        }


    }

    public Estacion getResultadoEst(){
        return resultadoEst;
    }
    private void reportException(String exception) {
        if (listener != null) {
            ActionEvent evt = new ActionEvent(this, 0, exception);
            listener.actionPerformed(evt);
        }
    }

}
