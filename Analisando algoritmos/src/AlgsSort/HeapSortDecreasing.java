package AlgsSort;

public class HeapSortDecreasing <T extends Comparable<? super T>> implements StrategeySort<T> {
    private static int numComparison;
    private static int numAssignments;
    @Override
    public void sort(T[] array) {
        numComparison = 0; 
        numAssignments = 0;
        heapSort(array); 
        System.out.println("num de comparações Heap Sort Decrescente:" + numComparison);
        System.out.println("num de atribuições Heap Sort Decrescente:" + numAssignments);
        System.out.println("Total: " + (numAssignments + numComparison));
        System.out.print(numComparison + " " + numAssignments+ " ");
    }

    void heapSort(T[] vet) {
        int n = vet.length;
        numAssignments+=2;
        numComparison++; 
        for (int i = n/2 - 1; i >= 0; i--) {
            heapify(vet, n, i);
            numComparison++; 
            numAssignments++;
        }
        
        numComparison++; 
        numAssignments++;
        for (int i = n-1; i >= 0; i--) {
            T temp = vet[0];
            vet[0] = vet[i];
            vet[i] = temp;
            numAssignments+=4;
            heapify(vet, i, 0);
        }
    }

    void heapify(T[] vet, int n, int i) {
        int root = i;
        int left = i*2 + 1;
        int right = i*2 + 2;
        numAssignments+=3;

        if (left < n && vet[left].compareTo(vet[root]) < 0) {
            root = left;
        }
        if (right < n && vet[right].compareTo(vet[root]) < 0) {
            root = right;
        }
        numComparison+=4;

        numComparison++;
        if (root != i) {
            T temp = vet[i];
            vet[i] = vet[root];
            vet[root] = temp;
            numAssignments+=3;
            heapify(vet, n, root);
        }
    }
}