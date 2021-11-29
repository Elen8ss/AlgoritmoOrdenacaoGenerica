package AlgsSort;

//classe generica que possui como parametro um elemento do tipo T
public class MergeInsertDecreasing <T extends Comparable<? super T>> implements StrategeySort<T>{

    @Override
    public void sort(T[] array) {        
        T[] auxArray = (T[]) new Comparable[array.length];
        mergeInsertSort(array, auxArray,  0, array.length - 1);
    }
    
    // funcao MergerSort
    private static <T extends Comparable<? super T>>  void mergeInsertSort(T[] vetor, T[] auxiliar,  int inicio, int fim){
        if (inicio < fim){
            int meio = (inicio + fim)/2; 
            mergeInsertSort(vetor, auxiliar, inicio, meio); 
            mergeInsertSort(vetor, auxiliar, meio+1, fim); 
	    
            if ((fim - inicio) > 5) {
                intercalar(vetor, auxiliar, inicio, meio, fim);
            } else {
                insertSort(vetor, inicio, fim);
            }
        }
    }

    // funcao Intercalar
    private static <T extends Comparable<? super T>> void intercalar(T []vetor, T[]auxiliar, int inicio, int meio, int fim) {
        
        for (int i = inicio; i<=fim; i++) {
            auxiliar[i] = vetor[i]; 
        }

        int esq = inicio; 
        int dir = meio + 1; 
        
        //percorrendo o vetor auxiliar
        for (int i=inicio; i<=fim; i++) {

            if (esq > meio) {
                vetor[i] = auxiliar[dir++]; 
            }
            
 
            else if (dir > fim) {
                vetor[i] = auxiliar[esq++];
            }
            
    
            else if (auxiliar[esq].compareTo(auxiliar[dir]) > 0) { 
                vetor[i] = auxiliar[esq++]; 
            }
            
            else {
                vetor[i] = auxiliar[dir++];
            }
        }
    }

    private static <T extends Comparable<? super T>> void insertSort(T[] array, int inicio, int fim) {
        T aux;
        
        for (int i=inicio+1; i <= fim; i++){
            aux = array[i]; 
            
	        int j = i-1; 
            while (j >= inicio && array[j].compareTo(aux) < 0){ 
                array[j+1] = array[j]; 
                j--;
            }
            array[j+1] = aux; 
        }
    }
}