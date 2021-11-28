package AlgsSort;
import java.util.Arrays;
import java.util.Collections;

public class JavaMetodoDecreasing <T extends Comparable<? super T>> implements StrategeySort<T>{
    
    @Override
    public void sort(T[] array) {
        System.out.println("Java método crescente");
        Arrays.sort(array, Collections.reverseOrder());
    }
    
}
