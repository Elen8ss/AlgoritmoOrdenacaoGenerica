import AlgsSort.StrategeySort;

public class Context{
   
    StrategeySort estrategiaAlg;

    public <T> void ordenarVet(T[] vet) {
        estrategiaAlg.sort(vet);
    }

    public void trocarDeEstrategia(StrategeySort estrategiaAlg) {
        this.estrategiaAlg = estrategiaAlg;
    }
}