
public class Context {
    // O tipo da interface é declarado
    StrategeySort estrategiaAlg;

    // Aqui é onde a estratégia é executada
    public <T> void ordenarVet(T[] vet, T[] auxVet) {
        estrategiaAlg.sort(vet, auxVet);
    }

    // Função para alterar o tipo de estratégia utilizada
    public void trocarDeEstrategia(StrategeySort estrategiaAlg) {
        this.estrategiaAlg = estrategiaAlg;
    }
}
