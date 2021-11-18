package CriarVetores;

import java.util.Random;

public class GeraVetores {
    
    public static void createArrayDouble(Double[] array) {
        Random gerar = new Random();
        for (int i = 0; i < array.length; i++) {
          array[i] = gerar.nextDouble()*29;
        }
    }
      
    public static void createArrayInteger(Integer[] array) {
    Random gerar = new Random();
    for (int i = 0; i < array.length; i++) {
        array[i] = gerar.nextInt();
    }
    }
    
    public static void createArrayString(String[] array) {
    String[] letra = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    Random gerar = new Random();

    for (int i = 0; i < array.length; i++) {

        array[i] = letra[gerar.nextInt(52)];
        for (int j = 0; j < 10; j++) {
            array[i] += letra[gerar.nextInt(52)];
        }
    }
    }
}
