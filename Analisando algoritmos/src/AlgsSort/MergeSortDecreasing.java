package AlgsSort;

//classe generica que possui como parametro um elemento do tipo T
public class MergeSortDecreasing <T extends Comparable<? super T>> implements StrategeySort<T>{
    
    private static int numComparison;
    private static int numAssignments;

    @Override
    public void sort(T[] array) {      
        numComparison = 0; 
        numAssignments = 0;
        T[] auxArray = (T[]) new Comparable[array.length];
        mergeSort(array, auxArray,  0, array.length - 1);
        System.out.println("num de comparações Merge Sort Decrescente:" + numComparison);
        System.out.println("num de atribuições Merge Sort Decrescente:" + numAssignments);
        System.out.println("Total: " + (numAssignments + numComparison));
    }
    
    // funcao MergerSort
    private static <T extends Comparable<? super T>>  void mergeSort(T[] vetor, T[] auxiliar,  int inicio, int fim){
        if (inicio < fim){
            int meio = (inicio + fim)/2; 
            numAssignments++;
            mergeSort(vetor, auxiliar, inicio, meio); 
            mergeSort(vetor, auxiliar, meio+1, fim); 
            intercalar(vetor, auxiliar, inicio, meio, fim);
        }
        numComparison++;
    }

    // funcao Intercalar
    private static <T extends Comparable<? super T>> void intercalar(T []vetor, T[]auxiliar, int inicio, int meio, int fim) {
        numAssignments++;
        numComparison++;
        for (int i = inicio; i<=fim; i++) {
            auxiliar[i] = vetor[i]; 
            numAssignments+=2;
            numComparison++;
        }

        int esq = inicio; 
        int dir = meio + 1; 
        numAssignments+=2;
        
        //percorrendo o vetor auxiliar
        numAssignments++;
        numComparison++;
        for (int i=inicio; i<=fim; i++) {

            if (esq > meio) {
                vetor[i] = auxiliar[dir++];
                numComparison++; 
                numAssignments++;
            }
            
 
            else if (dir > fim) {
                vetor[i] = auxiliar[esq++];
                numComparison+=2;
                numAssignments++;
            }
            
    
            else if (auxiliar[esq].compareTo(auxiliar[dir]) > 0) { 
                vetor[i] = auxiliar[esq++];
                numComparison+=3; 
                numAssignments++;
            }
            
            else {
                vetor[i] = auxiliar[dir++];
                numAssignments++;
            }
            numComparison++;
            numAssignments++;
        }
    }
}