import eu.dattri.jsonbodyhandler.JsonBodyHandler;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        // create a client
        var client = HttpClient.newHttpClient();

        // create a request
        var request = HttpRequest.newBuilder(
                        URI.create("http://localhost:8080"))
                .header("accept", "application/json")
                //.POST(HttpRequest.BodyPublishers.ofString("{\"message\":\"abc\"}"))
                .POST(HttpRequest.BodyPublishers.ofString("{}"))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

        System.out.println(response.statusCode());

        // the response:
        System.out.println(response.body());
    }


}
