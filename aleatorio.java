// import java.util.Random;
// import java.util.Arrays;

// public class aleatorio {

//     // Método para generar un arreglo de números únicos
//     public static int[] generateUniqueArray(int size) {
//         int[] array = new int[size];
//         for (int i = 0; i < size; i++) {
//             array[i] = i + 1; // Números diferentes: 1, 2, 3, ...
//         }
//         shuffleArray(array);
//         return array;
//     }

//     // Método para mezclar el arreglo
//     public static void shuffleArray(int[] array) {
//         Random random = new Random();
//         for (int i = array.length - 1; i > 0; i--) {
//             int index = random.nextInt(i + 1);
//             // Intercambiar
//             int temp = array[index];
//             array[index] = array[i];
//             array[i] = temp;
//         }
//     }

//     // Método para introducir repeticiones controladas
//     public static void introduceRepetitions(int[] array, String repetitionMode) {
//         Random random = new Random();
//         int size = array.length;

//         int numRepetitions;
//         if (repetitionMode.equalsIgnoreCase("pocas")) {
//             numRepetitions = size / 10; // 10% del arreglo repite
//             if (numRepetitions == 0) numRepetitions = 1; // al menos una repetición
//         } else if (repetitionMode.equalsIgnoreCase("muchas")) {
//             numRepetitions = size / 2; // 50% del arreglo repite
//         } else {
//             throw new IllegalArgumentException("Modo de repetición no válido. Usa 'pocas' o 'muchas'.");
//         }

//         for (int i = 0; i < numRepetitions; i++) {
//             int sourceIndex = random.nextInt(size);
//             int targetIndex = random.nextInt(size);

//             // Asegurar que no sea la misma posición
//             while (targetIndex == sourceIndex) {
//                 targetIndex = random.nextInt(size);
//             }

//             array[targetIndex] = array[sourceIndex];
//         }
//     }

//     public static void main(String[] args) {
//         int size = 20; // Tamaño del arreglo
//         String mode = "muchas"; // Cambia a "pocas" o "muchas" según quieras

//         int[] array = generateUniqueArray(size);

//         System.out.println("Antes de introducir repeticiones:");
//         System.out.println(Arrays.toString(array));

//         introduceRepetitions(array, mode);

//         System.out.println("Después de introducir repeticiones (" + mode + " repeticiones):");
//         System.out.println(Arrays.toString(array));
//     }
// }

import java.util.Random;
import java.util.Arrays;

public class aleatorio {

    private static final Random RANDOM = new Random();
    private static final double POCAS_REPETICIONES = 0.10;
    private static final double MUCHAS_REPETICIONES = 0.50;

    // Genera un arreglo con números únicos del 1 al size y lo mezcla
    public static int[] generateUniqueArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        shuffleArray(array);
        return array;
    }

    // Mezcla el arreglo usando el algoritmo de Fisher-Yates
    public static void shuffleArray(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int j = RANDOM.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    // Introduce repeticiones en el arreglo según el modo ("pocas" o "muchas")
    public static void introduceRepetitions(int[] array, String repetitionMode) {
        int size = array.length;
        int numRepetitions;

        switch (repetitionMode.toLowerCase()) {
            case "pocas":
                numRepetitions = Math.max(1, (int) (size * POCAS_REPETICIONES));
                break;
            case "muchas":
                numRepetitions = (int) (size * MUCHAS_REPETICIONES);
                break;
            default:
                throw new IllegalArgumentException("Modo de repetición no válido. Usa 'pocas' o 'muchas'.");
        }

        for (int i = 0; i < numRepetitions; i++) {
            int sourceIndex = RANDOM.nextInt(size);
            int targetIndex;
            do {
                targetIndex = RANDOM.nextInt(size);
            } while (targetIndex == sourceIndex);

            array[targetIndex] = array[sourceIndex];
        }
    }

    public static void main(String[] args) {
        int size = 20;
        String mode = "muchas"; // "pocas" o "muchas"

        int[] array = generateUniqueArray(size);

        System.out.println("Antes de introducir repeticiones:");
        System.out.println(Arrays.toString(array));

        introduceRepetitions(array, mode);

        System.out.println("Después de introducir repeticiones (" + mode + "):");
        System.out.println(Arrays.toString(array));
    }
}
