import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;


public class GeneTypeSet {
	HashSet <GeneType> gtSet;
	
	public GeneTypeSet() {
		gtSet = new HashSet <GeneType>();
	}
	
	public void add(GeneType gt) {
		gtSet.add(gt);
	}
	
	public int hashCode()
	{
		int code=0;
		int mul=31;
		Iterator <GeneType> e = gtSet.iterator();
	    while ( e.hasNext() ) {
	    	code+=code+mul*e.next().hashCode();
	    	mul*=31;
	    }
		return code;
	}

	public boolean equals(Object obj) {
		if(obj instanceof GeneTypeSet) {
			GeneTypeSet op=(GeneTypeSet)obj;
			Iterator <GeneType> e = gtSet.iterator();
		    while ( e.hasNext() ) {
		    	if(!op.gtSet.contains(e.next()))
		    			return false;
		    }
		    // all geneType found in the obj
		    return true;
		}
		return false;
	}
	
	public String toString(){
		String txt="{";
		boolean first=true;
		Iterator <GeneType> e = gtSet.iterator();
	    while ( e.hasNext() ) {
	    	if(first) first=false; else txt+=", ";
	    	txt+=e.next();
	    }
	    txt+="}";
		return txt;
	}
	
	public static void main(String[] args) {
		GeneTypeSet gts1= new GeneTypeSet();
		gts1.add(new GeneType("CYP1","EM"));
		gts1.add(new GeneType("CYP2","IM"));
		gts1.add(new GeneType("C__1","C","T"));
		System.out.printf("hash is %d for '%s'\n", gts1.hashCode(),gts1);
		
		GeneTypeSet gts2= new GeneTypeSet();
		gts2.add(new GeneType("cyp2","IM"));
		gts2.add(new GeneType("cyp1","EM"));
		gts2.add(new GeneType("c__1","t","C"));
		System.out.printf("hash is %d for '%s'\n", gts2.hashCode(),gts2);
		
		if(gts1.equals(gts2)) {
			System.out.printf("1 2 Same\n");
		}
		else
			System.out.printf("1 2 Different\n");
		
	}	
}
