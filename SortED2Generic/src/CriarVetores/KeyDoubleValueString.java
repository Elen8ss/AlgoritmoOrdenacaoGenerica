package CriarVetores;

public class KeyDoubleValueString implements Comparable{
    private Double key;
    private String value;
    
    public int compareTo(Object o) {
        KeyDoubleValueString keyDouble = (KeyDoubleValueString) o;

        return this.key.compareTo(keyDouble.getKey());
    }

    public Double getKey() {
        return key;
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
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
