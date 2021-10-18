import java.util.ArrayList;

public class Actualizador extends Thread{
	
	private ArrayList<String> referencias;
	
	public Actualizador (ArrayList<String> referencias) {
		this.referencias=referencias;
	}
    private Tabla tabla;

    //El segundo thread se encargará de ejecutar el algoritmo de actualización de los bits R y M con base en el
    //algoritmo de reemplazo presentado por Tanenbaum. Este thread debe correr cada 20 milisegundos.
    public Actualizador(Tabla t) {
        tabla = t;
    }

    public void run(){



        try {
            sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
