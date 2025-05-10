import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class alg3 {

    public static int moda(int[] A) {
        if (A == null || A.length == 0) {
            throw new IllegalArgumentException("Arreglo vacío.");
        }

        PriorityQueue<Range> heterog = new PriorityQueue<>(Comparator.comparingInt(Range::getLength).reversed());
        heterog.add(new Range(0, A.length - 1));

        int maxLengthHomog = 0;
        int modaCandidate = A[0];

        while (!heterog.isEmpty()) {
            Range p = heterog.poll();

            if (p.getLength() <= maxLengthHomog) {
                break;
            }

            if (p.getLength() == 1) {
                if (1 > maxLengthHomog) {
                    maxLengthHomog = 1;
                    modaCandidate = A[p.start];
                }
                continue;
            }

            int[] temp = Arrays.copyOfRange(A, p.start, p.end + 1);
            int medianVal = medianOfMedians(temp, 0, temp.length - 1, temp.length / 2);
            int[] bounds = partitionAroundPivot(A, p.start, p.end, medianVal);
            int eqStart = bounds[0];
            int eqEnd = bounds[1];

            int eqLength = eqEnd - eqStart + 1;
            if (eqLength > maxLengthHomog) {
                maxLengthHomog = eqLength;
                modaCandidate = medianVal;
            }

            if (p.start < eqStart) {
                heterog.add(new Range(p.start, eqStart - 1));
            }
            if (eqEnd < p.end) {
                heterog.add(new Range(eqEnd + 1, p.end));
            }
        }
        return modaCandidate;
    }

    public static int medianOfMedians(int[] arr, int low, int high, int k) {
        int n = high - low + 1;

        if (n <= 5) {
            Arrays.sort(arr, low, high + 1);
            return arr[low + k];
        }

        int numMedians = (int) Math.ceil(n / 5.0);
        int[] medians = new int[numMedians];

        for (int i = 0; i < numMedians; i++) {
            int left = low + i * 5;
            int right = Math.min(left + 4, high);
            Arrays.sort(arr, left, right + 1);
            medians[i] = arr[left + (right - left) / 2];
        }

        return medianOfMedians(medians, 0, medians.length - 1, medians.length / 2);
    }

    public static int[] partitionAroundPivot(int[] arr, int low, int high, int pivot) {
        int i = low, j = high;
        int k = low;

        while (k <= j) {
            if (arr[k] < pivot) {
                swap(arr, i++, k++);
            } else if (arr[k] > pivot) {
                swap(arr, k, j--);
            } else {
                k++;
            }
        }
        return new int[] { i, j };
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    static class Range {
        int start;
        int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getLength() {
            return end - start + 1;
        }
    }

    public static void ejecutar(int arreglo[]) {
        long inicio = System.currentTimeMillis();
        System.out.println("Moda:" + moda(arreglo));
        long fin = System.currentTimeMillis();
        System.out.println("Tiempo ALG3: " + (fin - inicio) + " ms");
    }
}
