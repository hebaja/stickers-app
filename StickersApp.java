import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class StickersApp {

  private static ExtratorConteudo extrator;

  public static void main(String[] args) throws Exception {

    Tipo tipo = Tipo.LING;

    if(tipo == Tipo.IMDB) extrator = new ExtratorConteudoImdb();
    if(tipo == Tipo.NASA) extrator = new ExtratorConteudoNasa();
    if(tipo == Tipo.LING) extrator = new ExtratorConteudoLinguagem();

    ClienteHttp http = new ClienteHttp();
    String body = http.buscaDados(tipo.getUrl());

    List<Conteudo> conteudos = extrator.extrair(body);
    GeradorStickers geradorStickers = new GeradorStickers();

    for(Conteudo conteudo : conteudos) {
      InputStream inputStream = new URL(conteudo.getUrlImage()).openStream();
      geradorStickers.cria(inputStream, conteudo.getTitulo(), tipo);
    }
  }

}
