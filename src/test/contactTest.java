package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import module3.Contact;

class contactTest {

	@Test
	void testValidContact() {
		Contact contact = new Contact("1234567","Adam","Snow","1901427989", "McVail Memphis, TN 38199") ;
		
		

		assertEquals("1234567",contact.getContactId());
		assertEquals("Adam",contact.getFirstName());
		assertEquals("Snow",contact.getLastName());
		assertEquals("1901427989",contact.getPhone());
		assertEquals("McVail Memphis, TN 38199",contact.getAddress());
		
	}
	 
	@Test
	void testNullContactId() {
		Contact contact = new Contact("1234567","Adam","Snow","1901427989", "McVail Memphis, TN 38199") ;
		assertThrows(IllegalArgumentException.class, ()->{new Contact(null,"Adam","Snow","1901427989", "McVail Memphis, TN 38199");});
		assertEquals("1234567",contact.getContactId());
	}
	
	@Test
    void testInvalidContactIdLength() {
        assertThrows(IllegalArgumentException.class, () -> {new Contact("12345675558901", "John", "Doe", "1234567890", "123 Elm Street");});
    }
	
	@Test
	void testNullFirstName() {
		Contact contact = new Contact("1234567","Adam","Snow","1901427989", "McVail Memphis, TN 38199") ;
		assertThrows(IllegalArgumentException.class, ()->{contact.setFirstName(null);});
		assertEquals("Adam",contact.getFirstName());
	}
	@Test
	void testLongFirstName() {
		
			Contact contact = new Contact("1234567","Adam","Snow","1901427989", "McVail Memphis, TN 38199") ;
			assertThrows(IllegalArgumentException.class, ()->{contact.setFirstName("MohamedElmarzougui");});
	}
	@Test
	void testNullLastName() {
		Contact contact = new Contact("1234567","Adam","Snow","1901427989", "McVail Memphis, TN 38199") ;
		assertThrows(IllegalArgumentException.class, ()->{contact.setLastName(null);});
		assertEquals("Snow",contact.getLastName());
	}
	@Test
	void testLongLastName() {
		Contact contact = new Contact("1234567","Adam","Snow","1901427989", "McVail Memphis, TN 38199") ;
		assertThrows(IllegalArgumentException.class, ()->{contact.setLastName("MousaElhabachiA");});
	}
	@Test
	void testNullNumber() {
		Contact contact = new Contact("1234567","Adam","Snow","1901427989", "McVail Memphis, TN 38199") ;
		assertThrows(IllegalArgumentException.class, ()->{contact.setPhone(null);});
		assertEquals("1901427989",contact.getPhone());
	}
	@Test
	void testWrongNumber() {
		Contact contact = new Contact("1234567","Adam","Snow","1901427989", "McVail Memphis, TN 38199") ;
		assertThrows(IllegalArgumentException.class, ()->{contact.setPhone("333");});
	}
	@Test
	void testNullAddress() {
		Contact contact = new Contact("1234567","Adam","Snow","1901427989", "McVail Memphis, TN 38199") ;
		assertThrows(IllegalArgumentException.class, ()->{contact.setAddress(null);});
		assertEquals("McVail Memphis, TN 38199",contact.getAddress());
	}
	@Test
	void testLongAddress() {
		Contact contact = new Contact("1234567","Adam","Snow","1901427989", "McVail Memphis, TN 38199") ;
		assertThrows(IllegalArgumentException.class, ()->{contact.setAddress("1919 Nor folk Manchester Mississippi ");});	}
	
	
	
	

	
	
	

}
