package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("1234567890", contact.getContactID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testInvalidContactCreation() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact(null, "John", "Doe", "1234567890", "123 Main St"));

        assertThrows(IllegalArgumentException.class,
            () -> new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));

        assertThrows(IllegalArgumentException.class,
            () -> new Contact("1234567890", "John", "Doe", "123", "123 Main St"));

        assertThrows(IllegalArgumentException.class,
            () -> new Contact("1234567890", "John", "Doe", "1234567890", null));
    }
    
    @Test
    public void testUpdateContactFields() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());

        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());

        contact.setPhone("9876543210");
        assertEquals("9876543210", contact.getPhone());

        contact.setAddress("456 Elm St");
        assertEquals("456 Elm St", contact.getAddress());
    }

    @Test
    public void testInvalidContactUpdate() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        
        assertThrows(IllegalArgumentException.class,
            () -> contact.setFirstName(null));

        assertThrows(IllegalArgumentException.class,
            () -> contact.setLastName("ANameThatIsTooLong"));

        assertThrows(IllegalArgumentException.class,
            () -> contact.setPhone("12345"));

        assertThrows(IllegalArgumentException.class,
            () -> contact.setAddress("ThisAddressIsWayTooLongAndShouldFail"));
    }
}

