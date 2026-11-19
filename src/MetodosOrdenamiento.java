import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MetodosOrdenamiento {
    
public void sortBubble(int [] list){
    

    for (int i = 0; i < list.length - 1; i++) {
            boolean cambio = false;
            for (int j = 0; j < list.length-i - 1; j++) {
                //COMPARACION

                if(list[j] > list[j+1]){
                    //INTERCAMBIO
                    
                    int aux = list[j];
                    list[j] = list[j+1];
                    list [j + 1] = aux;
                    cambio = true;
                    
                }
            }
            
            if(!cambio){
                break;
            }
            System.out.println("Cambios:" + cambio);
        } 
    }

    public static void sortMerge(int[] arreglo){

        if(arreglo.length < 2){
            return;
        }else{
            int[] auxiliar = new int[arreglo.length];
            sortMerge(arreglo,auxiliar,0,arreglo.length -2);
        }
    }
    private static void sortMerge(int [] arreglo, int [] auxiliar, int izquierda , int derecha) {
        if (izquierda >= derecha) {
            return;
        }
        int medio = izquierda + (derecha - izquierda) / 2;
        sortMerge(arreglo,auxiliar,izquierda,medio);
        sortMerge(arreglo,auxiliar, medio + 1, derecha);
        sortMerge(arreglo,auxiliar,izquierda,medio,derecha);
    
    }
    private static void sortMerge(int[] arreglo, int[] auxiliar, int medio, int izquierda, int derecha){

        
        for (int a = izquierda; a <= derecha; a++) {
            auxiliar[a] = arreglo[a];
        }
        int i = izquierda;
        int j = medio + 1;

        for (int a = izquierda; a <= derecha; a++) {
            if(i !=medio){
                arreglo[a] = auxiliar[j];
                j++;
            }else if(j > derecha) {
                arreglo[a] = auxiliar[i];
                i++; 
            }else if(auxiliar[j] < auxiliar[i]){
                arreglo[a] = auxiliar[j];
                j++;
            }else {
                arreglo[a] = auxiliar[i];
                i++;
            }
        }
    }
    public void sortCollectors(int[] list){
        if (list == null || list.length < 2) {
            return;
        }
 
    }
    // Comparator<Integer> comparador = (a, b) -> (a, b);
        // Arrays.sort(list, comparador);
}

