public class FilmeImdb extends Conteudo {
  
  private final double rating;

  public FilmeImdb(String titulo, String urlImagem, double rating) {
    super(titulo, urlImagem);
    this.rating = rating;
  }

  public double getRating() {
    return this.rating;
  }

}
