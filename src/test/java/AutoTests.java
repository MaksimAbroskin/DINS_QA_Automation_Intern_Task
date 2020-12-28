import Units.Error;
import Units.User;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AutoTests {
    static Gson gson;
    static Client client;

    @BeforeAll
    static void init() {
        gson = new Gson();
        client = new Client();
    }

    @Order(1)
    @Test
    void testPostUsers() {
        String expectedResponse = gson.toJson(new User(5, "FirstName", "LastName"));
        String response = client.post("http://localhost:8080/users", expectedResponse);
        assertEquals(expectedResponse, response);
    }

    @Order(2)
    @Test
    void testGetUsersUserId() {
        String expectedResponse = gson.toJson(new User(5, "FirstName", "LastName"));
        String response = client.get("http://localhost:8080/users/5");
        assertEquals(expectedResponse, response);
    }

    @Order(3)
    @Test
    void testPutUsersUserId_NoExistId() {
        User user = new User(4,
                "FirstNamePut",
                "LastNamePut");
        Error error = gson.fromJson(client.put("http://localhost:8080/users/4", user), Error.class);
        assertNotNull(error.getError());
    }

    @Order(4)
    @Test
    void testDeleteUsersUserId_NoExistId() {
        Error error = gson.fromJson(client.delete("http://localhost:8080/users/2"), Error.class);
        assertNotNull(error.getError());
    }
}
