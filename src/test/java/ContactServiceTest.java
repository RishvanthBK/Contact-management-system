import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    @Test
    void testCRUD() {
        ContactService service = new ContactService();

        // Create
        service.addContact(new Contact(1, "John", "123"));
        assertEquals(1, service.size());

        // Read
        assertEquals("John", service.getContact(1).getName());

        // Update
        service.updateContact(1, "Doe", "999");
        assertEquals("Doe", service.getContact(1).getName());

        // Delete
        service.deleteContact(1);
        assertEquals(0, service.size());
    }
}