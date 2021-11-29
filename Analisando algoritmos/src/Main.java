import java.util.InputMismatchException;
import java.util.Scanner;
import CriarVetores.*;


public class Main {
    public static void main(String[] args) {
        int op = 1;
        int[] tamanhoVetor = {1000,100000,1000000};
        int tamanhoDoVetor = 0;
        int tipoDeVetor = 0;
        // Vetor com valores para escolhas do algoritmo
        int[] entradas = {0,1,0,0};
        KeyStringValueDouble[] copiaStringsValueDouble = {};
        KeyDoubleValueString[] copiaDoubleValueString = {};
        KeyDoubleValueInteger[] copiaDoubleValueInteger = {};
        boolean existeVetor = false;
        Scanner ler = new Scanner(System.in);
        System.out.println("\n----------------------");
        System.out.println("Ordenação de vetores");
        System.out.println("----------------------");
    
        String[] opTipoDeVetor = {"\nEscolha o tipo de vetor para ordenar","1- Key String - value Double","2- Key Double - value String","3- Key Double - value Integer"};
        String[] opTamanhoDoVetor = {"\nEscolha o tamanho do vetor","1-1000","2-100000","3-1000000"};
        
        // Criando o objeto context que se comunica com a StrategeySort(interface) para executar o algoritmo escolhido pelo TipoAlg(enum)
        Context ordenar = new Context();
        int i = 0;
        tamanhoDoVetor = validarValores(opTamanhoDoVetor, 3);
        int vetTipo = tamanhoDoVetor;
        tipoDeVetor = validarValores(opTipoDeVetor, 3);
        int aquecimento = 0;

        if (tamanhoDoVetor == 0) {
            aquecimento = 1000;
        }
        if (tamanhoDoVetor == 1) {
            aquecimento = 50;
        }
        if (tamanhoDoVetor == 2) {
            aquecimento = 5;
        }
        tamanhoDoVetor = tamanhoVetor[tamanhoDoVetor];

        do {
            if (entradas[1] == 7 && entradas[0] == 0) {
                break;
            }
            int order = entradas[0];//validarValores(opOrder, 2);
        
            int alg = entradas[1];//validarValores(opAlg, 7);
            alg = 2*alg+order;
            
            
            // Cria o TipoAlg(enum) para escolher o algoritmo
            // tipoAlg.obeterAlg() executa a função abstrata do tipo escolhido
            TipoAlg tipoAlg = TipoAlg.values()[alg];
            // Ordena o o tipo de vetor escolhido com a estratégia escolhida
            ordenar.trocarDeEstrategia(tipoAlg.obterAlg());

            if (i > aquecimento) {
                System.out.println("\nTamanho entrada: "+ opTamanhoDoVetor[vetTipo]);
                System.out.println("Tipo de vetor " + opTipoDeVetor[tipoDeVetor]);
            }


            if (tipoDeVetor == 0) {
                KeyStringValueDouble[] arrayKeyStringValueDouble = new KeyStringValueDouble[tamanhoDoVetor];
                if (!existeVetor) {
                    GeraVetores.createArrayKeyStringValueDouble(arrayKeyStringValueDouble);
                    copiaStringsValueDouble = arrayKeyStringValueDouble.clone();
                } else {
                    arrayKeyStringValueDouble = copiaStringsValueDouble.clone();
                }
                
                long starTime = System.nanoTime();
                ordenar.ordenarVet(arrayKeyStringValueDouble);
                long endTime = System.nanoTime();
                if (i > aquecimento) {
                    System.out.println((endTime - starTime));
                    System.out.println("Tempo de execução: " + ((endTime - starTime)/1000000) + " ms");
                }
            }
            
            if (tipoDeVetor == 1) {
                KeyDoubleValueString[] arrayKeyDoubleValueString = new KeyDoubleValueString[tamanhoDoVetor];
                if (!existeVetor) {
                    GeraVetores.createArrayKeyDoubleValueString(arrayKeyDoubleValueString);
                    copiaDoubleValueString = arrayKeyDoubleValueString.clone();
                } else {
                    arrayKeyDoubleValueString = copiaDoubleValueString.clone();
                }
                long starTime = System.nanoTime();
                ordenar.ordenarVet(arrayKeyDoubleValueString);
                long endTime = System.nanoTime();
                if (i > aquecimento) {
                    System.out.println((endTime - starTime));
                    System.out.println("Tempo de execução: " + ((endTime - starTime)/1000000) + " ms");
                }
            }
            
            if (tipoDeVetor == 2) {
                KeyDoubleValueInteger[] arrayKeyDoubleValueIntegers = new KeyDoubleValueInteger[tamanhoDoVetor];
                if (!existeVetor) {
                    GeraVetores.createArrayKeyDoubleValueInteger(arrayKeyDoubleValueIntegers);
                    copiaDoubleValueInteger = arrayKeyDoubleValueIntegers.clone();
                } else {
                    arrayKeyDoubleValueIntegers = copiaDoubleValueInteger.clone();
                }
                long starTime = System.nanoTime();
                ordenar.ordenarVet(arrayKeyDoubleValueIntegers);
                long endTime = System.nanoTime();
                if (i > aquecimento) {
                    System.out.println((endTime - starTime));
                    System.out.println("Tempo de execução: " + ((endTime - starTime)/1000000) + " ms");
                }
            }
            existeVetor = true;           
            System.out.println("\ni: " + i);
            if (i > aquecimento) {
                
                if (entradas[0] == 0) {
                    entradas[0] = 1;
                } else {
                    entradas[0] = 0;
                    entradas[1]++;
                }
               System.out.println("\nSe deseja continuar digite um número maior que 0");
                try {
                    op = ler.nextInt();
                } catch (InputMismatchException exception) {
                    op = -1;
                } 
                i = 0;
            } else {
                i++;
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
            while (opction >= quantidadeEntradas || opction < 0) {
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
    