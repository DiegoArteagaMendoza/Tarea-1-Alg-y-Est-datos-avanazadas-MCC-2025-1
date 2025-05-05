import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        // Example usage
        System.out.print("Ingrese el tamaño del arreglo: ");
        int size = tec.nextInt(); // Tamaño del arreglo
        System.out.print("Ingrese el modo (pocas/muchas): ");
        String mode = tec.next(); // Cambia a "pocas" o "muchas" según quieras

        int[] arreglo = aleatorio.generateUniqueArray(size); // o "pocas"
        aleatorio.introduceRepetitions(arreglo, mode);

        alg1.ejecutar(arreglo);
        alg2.ejecutar(arreglo, "ascendente"); // Cambia a "pocas" o "muchas" según quieras
        alg3.ejecutar(arreglo); // Cambia a "pocas" o "muchas" según quieras
        tec.close();
    }
}
