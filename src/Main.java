import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Main {



    public static void main(String[] args) {
        String rutaArchivo = "referencias.txt";
        int numMarcosPag = 0;
        int numPags = 0;
        int numRefs = 0;
        ArrayList referencias = new ArrayList();
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





        System.out.println("Número de marcos de página: " + numMarcosPag);
        System.out.println("Número de páginas del proceso: " + numPags);
        System.out.println("Número de referencias en el archivo: " + numRefs);
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Referencias: " + referencias);


    }

}
