import imageProcessing.Blackwhite;
import imageProcessing.EdgeDetection;
import imageProcessing.Greyscale;
import imageProcessing.Sharpen;
import persistencia.Reader;
import persistencia.Writer;

import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 * Seleciona a opção que o usuário escolheu e transforma a imagem
 *
 * @author Breno Rodrigues, Bruno Novo, Gabriel Odakura
 * @version 20231106
 */

public class Controller {
    public static void transformImage(String nomeArquivo, String opcaoDesejada){
        Reader reader = new Reader();
        BufferedImage image = reader.readImage(nomeArquivo);
        if(image == null){
            JOptionPane.showMessageDialog(null, "Não Existe arquivo com este nome!");
        }else {
            if(opcaoDesejada.equals("1")){
                image = Greyscale.grayscaleFilter(image);
                String novoNome = JOptionPane.showInputDialog("Insira o nome do arquivo que você deseja salvar!");
                if(novoNome == null){
                    JOptionPane.showMessageDialog(null, "Fechando o programa!");
                }else {
                    Writer writer = new Writer();
                    writer.writeImage(novoNome, image);
                }
            }else if(opcaoDesejada.equals("2")){
                image = Blackwhite.BlackWhiteFilter(image);
                String novoNome = JOptionPane.showInputDialog("Insira o nome do arquivo que você deseja salvar!");
                if(novoNome == null){
                    JOptionPane.showMessageDialog(null, "Fechando o programa!");
                }else {
                    Writer writer = new Writer();
                    writer.writeImage(novoNome, image);
                }
            }else if(opcaoDesejada.equals("3")){
                image = EdgeDetection.edgeDetectionFilter(image);
                String novoNome = JOptionPane.showInputDialog("Insira o nome do arquivo que você deseja salvar!");
                if(novoNome == null){
                    JOptionPane.showMessageDialog(null, "Fechando o programa!");
                }else {
                    Writer writer = new Writer();
                    writer.writeImage(novoNome, image);
                }
            }else if(opcaoDesejada.equals("4")){
                image = Sharpen.sharpenFilter(image);
                String novoNome = JOptionPane.showInputDialog("Insira o nome do arquivo que você deseja salvar!");
                if(novoNome == null){
                    JOptionPane.showMessageDialog(null, "Fechando o programa!");
                }else {
                    Writer writer = new Writer();
                    writer.writeImage(novoNome, image);
                }
            }
        }
    }
}
