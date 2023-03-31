public class Conteudo {
  
  private final String titulo;
  private final String urlImagem;

  public Conteudo(String titulo, String urlImagem) {
    this.titulo = titulo;
    this.urlImagem = urlImagem;
  }

  public String getTitulo() {
    return this.titulo;
  }

  public String getUrlImage() {
    return this.urlImagem;
  }


}
