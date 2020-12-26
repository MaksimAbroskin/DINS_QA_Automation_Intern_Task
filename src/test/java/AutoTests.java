import com.google.gson.Gson;
import jdk.jfr.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Category("test")
public class AutoTests {

    @Test
    void testGetUsersUserId() {
        Gson gson = new Gson();
        String expectedResponse = gson.toJson(new User(1, "John", "Snow"));

        Client client = new Client();

        String response = client.get();

        assertEquals(expectedResponse, response);
    }


    @Test
    void testGetUsersUserId2() {
        Gson gson = new Gson();
        String expectedResponse = gson.toJson(new User(2, "John", "Snow"));

        Client client = new Client();

        String response = client.get();

        assertEquals(expectedResponse, response);
    }
}
