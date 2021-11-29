package CriarVetores;

import java.util.Random;

public class GeraVetores {
    
    
    public static void createArrayKeyStringValueDouble(KeyStringValueDouble[] array) {
        String[] letra = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        Random gerar = new Random();
        
        for (int i = 0; i < array.length; i++) {
            array[i] = new KeyStringValueDouble();
            String valores = letra[gerar.nextInt(52)];
            for (int j = 0; j <= 10; j++) {
                valores += letra[gerar.nextInt(52)];
            }
            array[i].setKey(valores);
            array[i].setValue(gerar.nextDouble()*29);
        }
    }
    
    public static void createArrayKeyDoubleValueString(KeyDoubleValueString[] array) {
        String[] letra = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        Random gerar = new Random();
        
        for (int i = 0; i < array.length; i++) {
            array[i] = new KeyDoubleValueString();
            String valores = letra[gerar.nextInt(52)];
            for (int j = 0; j <= 10; j++) {
                valores += letra[gerar.nextInt(52)];
            }
            array[i].setKey(gerar.nextDouble()*29);
            array[i].setValue(valores);
        }
    }

    public static void createArrayKeyDoubleValueInteger(KeyDoubleValueInteger[] array) {
        Random gerar = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = new KeyDoubleValueInteger();
            
            array[i].setKey(gerar.nextDouble()*32);
            array[i].setValue(gerar.nextInt());
        }
    }
}
