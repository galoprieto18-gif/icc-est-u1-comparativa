
import java.util.List;

public class Generador {
    
    // genera un listado de tamaño size 
    // con numeros aleatorios de 0-size
    public int[] generate(int size ) {
    
    if(size < 0){
        throw new IllegalArgumentException("El tamano no puede ser negativo: " + size);
    }
    if( size == 0){
        return new int[0];
    }
        int[] list = new int[size];
        for (int i = 0; i < size; i++) {
            list[i] = (int) (Math.random() * size);
        }
        return list;
    }
}


