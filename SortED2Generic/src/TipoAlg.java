import AlgsSort.*;
// Tipo enum com cada algoritmo
// Com o uso do TipoAlg.values()[alg]; e retornado o tipo escolhido
// Depois a função obterAlg() é utilizada para obter o objeto do algoritmo 
public enum TipoAlg {
    MERGE {
        @Override
        public <T> StrategeySort obterAlg() {
            return new MergeInsert<>();
        }
    },
    QUICK  {
        @Override
        public <T> StrategeySort obterAlg(){
            return new QuickInsertSort<>();
        }
    },
    HEAP {
        @Override
        public <T> StrategeySort obterAlg(){
            return new HeapSortGenerics<>();
        }
    }
    ;
    // TREE {
    //     @Override
    //     public <T> StrategeySort obterAlg(){
    //         return new TreeSortGenerics<>();
    //     }
    // };

    public abstract <T> StrategeySort obterAlg();


}