import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        
        // Example usage
        System.out.print("Ingrese el tamaño del arreglo: ");
        int size = tec.nextInt(); // Tamaño del arreglo
        System.out.print("Ingrese el modo (pocas/muchas): ");
        String mode = tec.next(); // Cambia a "pocas" o "muchas" según quieras
        System.out.println("Seleccione el algoritmo (1, 2 o 3): ");
        int algoritmo = tec.nextInt(); // Cambia a "pocas" o "muchas" según quieras
        switch (algoritmo) {
            case 1:
                alg1.ejecutar(size, mode);
                break;
        
            case 2:
                System.out.print("Ingrese el sentido (ascendente/descendente): ");
                String sentido = tec.next(); // Cambia a "pocas" o "muchas" según quieras
                if (!"ascendente".equalsIgnoreCase(sentido) && !"descendente".equalsIgnoreCase(sentido)) {
                    System.out.println("Sentido inválido. Usando 'ascendente' por defecto.");
                    sentido = "ascendente";
                }
                alg2.ejecutar(size, mode, sentido);
                break;
            
            case 3:
                alg3.ejecutar(size, mode);
                break;
            
            default:
                System.out.println("Algoritmo no válido. Por favor, elija 1, 2 o 3.");
                break;
        }
        tec.close();
    }
}
