package davies.curtis.sysc4806.labs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTests {

    @Value(value = "${local.server.port}")
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    private String getForObject(String path) {
        return restTemplate.getForObject("http://localhost:" + port + path, String.class);
    }

    private String postForObject(String path, Object data) {
        return restTemplate.postForObject("http://localhost:" + port + path, data, String.class);
    }

    private void delete(String path) {
        restTemplate.delete("http://localhost:" + port + path, String.class);
    }

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(getForObject("/")).contains("Hi :)");
    }

    @Test
    public void testGetBook() throws Exception {
        assertThat(getForObject("/addressbook/1")).contains("\"id\":1");
    }

    @Test
    public void testAddbook() throws Exception {
        postForObject("/addressbook/new", new AddressBook());
        assertThat(getForObject("/addressbook/2")).contains("\"id\":2");
    }

    @Test
    public void testDeleteBook() throws Exception {
        postForObject("/addressbook/new", new AddressBook());
        delete("/addressbook/2");
        assertThat(getForObject("/addressbook/2")).isNull();
    }

    @Test
    public void testGetBuddy() throws Exception {
        assertThat(getForObject("/addressbook/1/buddies/1")).contains("Hugh Janus");
    }

    @Test
    public void testAddBuddy() throws Exception {
        postForObject("/addressbook/1/buddies", new BuddyInfo("Add-Buddy-Test-User", "2222222222"));
        assertThat(getForObject("/addressbook/1")).contains("\"name\":\"Add-Buddy-Test-User\"");
    }
}
