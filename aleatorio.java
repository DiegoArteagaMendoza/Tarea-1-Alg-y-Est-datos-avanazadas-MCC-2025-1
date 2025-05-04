import java.util.Random;
import java.util.Arrays;

public class aleatorio {

    // Método para generar un arreglo de números únicos
    public static int[] generateUniqueArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1; // Números diferentes: 1, 2, 3, ...
        }
        shuffleArray(array);
        return array;
    }

    // Método para mezclar el arreglo
    public static void shuffleArray(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            // Intercambiar
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    // Método para introducir repeticiones controladas
    public static void introduceRepetitions(int[] array, String repetitionMode) {
        Random random = new Random();
        int size = array.length;

        int numRepetitions;
        if (repetitionMode.equalsIgnoreCase("pocas")) {
            numRepetitions = size / 10; // 10% del arreglo repite
            if (numRepetitions == 0) numRepetitions = 1; // al menos una repetición
        } else if (repetitionMode.equalsIgnoreCase("muchas")) {
            numRepetitions = size / 2; // 50% del arreglo repite
        } else {
            throw new IllegalArgumentException("Modo de repetición no válido. Usa 'pocas' o 'muchas'.");
        }

        for (int i = 0; i < numRepetitions; i++) {
            int sourceIndex = random.nextInt(size);
            int targetIndex = random.nextInt(size);

            // Asegurar que no sea la misma posición
            while (targetIndex == sourceIndex) {
                targetIndex = random.nextInt(size);
            }

            array[targetIndex] = array[sourceIndex];
        }
    }

    public static void main(String[] args) {
        int size = 20; // Tamaño del arreglo
        String mode = "muchas"; // Cambia a "pocas" o "muchas" según quieras

        int[] array = generateUniqueArray(size);

        System.out.println("Antes de introducir repeticiones:");
        System.out.println(Arrays.toString(array));

        introduceRepetitions(array, mode);

        System.out.println("Después de introducir repeticiones (" + mode + " repeticiones):");
        System.out.println(Arrays.toString(array));
    }
}