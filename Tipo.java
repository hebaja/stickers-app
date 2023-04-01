public enum Tipo {
  NASA(Urls.NASA_URL),
  IMDB(Urls.IMDB_URL),
  LING(Urls.LING_URL);
  
  private String url;

  Tipo(String url) {
    this.url = url;
  }

  public String getUrl() {
    return url;
  }

}
