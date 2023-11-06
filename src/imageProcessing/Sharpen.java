package imageProcessing;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Aumenta a sharpness da imagem
 *
 * @author Breno Rodrigues, Bruno Novo, Gabriel Odakura
 * @version 20231106
 */
public class Sharpen {
    public static BufferedImage sharpenFilter(BufferedImage imagem){
        int width, height;
        int ordem = 3;
        width = imagem.getWidth(); //pega a largura da imagem
        height = imagem.getHeight(); //pega a altura da imagem
        BufferedImage output = new BufferedImage(width, height, imagem.getType());

        //inicializando a matriz para mult
        int[][] kernel = new int[ordem][ordem];
        kernel[0][0] = 0; kernel[0][1] = -1; kernel[0][2] = 0;
        kernel[1][0] = -1; kernel[1][1] =  5; kernel[1][2] = -1;
        kernel[2][0] = 0; kernel[2][1] = -1; kernel[2][2] = 0;

        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                double red = 0f, green = 0f, blue = 0f;
                for(int i = 0; i < ordem; i++){
                    for(int j = 0; j < ordem; j++){
                        int imagemX = (x - ordem / 2 + i + width) % width;
                        int imagemY = (y - ordem / 2 + j + height) % height;

                        int matriz = imagem.getRGB(imagemX,imagemY);
                        int alpha = (matriz >> 24) & 0xff;
                        int r = (matriz >> 16) & 0xff;
                        int g = (matriz >> 8) & 0xff;
                        int b = matriz & 0xff;

                        red   += (r * kernel[i][j]);
                        green += (g * kernel[i][j]);
                        blue  += (b * kernel[i][j]);
                    }
                }
                //Esses 3 calcs servem para manter os indices entre 0 e 255
                red   = Math.min(Math.max(red,0),255);
                green = Math.min(Math.max(green,0),255);
                blue  = Math.min(Math.max(blue,0),255);

                output.setRGB(x,y, new Color((int) red,(int) green,(int) blue).getRGB());
            }
        }
        System.out.println("Sharpen successful!");
        return output;
    }
}
