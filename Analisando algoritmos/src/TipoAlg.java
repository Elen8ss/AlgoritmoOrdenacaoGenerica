import AlgsSort.*;
// Tipo enum com cada algoritmo
// Com o uso do TipoAlg.values()[alg]; e retornado o tipo escolhido
// Depois a função obterAlg() é utilizada para obter o objeto do algoritmo 
public enum TipoAlg {
    MERGESORT {
        @Override
        public <T> StrategeySort obterAlg() {
            return new MergeSort<>();
        }
    },
    MERGESORTDECREASING {
        @Override
        public <T> StrategeySort obterAlg() {
            return new MergeSortDecreasing<>();
        }
    },
    MERGEINSERT {
        @Override
        public <T> StrategeySort obterAlg() {
            return new MergeInsert<>();
        }
    },
    MERGEINSERTDECREASING {
        @Override
        public <T> StrategeySort obterAlg() {
            return new MergeInsertDecreasing<>();
        }
    },
    QUICKSORT  {
        @Override
        public <T> StrategeySort obterAlg(){
            return new QuickSort<>();
        }
    },
    QUICKSORTDECREASING  {
        @Override
        public <T> StrategeySort obterAlg(){
            return new QuickSortDecreasing<>();
        }
    },
    QUICKINSERT  {
        @Override
        public <T> StrategeySort obterAlg(){
            return new QuickInsert<>();
        }
    },
    QUICKINSERTDECREASING  {
        @Override
        public <T> StrategeySort obterAlg(){
            return new QuickInsertDecreasing<>();
        }
    },
    HEAPSORT {
        @Override
        public <T> StrategeySort obterAlg(){
            return new HeapSort<>();
        }
    },
    HEAPSORTDECREASING {
        @Override
        public <T> StrategeySort obterAlg(){
            return new HeapSortDecreasing<>();
        }
    },
    TREESORT {
        @Override
        public <T> StrategeySort obterAlg(){
            return new TreeSort<>();
        }
    },
    TREESORTDECREASING {
        @Override
        public <T> StrategeySort obterAlg(){
            return new TreeSortDecreasing<>();
        }
    },
    JAVAMETODO {
        @Override
        public <T> StrategeySort obterAlg(){
            return new JavaMetodo<>();
        }
    };

    public abstract <T> StrategeySort obterAlg();

}