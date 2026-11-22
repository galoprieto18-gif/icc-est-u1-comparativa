
## **Investigación: Merge Sort en la versión V2.**

## **1. Algoritmo, variante, clases, métodos y rutas del código fuente.**

El algoritmo que investigué e implementé para la versión V2 de mi proyecto es el método **Merge Sort** (ordenamiento por mezcla), el cual sirve para ordenar arreglos en orden ascendente. Su forma de trabajo es **top-down (recursiva, bajo el enfoque divide y vencerás)** utilizando un único arreglo auxiliar compartido para no estar creando arreglos nuevos a cada rato.

**Ruta de implementación:** `MetodosOrdenamiento.java` *(o `src/MetodosOrdenamiento.java` si se ubica en la carpeta `src/`)*.

**Otras clases del proyecto conectadas son:** `App.java`, `Benchmark.java`, `Controlresult.java`, `Results.java` y `PruebasAceptacion.java`.

**Clase y métodos implementados:** en la clase `MetodosOrdenamiento` implementé `sortMerge(int[] arreglo)` para ordenar el arreglo de una forma más rápida. Además, utilicé una sobrecarga recursiva `sortMerge(int[] arreglo, int[] auxiliar, int izquierda, int derecha)` para ir partiendo el arreglo encontrando un medio, y el método auxiliar `merge(int[] arreglo, int[] auxiliar, int izquierda, int medio, int derecha)` para ir acomodando los datos en su posición de orden correcto.

## **2. Proceso paso a paso, parámetros, caso base, progreso y propiedad conservada.**

Al programar y revisar el método, organicé el proceso de esta manera:

**Parámetros:**

`arreglo` recibe el arreglo de enteros (`int[]`) que quiero ordenar; `auxiliar` es el arreglo temporal del mismo tamaño que reutilizo en todas las mezclas; `izquierda` y `derecha` marcan los límites inclusivos del pedazo de arreglo que estoy trabajando; y en `merge`, `medio` me sirve para separar la mitad izquierda `[izquierda, medio]` de la mitad derecha `[medio + 1, derecha]`.

**Caso base y validación inicial del método:** 


En `sortMerge(int[] arreglo)` verifico primero con un `if` si `arreglo == null || arreglo.length < 2` para salir sin hacer nada si el arreglo es nulo, está vacío o tiene un solo elemento. Dentro de la recursión, cuando `izquierda >= derecha`, significa que el rango tiene `0` o `1` elemento (ya no se puede dividir más) y retorno de inmediato.

**Progreso de la llamada recursión:**

 En cada llamada calculo `medio = izquierda + (derecha - izquierda) / 2` y divido el rango en dos mitades más pequeñas (`[izquierda, medio]` y `[medio + 1, derecha]`). Así la distancia entre `izquierda` y `derecha` va bajando en cada paso hasta llegar al caso base.

**Propiedad que se conserva:** 

Después de ejecutar `merge` sobre `[izquierda, derecha]`, ese tramo queda ordenado de menor a mayor y conserva exactamente los mismos valores y cantidades repetidas que tenía al inicio.

## **3. División, mezcla, arreglo auxiliar y tratamiento de empates.**

En mi implementación de **Merge Sort** apliqué estas decisiones concretas:

**División:** 

Parto el subarreglo actual en dos mitades usando `int medio = izquierda + (derecha - izquierda) / 2;`, lo que me evita un posible desbordamiento de entero (`overflow`) si se llegan a sumar índices muy grandes.

**Arreglo auxiliar:**

 Creo `int[] auxiliar = new int[arreglo.length]` una sola vez dentro de `sortMerge(int[] arreglo)` y lo paso como parámetro a las llamadas recursivas. Como esta reserva ocurre dentro del método que mido con `Benchmark.medir(...)`, ese tiempo queda incluido dentro de la medición.

**Mezcla (`merge`):** 

Primero uso un ciclo `for` para copiar los valores de `arreglo[izquierda..derecha]` hacia `auxiliar[izquierda..derecha]`. Luego recorro con `a` desde `izquierda` hasta `derecha` usando dos índices (`i` para la mitad izquierda y `j` para la mitad derecha). Con condiciones `if / else if` voy colocando en `arreglo[a]` el menor valor disponible y copiando lo que quede si un lado termina antes (`i > medio` o `j > derecha`).

**Tratamiento de empates:**

 Cuando comparo `else if (auxiliar[j] < auxiliar[i])`, si ambos valores son iguales la condición no se cumple y entra al `else` para tomar primero `auxiliar[i]` (el de la mitad izquierda). Así mantengo el orden relativo original entre elementos iguales.

