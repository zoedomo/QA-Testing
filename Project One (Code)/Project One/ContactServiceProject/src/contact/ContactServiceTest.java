package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddAndRetrieveContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        Contact retrievedContact = contactService.getContactByID("1234567890");
        assertNotNull(retrievedContact);
        assertEquals("John", retrievedContact.getFirstName());
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        contactService.updateContact("1234567890", "firstName", "Jane");
        Contact updatedContact = contactService.getContactByID("1234567890");
        assertEquals("Jane", updatedContact.getFirstName());
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        contactService.deleteContact("1234567890");
        Contact deletedContact = contactService.getContactByID("1234567890");
        assertNull(deletedContact);
    }
    
    @Test
    public void testAddAndDeleteContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        
        contactService.addContact(contact);
        assertNotNull(contactService.getContactByID("1234567890"));

        contactService.deleteContact("1234567890");
        assertNull(contactService.getContactByID("1234567890"));
    }

    @Test
    public void testUpdateNonExistingContact() {
        assertThrows(IllegalArgumentException.class,
            () -> contactService.updateContact("1234567890", "firstName", "Jane"));
    }
}

