
//classe generica que possui como parametro um elemento do tipo T
public class InsertSortGenerics <T extends Comparable<? super T>> implements StrategeySort<T>{

    // funcao InsertSort
    private static <T extends Comparable<? super T>> void insertSort(T[] array, T[] auxArray, int i, int j) {
        T aux;
        //percorrendo o array
        for (i=1; i<array.length; i++){
            aux = array[i]; //auxiliar recebe o elemento da posicao i
            j = i-1; //j recebe a posicao anterior de i
            while (j >= 0 && array[j].compareTo(aux) > 0){ //loop que percorre o array enquanto j for menor que zero e o vetor na posicao j seja maior que o auxiliar
                array[j+1] = array[j]; //joga o elemento para a posicao a frente
                j--;
            }
            array[j+1] = aux; //coloca o valor de aux na posicao correta no array
        }
    }

    @Override
    public void sort(T[] array, T[] auxArray) {
        insertSort(array, auxArray,  0, array.length - 1);
        
    }

}
