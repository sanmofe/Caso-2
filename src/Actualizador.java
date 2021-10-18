

public class Actualizador extends Thread{
	
	private Tabla tabla;
	
    //El segundo thread se encargará de ejecutar el algoritmo de actualización de los bits R y M con base en el
    //algoritmo de reemplazo presentado por Tanenbaum. Este thread debe correr cada 20 milisegundos.
    public Actualizador(Tabla t) {
        tabla = t;
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
