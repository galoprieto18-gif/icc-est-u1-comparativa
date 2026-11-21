import java.util.Arrays;

public class App {
    public static void main(String[] args) {

       // Datos del equipo para el README
        System.out.println("Java: " + System.getProperty("java.version"));
        System.out.println("Sistema operativo: " + System.getProperty("os.name"));
        System.out.println("Procesadores: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Memoria máxima (MB): " + Runtime.getRuntime().maxMemory() / (1024 * 1024));

        Generador g = new Generador();
        MetodosOrdenamiento m = new MetodosOrdenamiento();
        Controlresult res = new Controlresult();

        
        int[] list1 = g.generate(10000);
        int[] list2 = g.generate(50000);
        int[] list3 = g.generate(100000);

    
        int[] list1c1 = list1.clone();
        int[] list1c2 = list2.clone();
        int[] list1c3 = list3.clone();

        int[] list2c1 = list1.clone();
        int[] list2c2 = list2.clone();
        int[] list2c3 = list3.clone();

        int[] list3c1 = list1.clone();
        int[] list3c2 = list2.clone();
        int[] list3c3 = list3.clone();

        // Integer[] para el método Comparator (la conversión se hace ANTES de medir)
        Integer[] list4c1 = res.convertir(list1);
        Integer[] list4c2 = res.convertir(list2);
        Integer[] list4c3 = res.convertir(list3);

        // V1: Bubble Sort
        Results resultaM1S1 = Benchmark.medir(() -> m.sortBubble(list1c1), "Burbuja", 10000);
        res.validar("V1 Burbuja 10000", list1, list1c1);
        res.agregar(resultaM1S1);

        Results resultaM1S2 = Benchmark.medir(() -> m.sortBubble(list1c2), "Burbuja", 50000);
        res.validar("V1 Burbuja 50000", list2, list1c2);
        res.agregar(resultaM1S2);

        Results resultaM1S3 = Benchmark.medir(() -> m.sortBubble(list1c3), "Burbuja", 100000);
        res.validar("V1 Burbuja 100000", list3, list1c3);
        res.agregar(resultaM1S3);

        // V2: Merge Sort
        Results resultaM2S1 = Benchmark.medir(() -> m.sortMerge(list2c1), "V2 MergeSort", 10000);
        res.validar("V2 MergeSort 10000", list1, list2c1);
        res.agregar(resultaM2S1);

        Results resultaM2S2 = Benchmark.medir(() -> m.sortMerge(list2c2), "V2 MergeSort", 50000);
        res.validar("V2 MergeSort 50000", list2, list2c2);
        res.agregar(resultaM2S2);

        Results resultaM2S3 = Benchmark.medir(() -> m.sortMerge(list2c3), "V2 MergeSort", 100000);
        res.validar("V2 MergeSort 100000", list3, list2c3);
        res.agregar(resultaM2S3);

        // V3: Collectors sobre int[]
        Results resultaM3S1 = Benchmark.medir(() -> m.sortArrays(list3c1), "Collectors", 10000);
        res.validar("V3 Arrays.sort 10000", list1, list3c1);
        res.agregar(resultaM3S1);

        Results resultaM3S2 = Benchmark.medir(() -> m.sortArrays(list3c2), "Collectors ", 50000);
        res.validar("V3 Arrays.sort 50000", list2, list3c2);
        res.agregar(resultaM3S2);

        Results resultaM3S3 = Benchmark.medir(() -> m.sortArrays(list3c3), "Collectors ", 100000);
        res.validar("V3 Arrays.sort 100000", list3, list3c3);
        res.agregar(resultaM3S3);

        // V4: Arrays.sort sobre Integer[] con Comparator
        Results resultaM4S1 = Benchmark.medir(() -> m.sortComparator(list4c1), "Comparator", 10000);
        res.validar("V4 Comparator 10000", list1, list4c1);
        res.agregar(resultaM4S1);

        Results resultaM4S2 = Benchmark.medir(() -> m.sortComparator(list4c2), "Comparator", 50000);
        res.validar("V4 Comparator 50000", list2, list4c2);
        res.agregar(resultaM4S2);

        Results resultaM4S3 = Benchmark.medir(() -> m.sortComparator(list4c3), "Comparator", 100000);
        res.validar("V4 Comparator 100000", list3, list4c3);
        res.agregar(resultaM4S3);

      
        System.out.println();
        System.out.println("---------- RESULTADOS DEL BENCHMARK (" + res.cantidad() + " MEDICIONES) ----------");
        res.imprimir();

        
        System.out.println();
        System.out.println(" ------- RESULTADOS EN MILISEGUNDOS -------");
        res.imprimirMilisegundos();

        
        System.out.println();
        System.out.println("------- PRUEBAS DE ACEPTACION --------");
        probarCasosAceptacion();
    }

