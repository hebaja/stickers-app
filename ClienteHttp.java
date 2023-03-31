import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.Charset;

public class ClienteHttp {

  private String body;
  
  public String buscaDados(String url) {
    try {
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder(URI.create(url)).GET().build();
      HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
      body = response.body();
    } catch(IOException | InterruptedException e) {
      throw new RuntimeException(e);
    }

    return body;
  }

}
