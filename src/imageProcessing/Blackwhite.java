package imageProcessing;

import java.awt.image.BufferedImage;

/**
 * Transforma a imagem em preto e branco
 *
 * @author Breno Rodrigues, Bruno Novo, Gabriel Odakura
 * @version 20231106
 */
public class Blackwhite {
    public static BufferedImage BlackWhiteFilter(BufferedImage imagem){
        int width, height;
        width = imagem.getWidth(); //pega a largura da imagem
        height = imagem.getHeight(); //pega a altura da imagem
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                int matriz = imagem.getRGB(x,y);
                int alpha = (matriz >> 24) & 0xff;
                int r = (matriz >> 16) & 0xff;
                int g = (matriz >> 8) & 0xff;
                int b = matriz & 0xff;
                int media = (r + g + b) / 3;
                if (media >= 128){
                    media = 255;
                }else {
                    media = 0;
                }
                matriz = (alpha << 24) | (media << 16) | (media << 8) | (media);
                imagem.setRGB(x,y,matriz);
            }
        }
        System.out.println("Black White successful!");
        return imagem;
    }
}
