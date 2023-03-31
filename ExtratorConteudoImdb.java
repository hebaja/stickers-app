import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExtratorConteudoImdb implements ExtratorConteudo {

  public static final String ANSI_WHITE = "\u001B[37m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
  public static final String ANSI_RESET = "\u001B[0m";
 
  public List<Conteudo> extrair(String json) {
    JsonParser parser = new JsonParser();
    List<Map<String, String>> listaDeAtributos = parser.parse(json);
    Estrelas estrelas = new Estrelas(); 
    
    List<Conteudo> conteudos = listaDeAtributos.stream().map(atributos -> {
      String titulo = atributos.get("title");
      String urlImagem = atributos.get("image");
      double rating = Double.valueOf(atributos.get("imDbRating"));

      FilmeImdb conteudo = new FilmeImdb(titulo, urlImagem, rating);
      
      System.out.println("Título: " + ANSI_WHITE + conteudo.getTitulo() + ANSI_RESET);
      System.out.println("Poster: " + ANSI_WHITE + conteudo.getUrlImage() + ANSI_RESET);
      System.out.println(ANSI_CYAN_BACKGROUND + "Classificação: " + conteudo.getRating() + ANSI_RESET);
      estrelas.criar(conteudo.getRating());
      System.out.println();

      return conteudo;
    }).collect(Collectors.toList());

    return conteudos;

  }

}
