package AlgsSort;

import java.lang.reflect.Array;

//classe generica que possui como parametro um elemento do tipo T
public class TreeSort <T extends Comparable<? super T>> implements StrategeySort<T> {
    
    private Node raiz; 

    @Override
    public void sort(T[] array) {
        raiz = null;
        treeSort(array);  
    }
    
    void treeSort(T array[]) { 
        int i;
        for(i = 0; i < array.length; i++) { 
            insert(array[i]); 
        }   
        i = 0;
        emOrdemSimetrica(raiz, array, i);
    } 

    // Classe para árvore binária de pesquisa
    public class Node  { 
        T key; 
        Node esqr, dir; 
  
        public Node(T array) { 
            key = array; 
            esqr = null; 
            dir = null;
        } 
    } 
  
    // raiz
  
  
    // funcao insert chama metodo insertRec() 
    void insert(T item) { 
        raiz = insertRec(raiz, item); 
    } 

    //A função recursiva insere uma nova chave na arvore
    Node insertRec(Node raiz, T item)  { 
        // Se a árvore estiver vazia, retornar um novo nó 
        if (raiz == null)  { 
            raiz = new Node(item); 
            return raiz; 
        } 
  
       // Caso contrario, descer da arvore
        if (item.compareTo(raiz.key) < 0) {
            raiz.esqr = insertRec(raiz.esqr, item); 
        
        //Mova para a direita para um valor maior do que o nó pai
        }else if (item.compareTo(raiz.key) > 0) {
            raiz.dir = insertRec(raiz.dir, item);  
        }
        return raiz; 
    } 
      
    // travessia em Ordem Recursiva da arvore
    void emOrdemSimetrica(Node raiz,T[] array, int i)  { 
        if (raiz != null) { 
            emOrdemSimetrica(raiz.esqr, array, i); 
            System.out.print(raiz.key + " \n"); 
            array[i++] = raiz.key;
            emOrdemSimetrica(raiz.dir, array, i); 
        }
            
    } 

 
    
}
