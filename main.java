public class main {
    public static void main(String[] args) {
        int[] tamaños = { 100000, 500000, 1000000, 1500000, 2000000 };
        String modo = "pocas"; // Puedes cambiar a "muchas" si quieres

        for (int size : tamaños) {
            System.gc();
            System.out.println("=================================");
            System.out.println("Tamaño del arreglo: " + size);
            System.out.println("Modo: " + modo);
            System.out.println("=================================");

            int[] arreglo = aleatorio.generateUniqueArray(size);
            aleatorio.introduceRepetitions(arreglo, modo);

            System.out.println("Algoritmo 1");
            alg1.ejecutar(arreglo);
            // System.gc();

            System.out.println("---------------------------------");

            System.out.println("Algoritmo 2");
            System.out.println("ascendente");
            alg2.ejecutar(arreglo, "ascendente");
            // System.gc();

            System.out.println("---------------------------------");
            System.out.println("descendente");
            alg2.ejecutar(arreglo, "descendente");
            // System.gc();

            System.out.println("---------------------------------");
            System.out.println("Algoritmo 3");
            alg3.ejecutar(arreglo);
            // System.gc();

            System.out.println("=================================\n");
        }
    }
}
