package CriarVetores;


public class KeyStringValueDouble implements Comparable{
    private String key;
    private Double value;
    
    public int compareTo(Object o) {
        KeyStringValueDouble keyString = (KeyStringValueDouble) o;

        return this.key.compareTo(keyString.getKey());
    }

    public String getKey() {
        return key;
    }
    public Double getValue() {
        return value;
    }
    
    public void setValue(Double value) {
        this.value = value;
    }
    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "\nkey: " + this.key +
               " value: " + this.value;
    }
}
