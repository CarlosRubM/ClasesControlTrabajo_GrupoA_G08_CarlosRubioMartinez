import java.io.Serializable;

public class Contenedor {
    //Atributos
    private final int id;
    private int peso, prioridad;
    private String contenido, pais, emisor, receptor;
    private boolean inspeccionado;

    //G/S
    public int getId() {
        return id;
    }

    public void setPeso(int peso) {
        if (peso > 0) this.peso = peso;
    }

    public void setPrioridad(int prioridad) {
        if (prioridad >= 1 && prioridad <= 3) this.prioridad = prioridad;
    }

    public boolean isInspeccionado() {
        return inspeccionado;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public String getPais() {
        return pais;
    }

    //Constructores
    public Contenedor(int id) {
        if (id < 0) id = -id;
        this.id = id;
        this.prioridad = 3;
    }

    public Contenedor(int id, int peso, int prioridad, String contenido, String pais, String emisor, String receptor) {
        this(id);
        this.setPeso(peso);
        this.contenido = contenido;
        this.setPrioridad(prioridad);
        this.pais = pais;
        this.emisor = emisor;
        this.receptor = receptor;

    }

    public String toString() {
        String s = new String();
        s += "ID: " + this.id + "\n";
        s+= "Peso: " + this.peso + "\n";
        s+= "Prioridad: " + this.prioridad + "\n";
        s+= "Contenido: " + this.contenido + "\n";
        s+= "Pais: " + this.pais + "\n";
        s+= "Emisor: " + this.emisor + "\n";
        s+= "Receptor: " + this.receptor + "\n";
        if (inspeccionado) s += "Esta inspeccionado\n";
        else s += "No esta inspeccionado\n";
        return s;
    }
}
