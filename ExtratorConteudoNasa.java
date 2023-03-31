import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExtratorConteudoNasa implements ExtratorConteudo {
  
  public List<Conteudo> extrair(String json) {
    JsonParser parser = new JsonParser();
    List<Map<String, String>> listaDeAtributos = parser.parse(json);
    
    List<Conteudo> conteudos = listaDeAtributos.stream().map(atributos -> {
      String titulo = atributos.get("title");
      String urlImagem = atributos.get("url");
      Conteudo conteudo = new Conteudo(titulo, urlImagem);
      System.out.println(conteudo.getTitulo() + " - url: " + conteudo.getUrlImage());
      return conteudo;
    }).collect(Collectors.toList());

    return conteudos;
  }

}
