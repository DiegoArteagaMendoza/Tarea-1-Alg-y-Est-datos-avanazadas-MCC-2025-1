import java.util.*;

public class alg3 {

    public static int moda(int[] A) {
        List<int[]> homog = new ArrayList<>();
        Queue<int[]> heterog = new LinkedList<>();
        heterog.add(A);

        while (true) {
            int[] maxHeterog = obtenerSubarregloMasLargo(heterog);
            int[] maxHomog = obtenerSubarregloMasLargo(homog);

            if (maxHomog != null && maxHeterog.length <= maxHomog.length) {
                return maxHomog[0]; // todos sus elementos son iguales
            }

            int mediana = medianOfMedians(maxHeterog);

            List<Integer> menores = new ArrayList<>();
            List<Integer> iguales = new ArrayList<>();
            List<Integer> mayores = new ArrayList<>();

            for (int num : maxHeterog) {
                if (num < mediana)
                    menores.add(num);
                else if (num == mediana)
                    iguales.add(num);
                else
                    mayores.add(num);
            }

            if (!iguales.isEmpty())
                homog.add(convertirLista(menores.size() == 0 ? iguales : iguales));
            if (!menores.isEmpty())
                heterog.add(convertirLista(menores));
            if (!mayores.isEmpty())
                heterog.add(convertirLista(mayores));
            heterog.remove(maxHeterog);
        }
    }

    // Divide en grupos de 5 y calcula la mediana de las medianas
    public static int medianOfMedians(int[] arr) {
        if (arr.length <= 5) {
            Arrays.sort(arr);
            return arr[arr.length / 2];
        }

        int numGrupos = (int) Math.ceil(arr.length / 5.0);
        int[] medianas = new int[numGrupos];

        for (int i = 0; i < numGrupos; i++) {
            int inicio = i * 5;
            int fin = Math.min(inicio + 5, arr.length);
            int[] grupo = Arrays.copyOfRange(arr, inicio, fin);
            Arrays.sort(grupo);
            medianas[i] = grupo[grupo.length / 2];
        }

        return medianOfMedians(medianas);
    }

    private static int[] obtenerSubarregloMasLargo(Collection<int[]> lista) {
        int maxLong = -1;
        int[] resultado = null;
        for (int[] arr : lista) {
            if (arr.length > maxLong) {
                maxLong = arr.length;
                resultado = arr;
            }
        }
        return resultado;
    }

    private static int[] convertirLista(List<Integer> lista) {
        return lista.stream().mapToInt(i -> i).toArray();
    }
    
    public static void ejecutar(int size, String mode) {
        int[] arreglo = aleatorio.generateUniqueArray(size); // o "pocas"
        aleatorio.introduceRepetitions(arreglo, mode);
    
        long inicio = System.currentTimeMillis();
        System.out.println("Moda:" + moda(arreglo));
        long fin = System.currentTimeMillis();
        System.out.println("Tiempo ALG2: " + (fin - inicio) + " ms");
    
    }
}
