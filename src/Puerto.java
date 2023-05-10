import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Puerto {
    private Hub[] hubs;

    public Puerto(){
        hubs = new Hub[3];

        for (int i = 0; i < hubs.length; i++) {
            hubs[i] = new Hub();
        }
    }

    public void apilar(Contenedor c) {
        if (c != null) {
            int p = c.getPrioridad();
            for (int i = 0; i < hubs.length; i++) { //Se recorre los 3 HUBS
                if (p == 1 || p == 2) {
                    int col = p - 1;
                    for (int j = hubs[i].m.length - 1; j >= 0; j--) { // Con esto estaria en la matriz de contenedores del i hub
                        if (hubs[i].m[j][col] == null) {
                            hubs[i].m[j][col] = c;
                            return;
                        }
                    }
                } // Fin prioridad 1 y 2
                else {
                    for (int j = 2; j < hubs[i].m[0].length; j++) {
                        for (int k = hubs[i].m[j].length - 1; i >= 0; i--) {
                            if (hubs[i].m[k][j] == null) {
                                hubs[i].m[k][j] = c;
                                return;
                            }
                        }
                    }
                }
            } //Fin recorrido de 3 hubs

        }

    }

    public Contenedor desapilar(int col,int nhub) {
        nhub = nhub -1; // para "traducirlo"
        if ((col < 0  || col >= hubs[nhub].m[0].length) && ((nhub>=0 && nhub <3))) {
            return null;
        }

        else {
            for (int i = 0; i < hubs[nhub].m.length; i++) {
                if (hubs[nhub].m[i][col] != null) {
                    Contenedor aux = hubs[nhub].m[i][col];
                    hubs[nhub].m[i][col] = null;
                    return aux;
                }
            }
            return null;
        }



    }


    public String mostrar_puerto(){
        String s = new String();
        for (int i = 0; i < hubs.length; i++) {
            s+= hubs[i].toString();
        }
        return s;
    }

    public int contador(String pais){
        if (pais == null) return -1;
        int c = 0;
        for (int k = 0; k < hubs.length; k++) {
            for (int i = 0; i < hubs[k].m.length; i++) {
                for (int j = 0; j < hubs[k].m[i].length; j++) {
                    if (hubs[k].m[i][j] != null && pais.equals(hubs[k].m[i][j].getPais())){
                        c++;
                    }
                }
            }
        }


        return c;
    }

    public String mostrar_por_id(int id){
        boolean control = false;
        String s = new String();
        for (int k = 0; k < hubs.length; k++) {
            for (int i = 0; i < hubs[k].m.length; i++) {
                for (int j = 0; j < hubs[k].m[i].length; j++) {
                    if (hubs[k].m[i][j] != null && hubs[k].m[i][j].getId() == id){
                        s+=hubs[k].m[i][j].toString();
                        control = true; //Hemos encontrado el contenedor
                    }
                }
            }
        }
        if (!control){
            return "No se ha encontrado el contenedor";
        }
        return s;
    }
}
