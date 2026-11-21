import java.util.Arrays;
import java.util.Random;

public class PruebasAceptacion {

    public static void main(String[] args) {
        MetodosOrdenamiento m = new MetodosOrdenamiento();
        Random random = new Random(7);
        int n = 100000;

        int[] aleatorio = new int[n];
        for (int i = 0; i < n; i++) {
            aleatorio[i] = random.nextInt(n + 1);
        }

        int[] ordenado = aleatorio.clone();
        Arrays.sort(ordenado);

        int[] inverso = new int[n];
        for (int i = 0; i < n; i++) {
            inverso[i] = ordenado[n - 1 - i];
        }

        int[] iguales = new int[n];
        Arrays.fill(iguales, 5);

        int[] repetidos = new int[n];
        for (int i = 0; i < n; i++) {
            repetidos[i] = random.nextInt(10);
        }

        System.out.println("CASOS LÍMITE");
        probar(m, "Vacío", new int[0]);
        probar(m, "Un elemento", new int[] {5});
        probar(m, "Dos elementos {2,1}", new int[] {2, 1});
        probar(m, "Ejemplo {7,2,7,0,4,2}", new int[] {7, 2, 7, 0, 4, 2});

        System.out.println();
        System.out.println("n = " + n);
        probar(m, "Aleatorio", aleatorio);
        probar(m, "Ya ordenado", ordenado);
        probar(m, "Orden inverso", inverso);
        probar(m, "Todos iguales", iguales);
        probar(m, "Muchos repetidos (0..9)", repetidos);

        System.out.println();
        System.out.println("COMPARACIÓN EN EL CASO YA ORDENADO (n = " + n + ")");
        int[] copiaBubble = ordenado.clone();
        long inicio = System.nanoTime();
        m.sortBubble(copiaBubble);
        long fin = System.nanoTime();
        System.out.printf("%-26s %10.3f ms%n", "Bubble Sort (ya ordenado)", (fin - inicio) / 1_000_000.0);

        int[] copiaMerge = ordenado.clone();
        inicio = System.nanoTime();
        m.sortMerge(copiaMerge);
        fin = System.nanoTime();
        System.out.printf("%-26s %10.3f ms%n", "Merge Sort (ya ordenado)", (fin - inicio) / 1_000_000.0);

        System.out.println();
        System.out.println("TAMAÑO GRANDE (profundidad de recursión y memoria auxiliar)");
        int grande = 10_000_000;
        int[] enorme = new int[grande];
        for (int i = 0; i < grande; i++) {
            enorme[i] = random.nextInt(grande + 1);
        }
        probar(m, "Aleatorio", enorme);
    }

    // Este método ordena una copia, mide y verifica contra Arrays.sort (fuera del cronómetro)
    private static void probar(MetodosOrdenamiento m, String nombre, int[] datos) {
        int[] referencia = datos.clone();
        Arrays.sort(referencia);
        int[] copia = datos.clone();

        long inicio = System.nanoTime();
        m.sortMerge(copia);
        long fin = System.nanoTime();

        boolean correcto = Arrays.equals(copia, referencia);
        System.out.printf("%-26s n=%9d  %-10s %10.3f ms%n",
                nombre, datos.length, correcto ? "CORRECTO" : "FALLA", (fin - inicio) / 1_000_000.0);
    }
}
