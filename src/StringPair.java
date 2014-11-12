
// a object that uses 2 strings to present, 
// not sequence sensitive, not case sensitive

public class StringPair {
	String[] values;
	
	StringPair() {
		init("","");
	}
	
	StringPair(String v1,String v2) {
		init(v1,v2);
	}
	
	void init(String v1,String v2)
	{
		values = new String[2];
		values[0]=v1;
		values[1]=v2;
	}
	
	public int hashCode()
	{
		return values[0].toUpperCase().hashCode()+values[1].toUpperCase().hashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof StringPair) {
			StringPair gt=(StringPair)obj;
			if(	values[0].equalsIgnoreCase(gt.values[0]) && values[1].equalsIgnoreCase(gt.values[1]) ||
				values[0].equalsIgnoreCase(gt.values[1]) && values[1].equalsIgnoreCase(gt.values[0]) ) {
				return true;
			}
		}
		return false;
	}

	public String toString(){
		return values[0]+"/"+values[1];
	}
	
	public static void main(String[] args) {
		StringPair gt1 = new StringPair("GAAC","C");
		System.out.printf("hash 1=%d\n", gt1.hashCode());
		StringPair gt2 = new StringPair("c","gaac");
		System.out.printf("hash 2=%d\n", gt2.hashCode());
		
		if(gt1.equals(gt2)) {
			System.out.printf("Same\n");
		}
		else
			System.out.printf("Different\n");
	}
	
}
