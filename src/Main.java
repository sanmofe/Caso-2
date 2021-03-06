import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Main {

	private static Actualizador actualizador;

    public static void main(String[] args) {
        String rutaArchivo = "referencias.txt";
        int numMarcosPag = 0;
        int numPags = 0;
        int numRefs = 0;
        ArrayList<String> referencias = new ArrayList<String>();
        try(BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))){

            //La primera línea es el número de marcos de Página
            numMarcosPag = Integer.parseInt(br.readLine());
            //Segunda línea, número de páginas del proceso
            numPags = Integer.parseInt(br.readLine());
            //Tercera línea, número de referencias en el archivo
            numRefs = Integer.parseInt(br.readLine());
            //Todas las demás líneas son referencias
            String linea = br.readLine();

            while(linea != null){
                referencias.add(linea);
                linea = br.readLine();
            }

        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("IMPORTANTE");
            System.out.println("Si lo anterior es un FileNotFoundException, no olvides actualizar la ruta del archivo en el código, o renombrar el archivo a 'referencias'");
        }

        Tabla t = new Tabla(numMarcosPag);
        for (MarcoPagina m :
             t.marcos) {
            System.out.println(m.pagCargada);
        }
        AdminTabla at = new AdminTabla(t, numPags, referencias);
        actualizador = new Actualizador (t);
        at.start();
        actualizador.start();
        
        

    }

}
