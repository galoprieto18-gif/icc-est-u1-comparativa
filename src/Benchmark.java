public class Benchmark {
    
    public static Results medir(Runnable accion, String nombre, String sample) {

        long tiempoActual;
        
        long tiempoFinal;
        
        System.out.println("Función" + nombre);
        // tiempo actual
        tiempoActual  = System.nanoTime();

        // accion 
        accion.run();
        // tiempo final
        tiempoFinal = System.nanoTime();

        Results results = new Results(nombre, (tiempoFinal- tiempoActual), sample);
        // retornar el tiempo de duración

        return results;
    }

}
