package com.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class GibHubClient {
    private final String BASE_URL = "https://api.github.com";
    private final String token;
    private final HttpClient httpClient;

    public GibHubClient(String token) {
        this.token = token;
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();
    }

    public String getUser() throws Exception {
        HttpRequest request = createRequest(BASE_URL + "/user", "GET", null);
        return send(request);
    }

    private String send(HttpRequest request) throws Exception {
        HttpResponse<String> response = httpClient.send(request,
                HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() >= 400) {
            throw new RuntimeException("Ошибка " + response.statusCode() +
                    ": " + response.body());
        }

        return response.body();
    }

    private HttpRequest createRequest(String url, String method, String body) {
        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/vnd.github.v3+json")
                .header("User-Agent", "Java-GitHub-Client")
                .header("Authorization", "Bearer " + token);

        switch (method) {
            case "GET":
                builder.GET();
                break;
            case "POST":
                builder.POST(HttpRequest.BodyPublishers.ofString(body != null ? body : ""));
                builder.header("Content-Type", "application/json");
                break;
            case "PUT":
                builder.PUT(HttpRequest.BodyPublishers.ofString(body != null ? body : ""));
                builder.header("Content-Type", "application/json");
                break;
            case "DELETE":
                builder.DELETE();
                break;
        }

        return builder.build();
    }
}
