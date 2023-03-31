public class Estrelas {

  public void criar(double classificacao) {
    int counter = (int) classificacao;
    while(counter > 0) {
      printaEstrela();
      counter--;
    }
    System.out.println();
  }

  public static void printaEstrela() {
    char aa = '\u2B50';
    System.out.print(aa);
  }

}
