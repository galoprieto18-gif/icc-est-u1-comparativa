public class Benchmark {
    
    // Recibe la acción como Runnable (se envía con una lambda)
    public static Results medir(Runnable accion, String nombre, int sample) {

        if (accion == null) {
            throw new IllegalArgumentException(" La acción a medir no puede ser nulo a " + nombre + ".");
        }

        long tiempoActual;

        long tiempoFinal;

        // tiempo actual
        tiempoActual = System.nanoTime();
        // accion
        accion.run();
        // tiempo final
        tiempoFinal = System.nanoTime();

        if (tiempoFinal < tiempoActual) {
            throw new IllegalStateException("Tiempo final invalido al medir '" + nombre + "' con sample " + sample + ".");
        }

        return new Results(nombre, (tiempoFinal - tiempoActual), sample);
    }
}


