
// Tipo enum com cada algoritmo
// Com o uso do TipoAlg.values()[alg]; e retornado o tipo escolhido
// Depois a função obterAlg() é utilizada para obter o objeto do algoritmo 
public enum TipoAlg {
    MERGE {
        @Override
        public <T> StrategeySort obterAlg() {
            return new MergeSortGenerics<>();
        }
    };

    public abstract <T> StrategeySort obterAlg();


}
