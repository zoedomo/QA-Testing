package contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts;

    public ContactService() {
        contacts = new HashMap<>();
    }

    public void addContact(Contact contact) {
        String contactID = contact.getContactID();

        if (contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact with the same ID already exists");
        }

        contacts.put(contactID, contact);
    }

    public void deleteContact(String contactID) {
        Contact removedContact = contacts.remove(contactID);
        if (removedContact == null) {
            throw new IllegalArgumentException("Contact not found");
        }
    }

    public void updateContact(String contactID, String fieldToUpdate, String newValue) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }

        switch (fieldToUpdate) {
            case "firstName":
                contact.setFirstName(newValue);
                break;
            case "lastName":
                contact.setLastName(newValue);
                break;
            case "phone":
                contact.setPhone(newValue);
                break;
            case "address":
                contact.setAddress(newValue);
                break;
            default:
                throw new IllegalArgumentException("Invalid field to update");
        }
    }

    public Contact getContactByID(String contactID) {
        return contacts.get(contactID);
    }
}

