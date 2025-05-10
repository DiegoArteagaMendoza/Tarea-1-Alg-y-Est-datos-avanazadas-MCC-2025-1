import java.util.Arrays;
public class alg2 {

    // Ordenar el arreglo en ascendente o descendente
    public static int[] ordenar(int[] A, String sentido) {
        int[] copia = Arrays.copyOf(A, A.length); // trabajar sobre una copia
        Arrays.sort(copia);

        if ("descendente".equalsIgnoreCase(sentido)) {
            for (int i = 0, j = copia.length - 1;  i < j; i++, j--) {
                int temp = copia[i];
                copia[i] = copia[j];
                copia[j] = temp;
            }
        }
        return copia;
    }
    // Calcular la moda
    public static int moda(int[] A, String sentido) {
        int[] ordenado = ordenar(A, sentido);
        int moda = ordenado[0], frecuenciaMax = 1, frecuenciaActual = 1;

        for (int i = 1; i < ordenado.length; i++) {
            if (ordenado[i] == ordenado[i - 1]) {
                frecuenciaActual++;
            } else {
                if (frecuenciaActual > frecuenciaMax || (frecuenciaActual == frecuenciaMax && ordenado[i-1] < moda)) {
                    frecuenciaMax = frecuenciaActual;
                    moda = ordenado[i - 1];
                }
                frecuenciaActual = 1;
            }
        }

        if (frecuenciaActual > frecuenciaMax || (frecuenciaActual == frecuenciaMax && ordenado[ordenado.length - 1] < moda)) {
            moda = ordenado[ordenado.length - 1];
        }

        return moda;
    }

    public static void ejecutar(int arreglo[], String sentido) {
        long inicio = System.currentTimeMillis();
        System.out.println("Moda:" + moda(arreglo, sentido));
        long fin = System.currentTimeMillis();
        System.out.println("Tiempo ALG2: " + (fin - inicio) + " ms");
    }
}