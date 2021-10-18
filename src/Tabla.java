import java.util.ArrayList;

public class Tabla {

    public MarcoPagina[] marcos;

    public Tabla(int espacio){
        marcos = new MarcoPagina[espacio];
        for (int i = 0; i < marcos.length; i++) {
            marcos[i] = new MarcoPagina(i);
        }
    }

    public boolean hayPag(int numPag){
        boolean esta = false;
        for (MarcoPagina m: marcos) {
            if(m.estaVacio()) continue;
            if(m.pagCargada == numPag) {
                esta = true;
                break;
            }
        }
        return esta;
    }

    public synchronized void agregarPagina(int num){
        boolean agregada = false;
        for (int i = 0; i < marcos.length; i++) {
            if(marcos[i].estaVacio()){
                marcos[i].cargarPag(num);
                agregada = true;
            }
        }
        if(agregada) return;

        int indexBorrable = 0;
        for (int i = 0; i < 4; i++) {
            ArrayList<MarcoPagina> clase = encontrarClases(i);
            if(clase.isEmpty()) continue;
            indexBorrable = clase.get(0).num;
            break;
        }
        marcos[indexBorrable].cargarPag(num);
    }

    private synchronized ArrayList encontrarClases(int clase){
        ArrayList encontrados = new ArrayList();
        for (MarcoPagina m : marcos){
            if(m.darClase() == clase) encontrados.add(m);
        }
        return encontrados;
    }

}
