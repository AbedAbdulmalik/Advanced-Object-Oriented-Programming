package junit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.*;

public class TestRefurbishedStore {

	@Test
	public void test_refurbished_store_1() {
		//create an empty store
		RefurbishedStore rs = new RefurbishedStore();//max 5 entries
		for(int i =0; i < rs.getMaxCapacity() ; i++) {
			rs.addEntry(new Entry("sn " +i, null));
		}
		assertEquals(rs.getMaxCapacity() -1, rs.getNumberOfEntries());
		boolean b = false;
		for(int i =0; i < rs.getNumberOfEntries(); i++) {
			b = rs.getPrivateEntriesArray()[i].getProduct() == null;
		}
		assertTrue(b);
		
	}
	
	
	@Test
	public void test_refurbished_store_2() {
		//create an empty store
		RefurbishedStore rs = new RefurbishedStore();//max 5 entries
		
		
		Product p1 = new Product("iPad Pro 12.9", 1709.00);
		p1.setFinish("Space Grey");
		p1.setStorage(1000);
		p1.setHasCellularConnectivity(true);
		p1.setDiscountValue(220.00);
		Entry e1  = new Entry("F9FDN4NKQ1GC", p1); //add entry #1
		rs.addEntry(e1);
		
		
		Product p2 = new Product("iPad Air", 649.00);
		p2.setFinish("Gold");
		p2.setStorage(64);
		p2.setHasCellularConnectivity(false);
		p2.setDiscountValue(100);
		//Add entry 2
		rs.addEntry("C9FZN4J8QC82", p2);
		
		
		//add Entry 3
		rs.addEntry("7YN4PFZ779UB", "iPad Pro 10.5", 929.00);
		
		assertTrue(rs.getProduct("F9FDN4NKQ1GC") == p1);
		assertTrue(rs.getProduct("C9FZN4J8QC82") == p2);
		assertTrue(rs.getProduct("7YN4PFZ779UB").getModel().equals("iPad Pro 10.5"));
		assertTrue(rs.getProduct("7YN4PFZ779UB").getFinish() == null);
		assertTrue(rs.getProduct("7YN4PFZ779UB").getStorage() == 0);
		assertTrue(rs.getProduct("7YN4PFZ779UB").hasCellularConnectivity() == false);
		assertEquals(929.00, rs.getProduct("7YN4PFZ779UB").getOriginalPrice(), 0.1);
		assertEquals(0.00, rs.getProduct("7YN4PFZ779UB").getDiscountValue(), 0.1);
		
		
		rs.getProduct("7YN4PFZ779UB").setFinish("Silver");
		rs.getProduct("7YN4PFZ779UB").setStorage(256);
		Product p3 = rs.getEntries()[2].getProduct();
		p3.setHasCellularConnectivity(false);
		p3.setDiscountValue(270);
		
		assertTrue(rs.getProduct("7YN4PFZ779UB").getModel().equals("iPad Pro 10.5"));
		assertTrue(rs.getProduct("7YN4PFZ779UB").getFinish().equals("Silver"));
		assertTrue(rs.getProduct("7YN4PFZ779UB").getStorage() == 256);
		assertTrue(rs.getProduct("7YN4PFZ779UB").hasCellularConnectivity() == false);
		assertEquals(929.00, rs.getProduct("7YN4PFZ779UB").getOriginalPrice(), 0.1);
		assertEquals(270.00, rs.getProduct("7YN4PFZ779UB").getDiscountValue(), 0.1);





		

	}

	
	@Test
	public void test_refurbished_store_3() {
		//create an empty store
		RefurbishedStore rs = new RefurbishedStore();//max 5 entries
		
		
		Product p1 = new Product("iPad Pro 12.9", 1709.00);
		p1.setFinish("Space Grey");
		p1.setStorage(1000);
		p1.setHasCellularConnectivity(true);
		p1.setDiscountValue(220.00);
		Entry e1  = new Entry("F9FDN4NKQ1GC", p1); //add entry #1
		rs.addEntry(e1);
		
		
		Product p2 = new Product("iPad Air", 649.00);
		p2.setFinish("Gold");
		p2.setStorage(64);
		p2.setHasCellularConnectivity(false);
		p2.setDiscountValue(100);
		//Add entry 2
		rs.addEntry("C9FZN4J8QC82", p2);
		
		
		//add Entry 3
		rs.addEntry("7YN4PFZ779UB", "iPad Pro 10.5", 929.00);
		
		rs.getProduct("7YN4PFZ779UB").setFinish("Silver");
		rs.getProduct("7YN4PFZ779UB").setStorage(256);
		Product p3 = rs.getEntries()[2].getProduct();
		p3.setHasCellularConnectivity(false);
		p3.setDiscountValue(270);
		
		assertTrue(rs.getSpaceGreyOrPro().length == 2);
		assertTrue(rs.getSpaceGreyOrPro()[0].equals("F9FDN4NKQ1GC")
				&&
				rs.getSpaceGreyOrPro()[1].equals("7YN4PFZ779UB"));
		
		assertTrue(rs.getSpaceGreyPro().length == 1);
		assertTrue(rs.getSpaceGreyPro()[0].equals("F9FDN4NKQ1GC"));
		
	}
}
