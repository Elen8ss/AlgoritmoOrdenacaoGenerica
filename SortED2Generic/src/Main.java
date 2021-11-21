import java.lang.reflect.Executable;
import java.util.Arrays;
import java.util.Scanner;
import CriarVetores.GeraVetores;



public class Main {
    public static void main(String[] args) {
        int op = 0;
        int[] tamanhoVetor = {10,100000,1000000};
        int tamanhoDoVetor = 0;
        int tipoDeVetor = 0;
        String[] copiaStrings = {};
        Integer[] copiaInteger = {};
        Double[] copiaDouble = {};
        boolean existeVetor = false;
        Scanner ler = new Scanner(System.in);
        System.out.println("\n----------------------");
        System.out.println("Ordenação de vetores");
        System.out.println("----------------------");
        
        // String[] opOrder = {"1 - Ordenar o vetor em ordem crecente","2 - Ordenar o vetor em ordem decrecente\n"};
        String[] opAlg = {"\n\nEscolha o algoritmo para ordenar o vetor\n","1 - Merge Sort","2 - Merge Insert","3 - Quick Sort","4 - Quick Insert"};
        String[] opTipoDeVetor = {"Escolha o tipo de vetor para ordenar","1-String","2-Integer","3-Double"};
        String[] opTamanhoDoVetor = {"Escolha o tamanho do vetor","1-1000","2-100000","3-1000000"};
        
        // Criando o objeto context que se comunica com a StrategeySort(interface) para executar o algoritmo escolhido pelo TipoAlg(enum)
        Context ordenar = new Context();

        do {
            // Entrada de dados
            // for (String t : opOrder) {
            //     System.out.println(t);
            // }
            // int order = ler.nextInt()-1;
            
            for (String t : opAlg) {
                System.out.println(t);
            }
            int alg = ler.nextInt() - 1;
            if (existeVetor) {
                System.out.println("\nEscolha uma opção\n1-Continuar com o mesmo vetor\n2-Criar outro vetor");
        
                if (ler.nextInt()-1 == 1) {
                   existeVetor = false; 
                }
            }
            if (!existeVetor) {
                for (String t : opTamanhoDoVetor) {
                    System.out.println(t);
                }
                tamanhoDoVetor = tamanhoVetor[ler.nextInt()-1];
    
                for (String t : opTipoDeVetor) {
                    System.out.println(t);
                }
                tipoDeVetor = ler.nextInt()-1;
            }

            
            // Cria o TipoAlg(enum) para escolher o algoritmo
            TipoAlg tipoAlg = TipoAlg.values()[alg];
            // tipoAlg.obeterAlg() executa a função abstrata do tipo escolhido
            ordenar.trocarDeEstrategia(tipoAlg.obterAlg());

            // Ordena o o tipo de vetor escolhido com a estratégia escolhida
            if (tipoDeVetor == 0) {
                String[] vetorStrings = new String[tamanhoDoVetor];
                if (!existeVetor) {
                    GeraVetores.createArrayString(vetorStrings);
                    copiaStrings = vetorStrings.clone();
                } else {
                    vetorStrings = copiaStrings.clone();
                }
                long startTime = System.currentTimeMillis();
                // System.out.println("\n\nOrdenando Strings: " + Arrays.toString(vetorStrings));
                ordenar.ordenarVet(vetorStrings);
                long endTime = System.currentTimeMillis();
                System.out.println("Total execution time: " + (endTime-startTime) + "ms");
                // System.ou1t.println("\n\nOrdenando Strings: " + Arrays.toString(vetorStrings));
            }
            if (tipoDeVetor == 1) {
                Integer[] vetorInteger = new Integer[tamanhoDoVetor];
                if (!existeVetor) {
                    GeraVetores.createArrayInteger(vetorInteger);
                    copiaInteger = vetorInteger.clone();
                } else {
                    vetorInteger = copiaInteger.clone();
                }
                ordenar.ordenarVet(vetorInteger);
                System.out.println("Ordenando Integers: " + Arrays.toString(vetorInteger));
            }
            if (tipoDeVetor == 2) {
                Double[] vetorDouble = new Double[tamanhoDoVetor];
                if (!existeVetor) {
                    GeraVetores.createArrayDouble(vetorDouble);
                    copiaDouble = vetorDouble.clone();
                } else {
                    vetorDouble = copiaDouble.clone();
                }
                ordenar.ordenarVet(vetorDouble);
                System.out.println("Ordenando Doubles: " + Arrays.toString(vetorDouble));
            }
            existeVetor = true;
           

            System.out.println("\n__Se deseja continuar digite um número maior que 0");
            op = ler.nextInt();

        } while (op > 0);
        ler.close();
    }
}
    
