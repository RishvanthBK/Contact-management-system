public class App {
    public static void main(String[] args) {

        ContactService service = new ContactService();

        service.addContact(new Contact(1, "John", "12345"));

        Contact c = service.getContact(1);
        System.out.println(c.getName());

        service.updateContact(1, "Johnny", "99999");

        System.out.println(service.getContact(1).getName());

        service.deleteContact(1);

        System.out.println("Total contacts: " + service.size());
    }
}