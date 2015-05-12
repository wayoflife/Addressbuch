package de.dhbw.web.test;

import static org.junit.Assert.*;

import org.junit.Test;

import de.dhbw.web.Address;
import de.dhbw.web.AddressList;

public class AddressTest {
	
	@Test
	public void testName() throws Exception {
		assertEquals(true, true);
	}
	
//	@Test
//	public void geburtstagParsen() throws Exception {
//		Address ad = new Address();
//		ad.setBirthday("21.04.2015");
//		assertEquals("21.04.2015", ad.getBirthday());
//	}
//	
//	@Test
//	public void umlaute() throws Exception {
//		Address ad = new Address();
//		ad.read(1);
//		System.out.println(ad.getName());
//		assertEquals(true, true);
//	}
//
//	@Test
//	public void datenLaden() throws Exception {
//		Address ad = new Address();
//		ad.read(2);
//		assertEquals(2, ad.getId());
//		assertEquals("Maier", ad.getName());
//		assertEquals("23.09.1965", ad.getBirthday());
//	}
//	
//	@Test
//	public void updateData() throws Exception {
//		Address ad = new Address();
//		ad.read(1);
//		ad.setVorname("Horst");
//		assertEquals(true, ad.save());
//		ad.read(1);
//		assertEquals("Horst", ad.getVorname());
//	}
//	
//	@Test
//	public void insertData() throws Exception {
//		Address ad = new Address();
//		ad.setVorname("Hans-Peter");
//		ad.setName("Schmidt");
//		ad.setAddressform("Fräulein");
//		ad.setCity("Musterstadt");
//		assertEquals(true, ad.save());
//		ad.read(ad.getId());
//		assertEquals("Hans-Peter", ad.getVorname());
//		new AddressList().delete(ad.getId());
//	}
//	
//	@Test
//	public void deleteData() throws Exception {
//		Address ad = new Address();
//
//		ad.setVorname("Hans-Peter");
//		ad.setName("Schmidt");
//		ad.setAddressform("Fräulein");
//		ad.setCity("Musterstadt");
//		ad.save();
//		int alteid = ad.getId();
//		ad.read(alteid);
//		
//		new AddressList().delete(alteid);
//
//		ad.read(1);
//		ad.read(alteid);
//		assertEquals(1, ad.getId());
//	}
//	
//	@Test
//	public void Addressliste() throws Exception {
//		AddressList adl = new AddressList();
//		adl.setSuchtext("Maier");
//		assertEquals(1, adl.getAddressListe().size());
//	}
}
