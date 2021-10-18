import java.util.ArrayList;

public class AdminTabla extends Thread{

    private int fallasTotales;

    public int numPags;

    public Tabla t;

    private ArrayList<String> referencias;

    //El primer thread se encargará de ir actualizando el estado de la tabla de páginas y los marcos de página en
    //memoria real de acuerdo con las referencias generadas por el proceso. Este thread debe cargar una nueva
    //referencia cada milisegundo. En un sistema real, esta operación ocurriría de forma aleatoria, cada vez que un
    //proceso genera una nueva referencia.

    public AdminTabla(Tabla t, int numPags, ArrayList referencias) {
        this.numPags = numPags;
        this.t = t ;
        this.referencias = referencias;
        fallasTotales = 0;
    }


    private void ejecutarReferencia(String ref){
        int numPag;
        String instruccion;
        String[] aux = ref.split(",");
        numPag = Integer.parseInt(aux[0]);
        instruccion = aux[1];

        if(!t.hayPag(numPag)){

        }

    }

    public void run(){
        for (String ref: referencias) {
            ejecutarReferencia(ref);
        }
    }

}