## 4. Traza manual sobre `[7, 2, 7, 0, 4, 2`.
Seguí manualmente la ejecución paso a paso sobre**[7, 2, 7, 0, 4, 2]` (índices `0` a `5`):

1. **División inicial (`medio = 2`):** obtengo la mitad izquierda `[7, 2, 7]` (`0..2`) y la mitad derecha `[0, 4, 2]` (`3..5`).

2. **Mitad izquierda `[7, 2, 7]` (`medio = 1`):**
   - Divido en `[7, 2]` (`0..1`) y `[7]` (`2..2`).
   - `[7, 2]` se separa en `[7]` y `[2]`, y al mezclarse queda **`[2, 7]`**.
   - Al mezclar `[2, 7]` con `[7]`, tomo `2`, luego `7` de la izquierda ante el empate con `7`, y luego `7` de la derecha, quedando **`[2, 7, 7]`**.

3. **Mitad derecha `[0, 4, 2]` (`medio = 4`):**
   - Divido en `[0, 4]` (`3..4`) y `[2]` (`5..5`).
   - `[0, 4]` ya está ordenado como **`[0, 4]`**.
   - Al mezclar `[0, 4]` con `[2]`, tomo `0`, luego `2` (`2 < 4`) y después `4`, quedando **`[0, 2, 4]`**.

4. **Mezcla final de `[2, 7, 7]` y `[0, 2, 4]`:**
   - Comparo `0` y `2` $\rightarrow$ escribo `0`.
   - Comparo `2` y `2` $\rightarrow$ escribo `2` (de `[2, 7, 7]`).
   - Comparo `7` y `2` $\rightarrow$ escribo `2` (de `[0, 2, 4]`).
   - Comparo `7` y `4` $\rightarrow$ escribo `4` (de `[0, 2, 4]`).
   - Completo con los elementos restantes de la izquierda: `7` y `7`.
   - **Salida final:** **`[0, 2, 2, 4, 7, 7]`**.

## **5. Análisis de complejidad y estabilidad**

**Tiempo:** Considero que su complejidad es $O(n \log n)$ en el **mejor caso**, en el **caso promedio** y en el **peor caso**. Esto pasa porque en cada nivel divido el problema a la mitad ($\log_2 n$ niveles) y en cada fusión recorro linealmente los elementos ($O(n)$), sin importar si los datos vienen ordenados o desordenados. Para el caso promedio asumo entradas distribuidas de forma aleatoria/uniforme sin que se altere la partición por el punto medio.

**Memoria auxiliar y pila recursiva:** El arreglo `auxiliar` ocupa $O(n)$ de espacio adicional en memoria temporal y la pila de llamadas recursivas ocupa $O(\log n)$ por la profundidad de las llamadas.

**Estabilidad:** Mi implementación es estable porque, cuando existe la igualdad entre elementos de ambas mitades del arreglo, el código toma primero el elemento de la izquierda (`auxiliar[i]`), respetando su orden original.

## **6. Caso desfavorable y prueba real**

**Escenario desfavorable:** 

Un caso exigente para mi implementación es trabajar con tamaños grandes (como `100.000` en el benchmark o `10.000.000` en `PruebasAceptacion.java`) o arreglos invertidos / con muchos repetidos, porque igual tiene que hacer todas las divisiones y mezclas completas, además de reservar el arreglo `auxiliar` de tamaño `n` en memoria.

**Mi prueba real:**

  - *Qué ejecuté:* Probé el método tanto en `App.java` con las muestras de `10.000`, `50.000` y `100.000` datos como en `PruebasAceptacion.java` con casos borde (`[]`, `[5]`, `[2, 1]`, `[7, 2, 7, 0, 4, 2]`), muestras de `100.000` en varios órdenes (aleatorio, ya ordenado, inverso, todos iguales y repetidos `0..9`) y una prueba grande de `10.000.000` de elementos.


  - *Qué observé:* No tuve errores de índices ni desbordamiento de pila en ninguna ejecución; todas pasaron la validación de orden ascendente y conservación de datos.

## **7. Relación con la tabla de benchmarking y fuentes técnicas**

**Observaciones sobre mi tabla de resultados:**

  En mi tabla de mediciones se nota la diferencia entre $O(n \log n)$ y $O(n^2)$: mientras `Burbuja` sube de `43.172.900 ns` (`0,0431729 s`) en `10.000` datos hasta `10.067.924.800 ns` (`10,0679248 s`) en `100.000` datos, `MergeSort` pasa de `2.219.800 ns` (`0,0022198 s`) en `10.000` datos a apenas `9.102.400 ns` (`0,0091024 s`) en `100.000` datos.

  Al comparar `MergeSort` contra `Collectors` y `V2 Comparator`, todos se mantienen en el rango de pocos milisegundos gracias a su comportamiento $O(n \log n)$; `MergeSort` evita convertir `int` a `Integer`, aunque incluye dentro de su medición el tiempo de reservar y copiar el arreglo `auxiliar`.

**Fuentes consultadas:**
  - **Fuente 1:** Cormen, T. H., Leiserson, C. E., Rivest, R. L., & Stein, C. *Introduction to Algorithms* (4.ª ed., MIT Press — capítulo de Divide y Vencerás / Merge Sort). 
  Fecha de consulta: 21 - 11 -2026

  - **Fuente 2:** Documentación oficial de Java SE (`java.util.Arrays` y `java.util.Comparator`, `https://docs.oracle.com/en/java/javase/`).
   Fecha de consulta: 21 - 11 -2026

  - **Diferencia entre la fuente y mi código:** De la teoría tomé la idea base de dividir en mitades y fusionar ordenadamente; por mi cuenta lo escribí en Java usando ciclos `for` y condiciones `if` sencillas sobre `int[]`, añadí la validación inicial para arreglos nulos o menores a 2, reutilicé un solo arreglo `auxiliar` dentro de `sortMerge`, calculé el punto medio como `izquierda + (derecha - izquierda) / 2` y lo integré con `Benchmark`, `Controlresult` y `App`.