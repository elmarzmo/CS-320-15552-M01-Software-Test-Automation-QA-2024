package module3;

import java.util.HashMap;
import java.util.Map;

public class contactService {
	private final Map<String, Contact>contacts;
	
	public contactService() {
	 this.contacts = new HashMap<>();
	 
	}
	
	
	public void add(Contact contact) {
		if(!contacts.containsKey(contact.getContactId())) {
			contacts.put(contact.getContactId(),contact);
			}else {
				throw new IllegalArgumentException("Contact with this ID already exists");
			}

	}
	public void delete(String contactId) {
		if(contacts.containsKey(contactId)) {
		contacts.remove(contactId);
		}else {
			throw new IllegalArgumentException("Contact ID Not Found");
		}

	}
	
	public void updateFirstName(String newFirstName,String contactId) {
		Contact contact = contacts.get(contactId);
		if(contact != null) {
			contact.setFirstName(newFirstName);
		}else {
			throw new IllegalArgumentException("Contact ID Not Found");
		}
	
	}
	
	public void updateLastName(String newLastName,String contactId) {
		Contact contact = contacts.get(contactId);
		if(contact != null) {
			contact.setLastName(newLastName);
		}else {
			throw new IllegalArgumentException("Contact ID Not Found");
		}
	}
	
	public void updateNumber(String newNumber,String contactId) {
		Contact contact = contacts.get(contactId);
		if(contact != null) {
			contact.setPhone(newNumber);
		}else {
			throw new IllegalArgumentException("Contact ID Not Found");
		}
	}
	
	public void updateAddress(String newAddress,String contactId) {
		Contact contact = contacts.get(contactId);
		if(contact != null) {
			contact.setAddress(newAddress);
		}else {
			throw new IllegalArgumentException("Contact ID Not Found");
		}
	}
	
	public Contact getContact(String contactId) {
        Contact contact = contacts.get(contactId);
        if (contact != null) {
            return contact;
        } else {
            throw new IllegalArgumentException("Contact ID Not Found");
        }
	}
}
