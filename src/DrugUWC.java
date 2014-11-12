import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

/*
 * This class manage a list of uwc rule, find a wuc for a gene type set
 * 
 */
public class DrugUWC {
	public String drugName;
	
	Hashtable<GeneTypeSet,String> uwcMap;
	
	public DrugUWC(String drugName) {
		this.drugName=drugName;
		uwcMap = new Hashtable<GeneTypeSet,String>();
	}
	
	public void addUWC(GeneTypeSet gts,String dosing) {
		uwcMap.put(gts, dosing);
	}

	public String getUWC(GeneTypeSet gts)
	{
		return uwcMap.get(gts);
	}
	
	public String toString(){
		String txt="UWC rules for drug "+drugName+"\n";
		Enumeration <GeneTypeSet> e = uwcMap.keys();
	    while ( e.hasMoreElements() ) {
	    	GeneTypeSet gts=e.nextElement();
	    	String dosing=uwcMap.get(gts);
	    	txt+="  "+gts+" ==> '"+dosing+"'\n";
	    }
		return txt;
	}
	
	
	public static void main(String[] args) {
		GeneTypeSet gts1= new GeneTypeSet();
		gts1.add(new GeneType("CYP1","EM"));
		gts1.add(new GeneType("CYP2","IM"));
		gts1.add(new GeneType("C__1","C","T"));
		System.out.printf("hash is %d for '%s'\n", gts1.hashCode(),gts1);
		
		GeneTypeSet gts2= new GeneTypeSet();
		gts2.add(new GeneType("cyp2","PM"));
		gts2.add(new GeneType("cyp1","EM"));
		gts2.add(new GeneType("c__1","t","C"));
		System.out.printf("hash is %d for '%s'\n", gts2.hashCode(),gts2);
		
		if(gts1.equals(gts2)) {
			System.out.printf("1 2 Same\n");
		}
		else
			System.out.printf("1 2 Different\n");
		
		
		DrugUWC uwc= new DrugUWC("Drug1");
		uwc.addUWC(gts1, "Dosing 1");
		uwc.addUWC(gts2, "Dosing 2");
		
		System.out.printf("uwc rule is\n%s\n",uwc.toString());
		
		GeneTypeSet gts3= new GeneTypeSet();
		gts3.add(new GeneType("cyp2","Im"));
		gts3.add(new GeneType("cyp1","em"));
		gts3.add(new GeneType("c__1","t","C"));
		System.out.printf("hash is %d for '%s'\n", gts3.hashCode(),gts3);
		
		String dosing=uwc.getUWC(gts3);
		if(dosing!=null)
			System.out.printf("Dosing for %s is '%s'\n",gts3,dosing);
		else
			System.out.printf("There is no dosing for %s\n",gts3);
	}	
	
	
}
