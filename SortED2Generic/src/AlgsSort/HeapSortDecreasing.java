package AlgsSort;

public class HeapSortDecreasing <T extends Comparable<? super T>> implements StrategeySort<T> {
    @Override
    public void sort(T[] array) {
        heapSort(array); 
    }

    void heapSort(T[] vet) {
        int n = vet.length;

        for (int i = n/2 - 1; i >= 0; i--) {
            heapify(vet, n, i);
        }

        for (int i = n-1; i >= 0; i--) {
            T temp = vet[0];
            vet[0] = vet[i];
            vet[i] = temp;

            heapify(vet, i, 0);
        }
    }

    void heapify(T[] vet, int n, int i) {
        int root = i;
        int left = i*2 + 1;
        int right = i*2 + 2;

        if (left < n && vet[left].compareTo(vet[root]) < 0) {
            root = left;
        }
        if (right < n && vet[right].compareTo(vet[root]) < 0) {
            root = right;
        }

        if (root != i) {
            T temp = vet[i];
            vet[i] = vet[root];
            vet[root] = temp;

            heapify(vet, n, root);
        }
    }
}