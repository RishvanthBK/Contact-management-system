import java.util.*;

public class ContactService {

    private Map<Integer, Contact> contacts = new HashMap<>();

    // CREATE
    public void addContact(Contact contact) {
        contacts.put(contact.getId(), contact);
    }

    // READ
    public Contact getContact(int id) {
        return contacts.get(id);
    }

    // UPDATE
    public void updateContact(int id, String name, String phone) {
        Contact c = contacts.get(id);
        if (c != null) {
            c.setName(name);
            c.setPhone(phone);
        }
    }

    // DELETE
    public void deleteContact(int id) {
        contacts.remove(id);
    }

    public int size() {
        return contacts.size();
    }
}