import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExtratorConteudoLinguagem implements ExtratorConteudo {

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
      int ranking  = Integer.valueOf(atributos.get("rating"));
      
      Linguagem linguagem = new Linguagem(titulo, urlImagem, ranking);
      
      System.out.println("Título: " + ANSI_WHITE + linguagem.getTitulo() + ANSI_RESET);
      System.out.println("Poster: " + ANSI_WHITE + linguagem.getUrlImage() + ANSI_RESET);
      System.out.println(ANSI_CYAN_BACKGROUND + "Classificação: " + linguagem.getRating() + ANSI_RESET);
      estrelas.criar(linguagem.getRating());
      System.out.println();

      return linguagem;
    }).collect(Collectors.toList());

    return conteudos;

  }

}
