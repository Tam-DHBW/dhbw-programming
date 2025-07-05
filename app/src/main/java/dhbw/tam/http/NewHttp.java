package dhbw.tam.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class NewHttp {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/post"))
                .header("Foo", "Bar")
                .POST(HttpRequest.BodyPublishers.ofString("Hello World!"))
                .build();

        HttpClient.Builder clientBuilder = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS);

        try (HttpClient client = clientBuilder.build()) {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        }

        float latitude = 52F;
        float longitude = 0F;

//String response = HttpClient.newHttpClient().send(
//        HttpRequest.newBuilder()
//                .uri(URI.create(STR."https://air-quality-api.open-meteo.com/v1/air-quality?current=pm2_5&latitude=\{latitude}&longitude=\{longitude}"))
//                .GET()
//                .build(),
//        HttpResponse.BodyHandlers.ofString()
//).body();

    }
}
