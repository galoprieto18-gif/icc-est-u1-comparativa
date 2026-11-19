public class Algoritmos {
    
public static void BubbleSort(int [] arreglo){
    
    int n = arreglo.length;
    for (int i = 0; i < n ; i++) {
            System.out.println( "Pasada:" + i);
            boolean cambio = false;
            for (int j = 1; j < n -i; j++) {
                //COMPARACION

                if(arreglo[j-1] > arreglo[j]){
                    //INTERCAMBIO
                    cambio = true;
                    int aux = arreglo[j-1];
                    arreglo[j-1] = arreglo[j];
                    arreglo[j] = aux;
                    
                }
            
            if(!cambio){
                break;
            }
            System.out.println("Cambios:" + cambio);
        } 
    }
}
    public static void mergeSort(int[] arreglo){

        if(arreglo.length < 2){
            return;
        }else{
            int[] auxiliar = new int[arreglo.length];
            mergeSort(arreglo,auxiliar,0,arreglo.length -2);
        }
    }
    private static void mergeSort(int [] arreglo, int [] auxiliar, int izquierda , int derecha) {
        if (izquierda >= derecha) {
            return;
        }
        int medio = izquierda + (derecha - izquierda) / 2;
        mergeSort(arreglo,auxiliar,izquierda,medio);
        mergeSort(arreglo,auxiliar, medio + 1, derecha);
        mergeSort(arreglo,auxiliar,izquierda,medio,derecha);
    
    }
    private static void mergeSort(int[] arreglo, int[] auxiliar, int medio, int izquierda, int derecha){

        
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
}
