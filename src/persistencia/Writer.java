package persistencia;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * Exporta a imagem transformada
 *
 * @author Breno Rodrigues, Bruno Novo, Gabriel Odakura
 * @version 20231106
 */
public class Writer {

    public void writeImage(String nomeArquivo, BufferedImage imagem){
        File file = new File(nomeArquivo + ".jpg");
        try{
            ImageIO.write(imagem, "jpg", file);
            System.out.println("File Escrita!");
        }catch(IOException e){
            System.out.println("File não conseguiu ser salva!");
            System.out.println(e);
        }
    }
}
