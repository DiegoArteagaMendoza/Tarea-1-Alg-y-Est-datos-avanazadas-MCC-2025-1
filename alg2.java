import java.util.Arrays;
public class alg2 {

    // Ordenar el arreglo en ascendente o descendente
    public static int[] ordenar(int[] A, String sentido) {
        int[] copia = Arrays.copyOf(A, A.length); // trabajar sobre una copia
        Arrays.sort(copia);

        if ("descendente".equalsIgnoreCase(sentido)) {
            invertir(copia);
        } else if (!"ascendente".equalsIgnoreCase(sentido)) {
            throw new IllegalArgumentException("Sentido inválido: use 'ascendente' o 'descendente'.");
        }

        return copia;
    }

    // Invertir el arreglo
    private static void invertir(int[] A) {
        for (int i = 0, j = A.length - 1; i < j; i++, j--) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }

    // Calcular la moda
    public static int moda(int[] A, String sentido) {
        if (A.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede estar vacío.");
        }

        int[] ordenado = ordenar(A, sentido);

        int moda = ordenado[0], frecuenciaMax = 1, frecuenciaActual = 1;

        for (int i = 1; i < ordenado.length; i++) {
            if (ordenado[i] == ordenado[i - 1]) {
                frecuenciaActual++;
            } else {
                if (frecuenciaActual > frecuenciaMax) {
                    frecuenciaMax = frecuenciaActual;
                    moda = ordenado[i - 1];
                }
                frecuenciaActual = 1;
            }
        }

        if (frecuenciaActual > frecuenciaMax) {
            frecuenciaMax = frecuenciaActual;
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