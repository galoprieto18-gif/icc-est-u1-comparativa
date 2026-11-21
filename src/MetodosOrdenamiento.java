import java.util.Arrays;
import java.util.Comparator;

public class MetodosOrdenamiento {

    // V1: Método Bubble Sort
    public void sortBubble(int[] list) {
        if (list == null || list.length < 2) {
            return;
        }

        for (int i = 0; i < list.length - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < list.length - i - 1; j++) {
                if (list[j] > list[j + 1]) {
                    int aux = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = aux;
                    swap = true;
                }
            }

            if (!swap) {
                break;
            }
        }
    }

    // V2: Merge Sort (el arreglo auxiliar se reserva dentro del método,
    // por eso esa reserva forma parte del tiempo medido)
    public void sortMerge(int[] arreglo) {
        if (arreglo == null || arreglo.length < 2) {
            return;
        }
        int[] auxiliar = new int[arreglo.length];
        sortMerge(arreglo, auxiliar, 0, arreglo.length - 1);
    }

    private void sortMerge(int[] arreglo, int[] auxiliar, int izquierda, int derecha) {
        if (izquierda >= derecha) {
            return;
        }
        int medio = izquierda + (derecha - izquierda) / 2;
        sortMerge(arreglo, auxiliar, izquierda, medio);
        sortMerge(arreglo, auxiliar, medio + 1, derecha);
        merge(arreglo, auxiliar, izquierda, medio, derecha);
    }

    private void merge(int[] arreglo, int[] auxiliar, int izquierda, int medio, int derecha) {
        for (int a = izquierda; a <= derecha; a++) {
            auxiliar[a] = arreglo[a];
        }

        int i = izquierda;
        int j = medio + 1;

        for (int a = izquierda; a <= derecha; a++) {
            if (i > medio) {
                arreglo[a] = auxiliar[j];
                j++;
            } else if (j > derecha) {
                arreglo[a] = auxiliar[i];
                i++;
            } else if (auxiliar[j] < auxiliar[i]) {
                arreglo[a] = auxiliar[j];
                j++;
            } else {
                arreglo[a] = auxiliar[i];
                i++;
            }
        }
    }

    // V3: Método collectors sobre int[] (sin conversiones dentro del método)
    public void sortArrays(int[] list) {
        if (list == null || list.length < 2) {
            return;
        }
        Arrays.sort(list);
    }

    // V4: Arrays.sort sobre Integer[] con Comparator (lambda).
    // El Integer[] se prepara ANTES de medir.
    public void sortComparator(Integer[] list) {
        if (list == null || list.length < 2) {
            return;
        }

        // Comparador como lambda (orden ascendente numérico).
        Comparator<Integer> comparacion = (a, b) -> Integer.compare(a, b);

        Arrays.sort(list, comparacion);
    }
}
