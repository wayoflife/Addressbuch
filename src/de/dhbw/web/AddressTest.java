package de.dhbw.web;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddressTest {
	
	@Test
	public void geburtstagParsen() throws Exception {
		Address ad = new Address();
		ad.setBirthday("21042015");
		assertEquals("2015-04-21", ad.getBirthday());
	}

	@Test
	public void DatenLaden() throws Exception {
		Address ad = new Address();
		ad.read(1);
		assertEquals(1, ad.getId());
		assertEquals("Müller", ad.getName());
		assertEquals("2003-08-14", ad.getBirthday());
	}
	
	@Test
	public void updateData() throws Exception {
		Address ad = new Address();
		ad.read(1);
		ad.setVorname("Horst");
		assertEquals(true, ad.save());
		ad.read(1);
		assertEquals("Horst", ad.getVorname());
	}
	
	@Test
	public void insertData() throws Exception {
		Address ad = new Address();
		ad.setVorname("Hans-Peter");
		ad.setName("Schmidt");
		ad.setAddressform("Fräulein");
		ad.setCity("Musterstadt");
		ad.save();
		ad.read(ad.getId());
		assertEquals("Hans-Peter", ad.getVorname());
	}
	
	@Test
	public void deleteData() throws Exception {
		Address ad = new Address();
		AddressList adl = new AddressList();
		ad.setVorname("Hans-Peter");
		ad.setName("Schmidt");
		ad.setAddressform("Fräulein");
		ad.setCity("Musterstadt");
		ad.save();
		int alteid = ad.getId();
		ad.read(alteid);
		adl.delete(alteid);
		ad.read(1);
		ad.read(alteid);
		assertEquals(1, ad.getId());
	}
	
	@Test
	public void Addressliste() throws Exception {
		AddressList adl = new AddressList();
		adl.setSuchtext("Müller");
		assertEquals(1, adl.getAddressListe().size());
	}
}
