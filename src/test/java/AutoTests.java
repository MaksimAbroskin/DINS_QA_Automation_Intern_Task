import com.google.gson.Gson;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutoTests {

    @Order(1)
    @Test
    void testPostUsers() {
        Gson gson = new Gson();
        String expectedResponse = gson.toJson(new User(5, "FirstName", "LastName"));
        Client client = new Client();
        String response = client.post("http://localhost:8080/users");
        assertEquals(expectedResponse, response);
    }

    @Order(2)
    @Test
    void testPostUsersUserIdContacts() {
        Gson gson = new Gson();
        String expectedResponse = gson.toJson(new Contact(1,
                "FirstName",
                "LastName",
                "1234567890",
                "email@mail.ru"));
        Client client = new Client();
        String response = client.post("http://localhost:8080/users/1/contacts");
        assertEquals(expectedResponse, response);
    }

    @Order(3)
    @Test
    void testPutUsersUserIdContactsContactId() {
        Gson gson = new Gson();
        String expectedResponse = gson.toJson(new Contact(1,
                "FirstName",
                "LastName",
                "1234567890",
                "email@mail.ru"));
        Client client = new Client();
        String response = client.put("http://localhost:8080/users/1/contacts/1");
        assertEquals(expectedResponse, response);
    }

    @Order(4)
    @Test
    void testDeleteUsersUserId() {
        String expectedResponse = "100 CONTINUE";
        Client client = new Client();
        String response = client.delete("http://localhost:8080/users/1");
        assertEquals(expectedResponse, response);
    }

    @Order(5)
    @Test
    void testGetUsersUserId() {
        Gson gson = new Gson();
        String expectedResponse = gson.toJson(new User(1, "John", "Snow"));
        Client client = new Client();
        String response = client.get("http://localhost:8080/users/1");
        assertEquals(expectedResponse, response);
    }

    @Order(6)
    @Test
    void testGetUsersUserIdContactsContactId() {
        Gson gson = new Gson();
        String expectedResponse = gson.toJson(new Contact(1, "Brandon", "Stark", "3123456789", "brain_star@gmail.com"));
        Client client = new Client();
        String response = client.get("http://localhost:8080/users/1/contacts/1");
        assertEquals(expectedResponse, response);
    }
}