    public static void probarCasosAceptacion() {
        mostrarCaso01y02();
        mostrarCaso03a07();
        mostrarCaso08y09();
        mostrarCaso11TrazaMerge();
    }

    public static void mostrarCaso01y02() {
        Generador g = new Generador();
        int[] vacio = g.generate(0);
        int[] muestra10 = g.generate(10);

        System.out.println("-------- CA 01 y CA 02: Generador -------");
        System.out.println("Tamano 0 -> longitud: " + vacio.length);
        System.out.println("Tamano 10 -> longitud: " + muestra10.length + " | " + Arrays.toString(muestra10));

        if (vacio.length == 0) {
            System.out.println("CA 02 (n=0): OK");
        } else {
            System.out.println("CA 02 (n=0): FALLO");
        }

        // Prueba de n negativo (lanza excepcion con mensaje)
        // g.generate(-5);
    }

    public static void mostrarCaso03a07() {
        MetodosOrdenamiento m = new MetodosOrdenamiento();
        Controlresult conv = new Controlresult();
        int[] base = {7, 2, 7, 0, 4, 2};
        int[] casoVacio = {};
        int[] casoUno = {5};
        int[] casoRepetidos = {3, 3, 3};
        int[] casoOrdenado = {0, 1, 2, 3};
        int[] casoInverso = {3, 2, 1, 0};

        int[] c1 = base.clone();
        int[] c2 = base.clone();
        int[] c3 = base.clone();
        Integer[] c4 = conv.convertir(base);

        m.sortBubble(c1);
        m.sortMerge(c2);
        m.sortArrays(c3);
        m.sortComparator(c4);

        m.sortMerge(casoVacio);
        m.sortMerge(casoUno);
        m.sortMerge(casoRepetidos);
        m.sortMerge(casoOrdenado);
        m.sortMerge(casoInverso);

        System.out.println("------- CA 03 a CA 07: Variantes y casos borde -------");
        System.out.println("Base intacta: " + Arrays.toString(base));
        System.out.println("Burbuja: " + Arrays.toString(c1));
        System.out.println("MergeSort: " + Arrays.toString(c2));
        System.out.println("Arrays.sort: " + Arrays.toString(c3));
        System.out.println("Comparator: " + Arrays.toString(c4));
        System.out.println("Vacio: " + Arrays.toString(casoVacio));
        System.out.println("Un elemento: " + Arrays.toString(casoUno));
        System.out.println("Repetidos: " + Arrays.toString(casoRepetidos));
        System.out.println("Ordenado: " + Arrays.toString(casoOrdenado));
        System.out.println("Inverso: " + Arrays.toString(casoInverso));
    }

    public static void mostrarCaso08y09() {
        MetodosOrdenamiento m = new MetodosOrdenamiento();
        Controlresult controlPrueba = new Controlresult();
        int[] muestra = {7, 2, 7, 0, 4, 2};
        int[] copia = muestra.clone();

        Results r = Benchmark.medir(() -> m.sortMerge(copia), "MergeSort", 6);
        controlPrueba.validar("MergeSort 6", muestra, copia);
        controlPrueba.agregar(r);

        System.out.println("------- CA 08: Medicion con lambda -------");
        controlPrueba.imprimir();

        //Para CA 09 (operacion que lanza excepcion y no se registra):
    //     Benchmark.medir(() -> { throw new IllegalArgumentException("Fallo de prueba en lambda"); }, "ErrorTest", 0);
     }

    public static void mostrarCaso11TrazaMerge() {
        MetodosOrdenamiento m = new MetodosOrdenamiento();
        int[] traza = {7, 2, 7, 0, 4, 2};
        m.sortMerge(traza);

        System.out.println("------ CA 11: Traza MergeSort------");
        System.out.println("Salida: " + Arrays.toString(traza));
    }
}

