public class alg1 {
    public static int moda(int[] A) {
        int frecuenciaMaxima = 0;
        int moda = -1;

        for (int i = 0; i < A.length; i++) {
            int frecuencia = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[i] == A[j]) {
                    frecuencia++;
                }
            }
            if (frecuencia > frecuenciaMaxima) {
                frecuenciaMaxima = frecuencia;
                moda = A[i];
            }
        }

        return moda;
    }

    public static void ejecutar(int arreglo[]) {
        // int[] arreglo = aleatorio.generateUniqueArray(size);  // o "pocas"
        // aleatorio.introduceRepetitions(arreglo, mode);

        long inicio = System.currentTimeMillis();
        System.out.println("Moda:"+moda(arreglo));
        long fin = System.currentTimeMillis();
        System.out.println("Tiempo ALG1: " + (fin - inicio) + " ms");
        
    }
}
