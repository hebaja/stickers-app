import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.net.URL;

public class Filmes {
  
  public static final String ANSI_WHITE = "\u001B[37m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
  public static final String ANSI_RESET = "\u001B[0m";

  public static void printar(List<Map<String, String>> movieList) throws Exception {
    Estrelas estrelas = new Estrelas();
    for(Map<String, String> film : movieList) {
      System.out.println("Título: " + ANSI_WHITE + film.get("title") + ANSI_RESET);
      System.out.println("Poster: " + ANSI_WHITE + film.get("image") + ANSI_RESET);
      System.out.println(ANSI_CYAN_BACKGROUND + "Classificação: " + film.get("imDbRating") + ANSI_RESET);
      estrelas.criar(Double.valueOf(film.get("imDbRating")));

      String url = film.get("image");
      InputStream inputStream = new URL(url).openStream();
      GeradorStickers geradorStickers = new GeradorStickers();
      geradorStickers.cria(inputStream, film.get("title") + ".png");

    }
  }
}
