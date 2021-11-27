package AlgsSort;

//classe generica que possui como parametro um elemento do tipo T
public class MergeInsertDecreasing <T extends Comparable<? super T>> implements StrategeySort<T>{

    private static int numComparison;
    private static int numAssignments;
    @Override
    public void sort(T[] array) {
        numComparison = 0; 
        numAssignments = 0;        
        T[] auxArray = (T[]) new Comparable[array.length];
        mergeInsertSort(array, auxArray,  0, array.length - 1);
        System.out.println("num de comparações Merge Insert Decrescente:" + numComparison);
        System.out.println("num de atribuições Merge Insert Decrescente:" + numAssignments);
        System.out.println("Total: " + (numAssignments + numComparison));
    }
    
    // funcao MergerSort
    private static <T extends Comparable<? super T>>  void mergeInsertSort(T[] vetor, T[] auxiliar,  int inicio, int fim){
        if (inicio < fim){
            int meio = (inicio + fim)/2; 
            numAssignments++;
            mergeInsertSort(vetor, auxiliar, inicio, meio); 
            mergeInsertSort(vetor, auxiliar, meio+1, fim); 
	    
            if (fim - inicio > 13) {
                intercalar(vetor, auxiliar, inicio, meio, fim);
            } else {
                insertSort(vetor, inicio, fim);
            }
            numComparison++;
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

    private static <T extends Comparable<? super T>> void insertSort(T[] array, int inicio, int fim) {
        T aux;
        
        numAssignments++;
        numComparison++;
        for (int i=inicio+1; i <= fim; i++){
            aux = array[i]; 
	        int j = i-1; 
            numAssignments+=2;

            numComparison++;
            while (j >= inicio){ 
                if (array[j].compareTo(aux) < 0) {
                    array[j+1] = array[j]; 
                    j--;
                    numAssignments+=2;
                } else {
                    break;
                }
                numComparison+=2;
            }
            array[j+1] = aux; 
            numAssignments+=2;
            numComparison++;
        }
    }
}