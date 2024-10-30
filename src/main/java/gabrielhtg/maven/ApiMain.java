package gabrielhtg.maven;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiMain {
    HttpResponse<String> response;

    // digunakan untuk mengambil semua item
    public HttpResponse<String> getAllItems() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest get = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.restful-api.dev/objects")).GET().build();

            response = client.send(get, HttpResponse.BodyHandlers.ofString());

            return response;
        } catch (Exception e) {
            System.out.println("Error");
        }

        return null;
    }

    // megnambil dari satu item berdasarkan id
    public HttpResponse<String> getOneItem(String id) {
        HttpResponse<String> response;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest get = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.restful-api.dev/objects/" + id)).GET().build();

            response = client.send(get, HttpResponse.BodyHandlers.ofString());

            return response;
        } catch (Exception e) {
            System.out.println("Error");
        }

        return null;
    }

    // multiple select
    public HttpResponse<String> getSelectedItem(String[] idArr) {
        HttpResponse<String> response;
        StringBuilder temp = new StringBuilder("?id=");

        for (int i = 0; i < idArr.length; i++) {
            if (i < idArr.length - 1) {
                temp.append(idArr[i]).append("&id=");
            }
            else {
                temp.append(idArr[i]);
            }
        }

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest get = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.restful-api.dev/objects" + temp)).GET().build();

            response = client.send(get, HttpResponse.BodyHandlers.ofString());

            return response;
        } catch (Exception e) {
            System.out.println("Error");
        }

        return null;
    }

    // menambah item baru
    public HttpResponse<String> addItem(String json) {
        HttpResponse<String> response;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .header("Content-Type", "application/json")
                    .uri(URI.create("https://api.restful-api.dev/objects"))
                    .POST(HttpRequest.BodyPublishers.ofString(json)).build();


            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response;
        } catch (Exception e) {
            System.out.println("Error");
        }

        return null;
    }

    // mengapus berdasarkan id
    public HttpResponse<String> deleteItem(String id) {
        HttpResponse<String> response;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest delete = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.restful-api.dev/objects/" + id)).DELETE().build();

            response = client.send(delete, HttpResponse.BodyHandlers.ofString());

            return response;
        } catch (Exception e) {
            System.out.println("Error");
        }

        return null;
    }

    public HttpResponse<String> updateItem(String id, String json) {
        HttpResponse<String> response;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest update = HttpRequest.newBuilder()
                    .header("Content-Type", "application/json")
                    .uri(URI.create("https://api.restful-api.dev/objects/" + id))
                    .PUT(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            response = client.send(update, HttpResponse.BodyHandlers.ofString());

            return response;
        } catch (Exception e) {
            System.out.println("Error");
        }

        return null;
    }

    public HttpResponse<String> updatePartialItem(String id, String json) {
        HttpResponse<String> response;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest update = HttpRequest.newBuilder()
                    .header("Content-Type", "application/json")
                    .uri(URI.create("https://api.restful-api.dev/objects/" + id))
                    .method("PATCH", HttpRequest.BodyPublishers.ofString(json))
                    .build();

            response = client.send(update, HttpResponse.BodyHandlers.ofString());

            return response;
        } catch (Exception e) {
            System.out.println("Error");
        }

        return null;
    }
}
