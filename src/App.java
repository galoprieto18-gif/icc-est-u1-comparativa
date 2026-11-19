import java.util.ArrayList;
import java.util.List;

import javax.swing.event.InternalFrameAdapter;

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

        
        Generador g = new Generador();
        Benchmark b = new Benchmark();
        MetodosOrdenamiento m = new MetodosOrdenamiento();

        // LOS 3 ARREGLOS BASE 
        // 10000
        int [] list1 = g.generate(10000);
        //50000
        int [] list2 = g.generate(50000);

        //100000
        int [] list3 = g.generate(100000);

       List<int []> listas = List.of(list1, list2, list3);

       List<List> resultados = new ArrayList<>();
       

       ///COPIAS
        int[] list1c1 = list1.clone();
        int[] list1c2 = list2.clone();
        int[] list1c3 = list3.clone();

        int[] list2c1 = list1.clone();
        int[] list2c2 = list2.clone();
        int[] list2c3 = list3.clone();

        int[] list3c1 = list1.clone();
        int[] list3c2= list2.clone();
        int[] list3c3 = list3.clone();


        // Método Bubble
       
        Results resultaM1S1 = Benchmark.medir(() 
        ->  m.sortBubble(list1c1), "Burbuja", "10.000");
      
        Results resultaM1S2 = Benchmark.medir(() 
        -> m.sortBubble(list1c2), "Burbuja", "50.000");
        Results resultaM1S3 = Benchmark.medir(() 
        -> m.sortBubble(list1c3), "Burbuja", "100.000");

         // Método Merge
         Results resultaM2S1 = Benchmark.medir(() 
        ->  m.sortMerge(list2c1), "MergeSort", "10.000");
      
        Results resultaM2S2 = Benchmark.medir(() 
        -> m.sortMerge(list2c2), "MergeSort", "50.000");
        Results resultaM2S3 = Benchmark.medir(() 
        -> m.sortMerge(list2c3), "MergeSort", "100.000");

        // Método Collectors
        Results resultaM3S1 = Benchmark.medir(() 
        ->  m.sortCollectors(list3c1), "Collectors", "10.000");
        Results resultaM3S2 = Benchmark.medir(() 
        -> m.sortCollectors(list3c2), "Collectors", "50.000");
        Results resultaM3S3 = Benchmark.medir(() 
        -> m.sortCollectors(list3c3), "Collectors", "100.000");


        //Results benGenList = b.medir(() -> g.generate(100000), "Generación de listado", "100000");
        
        ///System.out.println(benGenList);
        }     
}
