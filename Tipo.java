public enum Tipo {
  NASA("https://api.nasa.gov/planetary/apod?api_key=62ZtUj7aeseVW8kvMFmO9S1dLUe1KFlWh5lYW9d5&start_date=2022-03-15&end_date=2022-03-20"),
  IMDB("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json"),
  LING("http://localhost:8080/linguagens");
  
  private String url;

  Tipo(String url) {
    this.url = url;
  }

  public String getUrl() {
    return url;
  }
}
