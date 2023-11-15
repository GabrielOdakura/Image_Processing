package persistencia;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * Lê a imagem escolhida pelo usuário
 *
 * @author Breno Rodrigues, Bruno Novo, Gabriel Odakura
 * @version 20231106
 */
public class Reader {

    public BufferedImage readImage(String nomeArquivo){
        BufferedImage imagem = null;
        File file = null;

        try{
            //file = new File(nomeArquivo + ".jpg");
            file = new File(nomeArquivo);
            imagem = ImageIO.read(file);
            System.out.println("File lida!");
        } catch (IOException e){
            System.out.println("File não existe/não encontrada!");
            System.out.println(e);
        }
        return imagem;
    }
}
