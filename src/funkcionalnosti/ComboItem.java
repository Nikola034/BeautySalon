package funkcionalnosti;

public class ComboItem
{
    private int key;
    private String value;

    public ComboItem(int key, String value)
    {
        this.key = key;
        this.value = value;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return value;
    }

    public int getKey()
    {
        return key;
    }

    public String getValue()
    {
        return value;
    }
}
