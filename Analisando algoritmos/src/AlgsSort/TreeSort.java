package AlgsSort;

//classe generica que possui como parametro um elemento do tipo T
public class TreeSort <T extends Comparable<? super T>> implements StrategeySort<T> {
    private static int numComparison;
    private static int numAssignments;
    private Node raiz; 

    @Override
    public void sort(T[] array) {
        numComparison = 0; 
        numAssignments = 0;
        raiz = null;
        treeSort(array);  
        System.out.println("num de comparações Treee Sort Crescente:" + numComparison);
        System.out.println("num de atribuições Tree Sort Crescente:" + numAssignments);
        System.out.println("Total: " + (numAssignments + numComparison));
    }
    
    void treeSort(T array[]) { 
        int i;
        numAssignments++;
        numComparison++;
        for(i = 0; i < array.length; i++) { 
            insert(array[i]); 
            numAssignments++;
            numComparison++;
        }   
        i = 0;
        numAssignments++;
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
            numAssignments+=3;
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
            numAssignments++;
            return raiz; 
        } 
  
       // Caso contrario, descer da arvore
        if (item.compareTo(raiz.key) < 0) {
            raiz.esqr = insertRec(raiz.esqr, item); 
            numAssignments++;
            numComparison++;
        
        //Mova para a direita para um valor maior do que o nó pai
        }else if (item.compareTo(raiz.key) > 0) {
            raiz.dir = insertRec(raiz.dir, item);
            numAssignments++;
            numComparison+=2;  
        } else {
            numComparison+=2;
        }
        return raiz; 
    } 
      
    // travessia em Ordem Recursiva da arvore
    void emOrdemSimetrica(Node raiz,T[] array, int i)  { 
        if (raiz != null) { 
            emOrdemSimetrica(raiz.esqr, array, i); 
            // System.out.print(raiz.key + " \n"); 
            array[i++] = raiz.key;
            numAssignments++;
            emOrdemSimetrica(raiz.dir, array, i); 
        }
            
    } 

 
    
}
