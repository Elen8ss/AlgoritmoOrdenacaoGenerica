package AlgsSort;
import java.util.Arrays;

public class JavaMetodo <T extends Comparable<? super T>> implements StrategeySort<T>{
    
    @Override
    public void sort(T[] array) {
        Arrays.sort(array);
    }
    
}
