package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import module3.Contact;
import module3.contactService;

class contactServiseTest {
	private contactService service;
	 @BeforeEach
	    void setUp() {
	        service = new contactService();
	    }


	@Test
	void testAdd() {
		
		Contact contact = new Contact("1234567", "Adam", "Snow", "1901427989", "McVail Memphis, TN 38199");
        service.add(contact);
        
        // Check that the contact is added successfully
        assertEquals("Adam", service.getContact("1234567").getFirstName());
	}
	@Test
	void testAddDuplicateContact() {
		
		Contact contact = new Contact("1234567", "Adam", "Snow", "1901427989", "McVail Memphis, TN 38199");
        service.add(contact);
        
        // Check 
        assertThrows(IllegalArgumentException.class, () -> {service.add(contact);});
	}

	@Test
	void testDelete() {
		Contact contact = new Contact("1234567", "Adam", "Snow", "1901427989", "McVail Memphis, TN 38199");
		service.add(contact);
		service.delete("1234567");
		
		assertThrows(IllegalArgumentException.class, () ->{service.getContact("1234567");});
	}
	@Test
	void testDeleteNonExciting() {
		
		assertThrows(IllegalArgumentException.class, () ->{service.delete("1212");});
	}
	
	@Test
	void testUpdateFirstName() {
		Contact contact = new Contact("1234567", "Adam", "Snow", "1901427989", "McVail Memphis, TN 38199");
		service.add(contact);
		service.updateFirstName("Moe","1234567");
		assertEquals("Moe", service.getContact("1234567").getFirstName());
	}
	@Test
	void testUpdateFirstNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {service.updateFirstName(null, "1234567");});
	}
	@Test
	void testUpdateLastName() {
		Contact contact = new Contact("1234567", "Adam", "Snow", "1901427989", "McVail Memphis, TN 38199");
		service.add(contact);
		service.updateLastName("Elmar","1234567");
		assertEquals("Elmar", service.getContact("1234567").getLastName());
	}
	@Test
	void testUpdateLastNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {service.updateLastName(null, "1234567");});
	}
	@Test
	void testUpdateNumber() {
		Contact contact = new Contact("1234567", "Adam", "Snow", "1901427989", "McVail Memphis, TN 38199");
		service.add(contact);
		service.updateNumber("1901390888","1234567");
		assertEquals("1901390888", service.getContact("1234567").getPhone());
	}
	@Test
	void testUpdatePhoneNull() {
		assertThrows(IllegalArgumentException.class, () -> {service.updateNumber(null, "1234567");});
	}
	@Test
	void testUpdateAddress() {
		Contact contact = new Contact("1234567", "Adam", "Snow", "1901427989", "McVail Memphis, TN 38199");
		service.add(contact);
		service.updateAddress("191 nor folk California ","1234567");
		assertEquals("191 nor folk California ", service.getContact("1234567").getAddress());
	}
	@Test
	void testUpdateAdress() {
		assertThrows(IllegalArgumentException.class, () -> {service.updateAddress(null, "1234567");});
	}
}
