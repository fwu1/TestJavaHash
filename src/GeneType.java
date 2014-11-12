
public class GeneType {
	String geneID;
	Object value;
	
	public GeneType() {
		geneID=null;
		value=null;
	}
	
	public GeneType(String id,String v) {
		geneID=id;
		value=v;
	}
	
	public GeneType(String id,StringPair v) {
		geneID=id;
		value=v;
	}

	public GeneType(String id,String v1,String v2) {
		geneID=id;
		StringPair sp = new StringPair(v1,v2);
		value=sp;
	}
	
	public int hashCode()
	{
		int code=geneID.toUpperCase().hashCode();
		if(value instanceof String) 
			code+=((String)value).toUpperCase().hashCode();
		
		if(value instanceof StringPair) 
			code+=value.hashCode();
		return code;
	}

	public boolean equals(Object obj) {
		if(obj instanceof GeneType) {
			GeneType gt=(GeneType)obj;
			if(geneID.equalsIgnoreCase(gt.geneID)) {
				if((value instanceof String) && (gt.value instanceof String)) 
					return ((String)value).equalsIgnoreCase((String)gt.value);
				
				if((value instanceof StringPair) && (gt.value instanceof StringPair)) 
					return ((StringPair)value).equals((StringPair)gt.value);
			}
		}
		return false;
	}
	
	public String toString(){
		return geneID+"="+value.toString();
	}
	
	public static void main(String[] args) {
		GeneType sp1 = new GeneType("CYP1","EP");
		System.out.printf("hash is %d for '%s'\n", sp1.hashCode(),sp1);
		
		GeneType sp2 = new GeneType("C__1","C","T");
		System.out.printf("hash is %d for '%s'\n", sp2.hashCode(),sp2);

		GeneType sp3 = new GeneType("c__1","t","c");
		System.out.printf("hash is %d for '%s'\n", sp3.hashCode(),sp3);
		
		
		
		if(sp1.equals(sp2)) {
			System.out.printf("1 2 Same\n");
		}
		else
			System.out.printf("1 2 Different\n");
		
		if(sp2.equals(sp3)) {
			System.out.printf("2 3 Same\n");
		}
		else
			System.out.printf("2 3 Different\n");
		
	}
	
	
}
