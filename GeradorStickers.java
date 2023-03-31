import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class GeradorStickers {
  
  private final static String FILE_FORMAT = "png";
  private final static String OUTPUT_DIRECTORY = "/tmp/";
  private final static String FONT = "Baloo Paaji 2";
  private final static String STICKER_IMDB_TEXT = "A MUST-SEE MOVIE!";
  private final static String STICKER_NASA_TEXT = "A MUST-SEE IMAGE!";
  private final static String STICKER_LING_TEXT = "E AÍ? VAMO CODAR!";
  private final static String EMOJI_IMDB_PATH = "/home/focus/Imagens/film.png";  
  private final static String EMOJI_NASA_PATH = "/home/focus/Imagens/nasa.png";
  private final static String EMOJI_LING_PATH = "/home/focus/Imagens/linguagens.png";
  private final static int OUTPUT_STICKER_WIDTH = 768;
  private final static int EMOJI_WIDTH = 50;
  private final static int EMOJI_HEIGHT = 50;
  private final static int ALTURA_PARTE_TRANSPARENTE = 80;
  private final static int TAMANHO_FONTE = 70;
  private int novaAltura;
  private int novaLargura;
  private BufferedImage emoji;

  public void cria(InputStream inputStream, String nomeArquivo, Tipo tipo) {
    try {
      BufferedImage imagemOriginal = ImageIO.read(inputStream);
      BufferedImage imagemRedimensionada = new BufferedImage(OUTPUT_STICKER_WIDTH, calcularAlturaDaImagem(imagemOriginal), BufferedImage.TRANSLUCENT);
      configurarImagemRedimensionada(imagemRedimensionada, imagemOriginal);  
      BufferedImage sticker = gerarSticker(imagemRedimensionada);
      Graphics2D stickerGraphics = configurarSticker(sticker, imagemRedimensionada, tipo);
      BufferedImage emoji = gerarEmoji(tipo);
      stickerGraphics.drawImage(emoji, 40, novaAltura - 65, null);
      ImageIO.write(sticker, FILE_FORMAT, new File(OUTPUT_DIRECTORY + nomeArquivo + ".png"));
    } catch(IOException e) {
      e.printStackTrace();
    }
  }

  private int calcularAlturaDaImagem(BufferedImage imagemOriginal) {
    double larguraAlturaDivisao = Double.valueOf(imagemOriginal.getWidth() / Double.valueOf(imagemOriginal.getHeight()));
    return (int) (OUTPUT_STICKER_WIDTH / larguraAlturaDivisao);
  }

  private void configurarImagemRedimensionada(BufferedImage imagemRedimensionada, BufferedImage imagemOriginal) {
    Graphics2D graphics = imagemRedimensionada.createGraphics();
    graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    graphics.drawImage(imagemOriginal, 0, 0, OUTPUT_STICKER_WIDTH, calcularAlturaDaImagem(imagemOriginal), null);
    graphics.dispose();
  }

  private BufferedImage gerarSticker(BufferedImage imagemRedimensionada) {
    novaLargura = imagemRedimensionada.getWidth();
    novaAltura = imagemRedimensionada.getHeight() + ALTURA_PARTE_TRANSPARENTE;
    return new BufferedImage(novaLargura, novaAltura, BufferedImage.TRANSLUCENT);
  }

  private Graphics2D configurarSticker(BufferedImage sticker, BufferedImage imagemRedimensionada, Tipo tipo) {
    Graphics2D graphics = (Graphics2D) sticker.getGraphics();
    graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    graphics.drawImage(imagemRedimensionada, 0, 0, null);
    gerarFonte(graphics, tipo);
    return graphics;
  }

  private void gerarFonte(Graphics2D graphics, Tipo tipo) {
    Font fonte = new Font(FONT, Font.BOLD, TAMANHO_FONTE);
    graphics.setFont(fonte);
    graphics.setColor(Color.YELLOW);
    if(tipo == Tipo.IMDB) graphics.drawString(STICKER_IMDB_TEXT, definirTextoX(), definirTextoY());
    if(tipo == Tipo.NASA) graphics.drawString(STICKER_NASA_TEXT, definirTextoX(), definirTextoY());
    if(tipo == Tipo.LING) graphics.drawString(STICKER_LING_TEXT, definirTextoX(), definirTextoY());
  }

  private int definirTextoX() {
    return novaLargura / 7;
  }

  private int definirTextoY() {
    return novaAltura - 17; 
  }

  private BufferedImage gerarEmoji(Tipo tipo) {
    try {
      if(tipo == Tipo.IMDB) emoji = ImageIO.read(new FileInputStream(new File(EMOJI_IMDB_PATH)));
      if(tipo == Tipo.NASA) emoji = ImageIO.read(new FileInputStream(new File(EMOJI_NASA_PATH)));
      if(tipo == Tipo.LING) emoji = ImageIO.read(new FileInputStream(new File(EMOJI_LING_PATH)));
      BufferedImage emojiRedimensionado = new BufferedImage(EMOJI_WIDTH, EMOJI_HEIGHT, BufferedImage.TRANSLUCENT);
      Graphics2D emojiGraphics = emojiRedimensionado.createGraphics();
      emojiGraphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
      emojiGraphics.drawImage(emoji, 0, 0, EMOJI_WIDTH, EMOJI_HEIGHT, null);
      emojiGraphics.dispose();
      return emojiRedimensionado;
    } catch(IOException e) {
      e.printStackTrace();
      return null;
    }
  }
}
