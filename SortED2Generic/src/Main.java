
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int op = 1;

        Scanner ler = new Scanner(System.in);
        System.out.println("\n----------------------");
        System.out.println("Ordenação de vetores");
        System.out.println("----------------------");
        
        String[] opOreder = {"1 - Ordenar o vetor em ordem crecente","2 - Ordenar o vetor em ordem decrecente\n"};
        String[] opAlg = {"\n\nEscolha o algoritmo para ordenar o vetor\n","1 - Merge Sort","2 - Quick Sort","3 - Heap Sort","4 - Tree Sort"};
        
        Integer[] vetorDeInteger = {12, 11, 15, 10, 9, 8, 2, 3, 13, 14, 4, 5, 6, 7, 1};



        String[] vetorDeStrings = {"Alice", "Luana", "Nelza", "Karen", "Mirian","Samuel", "Denner", "Ramires","Livian", "Neferides", "Tulio", "Demetrice", "Azenate"};

        // Criando o objeto context que se comunica com a StrategeySort(interface) para executar o algoritmo escolhido pelo TipoAlg(enum)
        Context ordenar = new Context();

        do {

            for (String t : opOreder) {
                System.out.println(t);
            }
            int order = ler.nextInt()-1;

            for (String t : opAlg) {
                System.out.println(t);
            }
            int alg = ler.nextInt() - 1;

            // Cria o TipoAlg(enum) para escolher o algoritmo
            TipoAlg tipoAlg = TipoAlg.values()[alg];
            // tipoAlg.obeterAlg() executa a função abstrata do tipo escolhido
            ordenar.trocarDeEstrategia(tipoAlg.obterAlg());

            // Ordena o vetor com a estratégia escolhida
            ordenar.ordenarVet(vetorDeStrings); //Ordena String
            ordenar.ordenarVet(vetorDeInteger); //Ordena Integer

            System.out.println("\n\nOrdenando Strings: " + Arrays.toString(vetorDeStrings));
            System.out.println("Ordenando Integers: " + Arrays.toString(vetorDeInteger));

            System.out.println("\n__Se deseja continuar digite um número maior que 0");
            op = ler.nextInt();

        } while (op > 0);
        
    }
}
    