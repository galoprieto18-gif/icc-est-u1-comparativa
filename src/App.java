import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
       
        long nanoTime = System.nanoTime(); // No es relacionado con la fecha
        long  currentTimeMillis = System.currentTimeMillis(); 
        System.out.println("nanoTime: " + nanoTime);
        System.out.println("currentTimeMillis: " + currentTimeMillis);

        Runnable funcion = () -> {
            System.out.println("Ejecutando tarea");
            System.out.println("Ejecutando tarea 2");

        // Callabe <T> x

        };

        //List<Integer> list = new ArrayList<>();
        //MetodosOrd mO = new MetodosOrd();
        // mO.burbuja(list); //Ejecucion directa de la funcion

        // Runnable burbujaOrden = () -> mO.burbuja(list);


        
        // System.out.println("Ejecucion de la funcion Runnable");
        // funcion.run();
    
        Generador g = new Generador();
        Benchmark b = new Benchmark();
        List<Integer> list = g.generate(100000);
        System.out.println(list);

        Results benGenList = b.medir(() -> g.generate(100000), "Generación de listado", "100000");
        
        System.out.println(benGenList);
        }     
}
