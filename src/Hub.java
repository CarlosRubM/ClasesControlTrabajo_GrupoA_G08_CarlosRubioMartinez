import java.io.Serializable;

public class Hub  {
    protected Contenedor[][] m;

    public Hub() {
        this.m = new Contenedor[10][12];
        //filas = m.length
        //Columnas de la fila i = m[i].length
    }

    public Contenedor[][] getM() {
        return m;
    }

    public void setContenedor() {
        if (m != null) {
            this.m = m;
        }
    }

    public String toString() {
        String s = new String();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == null) {
                    s += "[N]";
                } else {
                    s += "[" + m[i][j].getId() + "]";
                }
            }
            s += "\n";
        }
        s += "\n";
        return s;

    }
}
