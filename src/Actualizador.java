

public class Actualizador extends Thread{
	
	private Tabla tabla;
	
    //El segundo thread se encargará de ejecutar el algoritmo de actualización de los bits R y M con base en el
    //algoritmo de reemplazo presentado por Tanenbaum. Este thread debe correr cada 20 milisegundos.
    public Actualizador(Tabla t) {
        tabla = t;
    }
    
    public int descubrirReemplazo() {    	
    	int tamaño=tabla.marcos.length;
    	int i=0;
    	int opcionado = 0;
    	int tope = 0;
    	while (i<tamaño) {
    		MarcoPagina marco=tabla.marcos[i];
    		int clase = marco.darClase();
    		if (clase==0) {
    			opcionado=marco.pagCargada;
    			break;
    		}
    		else if (clase==1) {
    			opcionado=marco.pagCargada;
    			tope=1;
    		}
    		else if (clase==2 && (tope==0 || tope>1)) {
    			opcionado=marco.pagCargada;
    			tope=2;
    		}
    		else if (clase==2 && (tope==0 || (tope>2))) {
    			opcionado=marco.pagCargada;
    			tope=3;
    		}
    	}
    	return opcionado;
    }
    
    public void actualizar() {
    	int tamaño=tabla.marcos.length;
    	int i=0;
    	while (i<tamaño) {
    		MarcoPagina marco=tabla.marcos[i];
    		int clase = marco.darClase();
    		if (clase==2 || clase==3) {
    			marco.R=false;
    		}
    	}
    }

    public void run(){

    	
        try {
            sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actualizar();
    }

}
