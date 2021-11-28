package AlgsSort;
import java.util.Arrays;

public class JavaMetodo <T extends Comparable<? super T>> implements StrategeySort<T>{
    
    @Override
    public void sort(T[] array) {
        System.out.println("Java método crescente");
        Arrays.sort(array);
    }
    
}
