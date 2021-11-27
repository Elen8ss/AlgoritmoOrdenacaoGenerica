package CriarVetores;

public class KeyDoubleValueInteger implements Comparable{
    private Double key;
    private Integer value;
    
    public int compareTo(Object o) {
        KeyDoubleValueInteger keyDouble = (KeyDoubleValueInteger) o;

        return this.key.compareTo(keyDouble.getKey());
    }

    public Double getKey() {
        return key;
    }
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
    public void setKey(Double key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "\nkey: " + this.key +
               " value: " + this.value;
    }
}
