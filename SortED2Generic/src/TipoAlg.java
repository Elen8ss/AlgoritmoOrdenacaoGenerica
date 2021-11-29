import AlgsSort.*;
// Tipo enum com cada algoritmo
// Com o uso do TipoAlg.values()[alg]; e retornado o tipo escolhido
// Depois a função obterAlg() é utilizada para obter o objeto do algoritmo 
public enum TipoAlg {
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
    TREE {
        @Override
        public <T> StrategeySort obterAlg(){
            return new TreeSort<>();
        }
    };

    public abstract <T> StrategeySort obterAlg();


}