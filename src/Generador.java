
import java.util.List;

public class Generador {
    
    // genera un listado de tamaño size 
    // con numeros aleatorios de 0-size
    public static int[] generate(int size ) {

        int[] list = new int[size];
        for (int i = 0; i < size; i++) {
            list[i] = (int) (Math.random() * size);
        }

        return list;
    }
}
