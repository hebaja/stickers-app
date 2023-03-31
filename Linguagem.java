public class Linguagem extends Conteudo {

  private final int rating;

  public Linguagem(String title, String urlImagem, int rating) {
    super(title, urlImagem);
    this.rating = rating;
  }

  public int getRating() {
    return this.rating;
  }

}
