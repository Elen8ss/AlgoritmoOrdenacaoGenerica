package AlgsSort;

public class InsertSort implements StrategeySort<T> {

    void Sort(T[] vet) {
		int i,j;
        T chave;
		
		for(i = 1; i <= vet.length-1; i++) {
			chave = vet[i];
			// compareTO => Se a chave for menor retorna int < 0
			for(j = i-1; j>=0 && chave.compareTo(vet[j]) < 0; j--) {
				vet[j+1] = vet[j];
			}
			vet[j+1] = chave;
		}
	}
}

 