package model;

//Template of a collection of entries
public class RefurbishedStore {
	private Entry [] entries;//an array of Entry object references: each slot stores the reference of some Entry object.
	private int noe;// 1- records how many (non-null) entries have been stored in the entries array.
					// 2- indicates the index of the "entries" array that will store the next new entry reference
	private final int MAX_CAPACITY = 5;//a constant maximum capacity value
	
	public RefurbishedStore() {
		this.entries = new Entry [MAX_CAPACITY] ;
		this.noe = 0;
		
	}
	public int getMaxCapacity() {
		return MAX_CAPACITY;
	}
	public int getNumberOfEntries() {
		return this.noe;
	}
	public Entry[] getPrivateEntriesArray() {
		return entries;
	}
	
	public Entry[] getEntries() { //Retrieve the array of entries in the chronological order in which they were inserted
		Entry[] es = new Entry[this.noe];
		for(int i = 0; i < this.noe; i++) {
			es[i] = this.entries[i];
		}
		return es;
	}
	
	
	public void addEntry(Entry e) {
		this.entries[this.noe] = e;
		this.noe ++;
	}
	
	public void addEntry(String sn, Product p) {
		Entry ne = new Entry(sn, p);
//		this.entries[this.noe] = ne;
//		this.noe ++;
		addEntry(ne);
	}
	
	public void addEntry(String sn, String model, double originalPrice) {
		Product p = new Product(model, originalPrice);
		Entry ne = new Entry(sn, p);
//		this.entries[this.noe] = ne;
//		this.noe ++;
		addEntry(ne);
	}
	
	public Product getProduct(String sn) {
		int index = -1;
		for (int i = 0; i < this.noe; i++) {
			Entry e = this.entries[i];
				if(e.getSerialNumber().equals(sn)) {
					index = i;
				}
		}
		if (index < 0) {
			return null;
		}
		else {
			return this.entries[index].getProduct();
		}
	}
	
	
	public String[] getSpaceGreyOrPro() {
		 int count = 0;
		 int[] indices = new int[this.noe];
		 
		 for(int i = 0; i < this.noe; i++) {
			 Product p = this.entries[i].getProduct();
			 if(p.getModel().contains("Pro") || p.getFinish().equals("Space Grey")) {
				 indices[count] = i;
				 count ++;
			 }
		 }
		
		String[] sns = new String[count];
		
		for(int i = 0; i < count; i ++){
			sns[i] = this.entries[indices[i]].getSerialNumber();
		}
		
		
		return sns;
	}
	public String[] getSpaceGreyPro() {
		 int count = 0;
		 int[] indices = new int[this.noe];
		 
		 for(int i = 0; i < this.noe; i++) {
			 Product p = this.entries[i].getProduct();
			 if(p.getModel().contains("Pro") && p.getFinish() != null && p.getFinish().equals("Space Grey")) {
				 indices[count] = i;
				 count ++;
			 }
		 }
		
		String[] sns = new String[count];
		
		for(int i = 0; i < count; i ++){
			sns[i] = this.entries[indices[i]].getSerialNumber();
		}
		
		
		return sns;
	}
	
}
