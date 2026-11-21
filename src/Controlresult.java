import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controlresult {

    private List<Results> results = new ArrayList<>();

    public void agregar(Results r) {
        if (r != null) {
            results.add(r);
        }
    }

    public int cantidad() {
        return results.size();
    }

    public Integer[] convertir(int[] arr) {
        if (arr == null) {
            return new Integer[0];
        }
        Integer[] nuevo = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nuevo[i] = arr[i];
        }
        return nuevo;
    }

    public int[] convertir(Integer[] arr) {
        if (arr == null) {
            return new int[0];
        }
        int[] nuevo = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nuevo[i] = arr[i];
        }
        return nuevo;
    }

    // Verifica la salida. Si algo falla lanza un error: así el resultado
    // NO se registra (no se guarda una medición con una salida incorrecta).
    public void validar(String nombre, int[] base, int[] ordenado) {
        if (base == null || ordenado == null || base.length != ordenado.length) {
            throw new IllegalStateException(nombre + ": la salida es nula o cambió la cantidad de elementos");
        }
        for (int i = 0; i < ordenado.length - 1; i++) {
            if (ordenado[i] > ordenado[i + 1]) {
                throw new IllegalStateException(nombre + ": la salida no está ordenada");
            }
        }
        int[] esperado = Arrays.copyOf(base, base.length);
        Arrays.sort(esperado);
        for (int i = 0; i < esperado.length; i++) {
            if (esperado[i] != ordenado[i]) {
                throw new IllegalStateException(nombre + ": no conserva los mismos valores y repeticiones");
            }
        }
    }

    // Misma verificación para la salida Integer[] de la variante con Comparator
    public void validar(String nombre, int[] base, Integer[] ordenado) {
        if (ordenado == null) {
            throw new IllegalStateException(nombre + ": la salida es nula");
        }
        validar(nombre, base, convertir(ordenado));
    }

    public void imprimir() {
        for (Results r : results) {
            System.out.println(r);
        }
    }

    public void imprimirMilisegundos() {
        for (Results r : results) {
            System.out.println(r.enMilisegundos());
        }
    }
}
