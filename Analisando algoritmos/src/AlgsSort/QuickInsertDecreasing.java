package AlgsSort;

public class QuickInsertDecreasing <T extends Comparable<? super T>> implements StrategeySort<T> {
    private static int numComparison;
    private static int numAssignments;

    @Override
    public void sort(T[] array) {
        numComparison = 0; 
        numAssignments = 0;
        quickSort(array, 0, array.length-1);   
        System.out.println("num de comparações Quick Insert Decrescente:" + numComparison);
        System.out.println("num de atribuições Quick Insert Decrescente:" + numAssignments);
        System.out.println("Total: " + (numAssignments + numComparison));
    }

    void quickSort(T []vet, int inicio, int fim) {
        if (inicio < fim) {
            if (fim  - inicio > 10) {

                int posicaoPivo = particiona(vet, inicio, fim);
                numAssignments++;
                quickSort(vet,  inicio, posicaoPivo - 1);
                quickSort(vet,  posicaoPivo + 1, fim);
            } else {
                insertSort(vet, inicio, fim);
            }
            numComparison++;
        }
        numComparison++;
    }

    int particiona (T []vet, int inicio, int fim) {
        T pivo = vet[inicio];
        int i = inicio + 1, f = fim;
        numAssignments+=3;

        numComparison++;
        while (i <= f) {

            // Se o valor da parte esquerda do vetor for menor que o pivô.
            if (vet[i].compareTo(pivo) > 0) {
                i++;
                numComparison++;
                numAssignments++;
            } 
            // Se o valor da parte direita do vetor for maior que o pivô.
            else if (vet[f].compareTo(pivo) < 0) {
                f--;
                numComparison+=2;
                numAssignments++;
            } else {
                T troca = vet[i];
                vet[i] = vet[f];
                vet[f] = troca;
                i++;
                f--;
                numComparison+=2;
                numAssignments+=5;
            } 
            numComparison++;          
        }
        // Troca o pivo com o elemento mais a direita que é menor que ele.
        vet[inicio] = vet[f];
        vet[f] = pivo;
        numAssignments+=2;
        return f;
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
            numAssignments++;
            numComparison+=2;
        }
    }
}
