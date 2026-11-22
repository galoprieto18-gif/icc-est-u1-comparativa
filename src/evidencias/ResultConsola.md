
## Impresión de los 12 resultados.

```
---------- RESULTADOS DEL BENCHMARK (12 MEDICIONES) ----------
Results [Burbuja, duration=90446200ns, 0.0904462s, sample=10000]
Results [Burbuja, duration=5178167600ns, 5.1781676s, sample=50000]
Results [Burbuja, duration=22023481500ns, 22.0234815s, sample=100000]
Results [V2 MergeSort, duration=5023500ns, 0.0050235s, sample=10000]
Results [V2 MergeSort, duration=27289400ns, 0.0272894s, sample=50000]
Results [V2 MergeSort, duration=21664200ns, 0.0216642s, sample=100000]
Results [Collectors, duration=960800ns, 9.608E-4s, sample=10000]
Results [Collectors , duration=6865000ns, 0.006865s, sample=50000]
Results [Collectors , duration=11884000ns, 0.011884s, sample=100000]
Results [Comparator, duration=19473900ns, 0.0194739s, sample=10000]
Results [Comparator, duration=30915200ns, 0.0309152s, sample=50000]
Results [Comparator, duration=67995300ns, 0.0679953s, sample=100000]
```

### Impresión de los resultados en milisegundos

```
------- RESULTADOS EN MILISEGUNDOS -------
Results [Burbuja, sample=10000, 90,446 ms]
Results [Burbuja, sample=50000, 5178,168 ms]
Results [Burbuja, sample=100000, 22023,482 ms]
Results [V2 MergeSort, sample=10000, 5,024 ms]
Results [V2 MergeSort, sample=50000, 27,289 ms]
Results [V2 MergeSort, sample=100000, 21,664 ms]
Results [Collectors, sample=10000, 0,961 ms]
Results [Collectors , sample=50000, 6,865 ms]
Results [Collectors , sample=100000, 11,884 ms]
Results [Comparator, sample=10000, 19,474 ms]
Results [Comparator, sample=50000, 30,915 ms]
Results [Comparator, sample=100000, 67,995 ms]
```

### Resultados de prueba de aceptación

```
------- PRUEBAS DE ACEPTACION --------
-------- CA 01 y CA 02: Generador -------
Tamano 0 -> longitud: 0
Tamano 10 -> longitud: 10 | [8, 4, 2, 3, 9, 4, 4, 9, 2, 4]
CA 02 (n=0): OK
------- CA 03 a CA 07: Variantes y casos borde -------
Base intacta: [7, 2, 7, 0, 4, 2]
Burbuja: [0, 2, 2, 4, 7, 7]
MergeSort: [0, 2, 2, 4, 7, 7]
Arrays.sort: [0, 2, 2, 4, 7, 7]
Comparator: [0, 2, 2, 4, 7, 7]
Vacio: []
Un elemento: [5]
Repetidos: [3, 3, 3]
Ordenado: [0, 1, 2, 3]
Inverso: [0, 1, 2, 3]
------- CA 08: Medicion con lambda -------
Results [MergeSort, duration=7200ns, 7.2E-6s, sample=6]
------ CA 11: Traza MergeSort------
Salida: [0, 2, 2, 4, 7, 7]
```

