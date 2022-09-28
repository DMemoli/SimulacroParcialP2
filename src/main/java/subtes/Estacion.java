package subtes;

public class Estacion {
    private String actual;
    private String siguiente;
    private String anterior;
    private String comentario;

    public String getAnterior() {
        return anterior;
    }

    public void setAnterior(String anterior) {
        this.anterior = anterior;
    }

    public Estacion() {

    }

    public Estacion(String actual, String comentario) {
        this.actual = actual;

        this.comentario = comentario;
    }

    public String getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(String siguiente) {
        this.siguiente = siguiente;
    }

    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String toString(){
        return "\nEstacion: "+actual+"\tComentario: "+comentario;
    }
}
