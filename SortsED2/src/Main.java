import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int op = 1;

        Scanner ler = new Scanner(System.in);
        System.out.println("Ordenação de vetores\n-------");
        
        String[] opOreder = {"1-Ordenar o vetor em ordem crecente\n","2-Ordenar o vetor em ordem decrecente\n"};
        String[] opAlg = {"Escolha o algoritmo para ordenar o vetor\n","1-Merge Sort","2-Quick Sort","3-Insert Sort","4-Heap Sort"};
        int[] array = {12, 11, 15, 10, 9, 8, 2, 3, 13, 14, 4, 5, 6, 7, 1};
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

            // Utiliza o tipo enum para escolher o algoritmo
            // tipoAlg.obeterAlg() executa a função abstrata do tipo escolhido
            TipoAlg tipoAlg = TipoAlg.values()[alg];
            ordenar.trocarDeEstrategia(tipoAlg.obterAlg());

            ordenar.ordenarVet(array);

            System.out.println(java.util.Arrays.toString(array));
            System.out.println("Se deseja continuar digite um número maior que 0");
            op = ler.nextInt();

        } while (op > 0);
        
    }
}