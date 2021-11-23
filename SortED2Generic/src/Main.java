import java.lang.StackWalker.Option;
import java.lang.reflect.Executable;
import java.util.Arrays;
import java.util.InputMismatchException;
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
        String[] opAlg = {"\nEscolha o algoritmo para ordenar o vetor\n","1 - Merge Sort","2 - Merge Insert","3 - Quick Sort","4 - Quick Insert"};
        String[] opTipoDeVetor = {"\nEscolha o tipo de vetor para ordenar","1-String","2-Integer","3-Double"};
        String[] opTamanhoDoVetor = {"\nEscolha o tamanho do vetor","1-1000","2-100000","3-1000000"};
        String[] opExisteVetor = {"\nEscolha uma opção","1-Continuar com o mesmo vetor","2-Criar outro vetor"};
        
        // Criando o objeto context que se comunica com a StrategeySort(interface) para executar o algoritmo escolhido pelo TipoAlg(enum)
        Context ordenar = new Context();

        do {
            // int order = validarValores(opOrder, 2);
            
            int alg = validarValores(opAlg, 4);
            
            if (existeVetor) {
                
                if (validarValores(opExisteVetor, 2) == 1) {
                   existeVetor = false; 
                }
            }
            
            if (!existeVetor) {
                tamanhoDoVetor = tamanhoVetor[validarValores(opTamanhoDoVetor, 3)];
                
                tipoDeVetor = validarValores(opTipoDeVetor, 3);
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
                // long startTime = System.currentTimeMillis();
                // System.out.println("\n\nOrdenando Strings: " + Arrays.toString(vetorStrings));
                ordenar.ordenarVet(vetorStrings);
                // long endTime = System.currentTimeMillis();
                // System.out.println("Total execution time: " + (endTime-startTime) + "ms");
                System.out.println("\n\nOrdenando Strings: " + Arrays.toString(vetorStrings));
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

            System.out.println("\nSe deseja continuar digite um número maior que 0");
            try {
                op = ler.nextInt();
            } catch (InputMismatchException exception) {
                op = -1;
            }
            
        } while (op > 0);
        ler.close();
    }

    public static int validarValores(String[] frase, int quantidadeEntradas) {
        int opction = 0;
        Scanner read = new Scanner(System.in);
        try {
            for (String t : frase) {
                System.out.println(t);
            }
            opction = read.nextInt()-1;
            while (opction >=quantidadeEntradas || opction < 0) {
                System.out.println("Digite uma opção válida");
                opction = read.nextInt()-1;
            }
        } catch (InputMismatchException exception) {
            System.out.println("\nDigite um número por favor\n");
            opction = validarValores(frase, quantidadeEntradas);
        }
        // read.close();
        return opction;
    }
}
    
