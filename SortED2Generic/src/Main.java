import java.util.Arrays;
import java.util.Scanner;
import CriarVetores.GeraVetores;



public class Main {
    public static void main(String[] args) {
        int op = 0;
        int[] tamanhoVetor = {100,1000,1000000};
        Scanner ler = new Scanner(System.in);
        System.out.println("\n----------------------");
        System.out.println("Ordenação de vetores");
        System.out.println("----------------------");
        
        String[] opOrder = {"1 - Ordenar o vetor em ordem crecente","2 - Ordenar o vetor em ordem decrecente\n"};
        String[] opAlg = {"\n\nEscolha o algoritmo para ordenar o vetor\n","1 - Merge Sort","2 - Quick Sort","3 - Heap Sort","4 - Tree Sort"};
        String[] opTipoDeVetor = {"Escolha o tipo de vetor para ordenar","1-String","2-Integer","3-Double"};
        String[] opTamanhoDoVetor = {"Escolha o tamanho do vetor","1-100","2-1000","3-1000000"};
        
        // Criando o objeto context que se comunica com a StrategeySort(interface) para executar o algoritmo escolhido pelo TipoAlg(enum)
        Context ordenar = new Context();

        do {
            // Entrada de dados
            for (String t : opOrder) {
                System.out.println(t);
            }
            int order = ler.nextInt()-1;

            for (String t : opAlg) {
                System.out.println(t);
            }
            int alg = ler.nextInt() - 1;
            
            for (String t : opTamanhoDoVetor) {
                System.out.println(t);
            }
            int tamanhoDoVetor = tamanhoVetor[ler.nextInt()-1];

            for (String t : opTipoDeVetor) {
                System.out.println(t);
            }
            int tipoDeVetor = ler.nextInt()-1;

            
            // Cria o TipoAlg(enum) para escolher o algoritmo
            TipoAlg tipoAlg = TipoAlg.values()[alg];
            // tipoAlg.obeterAlg() executa a função abstrata do tipo escolhido
            ordenar.trocarDeEstrategia(tipoAlg.obterAlg());

            // Ordena o o tipo de vetor escolhido com a estratégia escolhida
            if (tipoDeVetor == 0) {
                String[] vetorStrings = new String[tamanhoDoVetor];
                GeraVetores.createArrayString(vetorStrings);
                ordenar.ordenarVet(vetorStrings);
                System.out.println("\n\nOrdenando Strings: " + Arrays.toString(vetorStrings));
            }
            if (tipoDeVetor == 1) {
                Integer[] vetorInteger = new Integer[tamanhoDoVetor];
                GeraVetores.createArrayInteger(vetorInteger);
                ordenar.ordenarVet(vetorInteger);
                System.out.println("Ordenando Integers: " + Arrays.toString(vetorInteger));
            }
            if (tipoDeVetor == 2) {
                Double[] vetorDouble = new Double[tamanhoDoVetor];
                GeraVetores.createArrayDouble(vetorDouble);
                ordenar.ordenarVet(vetorDouble);
                System.out.println("Ordenando Doubles: " + Arrays.toString(vetorDouble));
            }


    
           

            System.out.println("\n__Se deseja continuar digite um número maior que 0");
            op = ler.nextInt();

        } while (op > 0);
        
    }
}
    