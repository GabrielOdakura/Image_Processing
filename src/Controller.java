import imageProcessing.*;
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
    public static BufferedImage transformImage(String nomeArquivo, String opcaoDesejada){
        Reader reader = new Reader();
        BufferedImage image = null;
        if(nomeArquivo != null) {
            image = reader.readImage(nomeArquivo);
        }
        BufferedImage processedImage = null;
        if(image == null){
            JOptionPane.showMessageDialog(null, "Arquivo não selecionado/Caminho não existe!");
        }else {
            if(opcaoDesejada.equals("1")){
                processedImage = Greyscale.grayscaleFilter(image);
                String novoNome = JOptionPane.showInputDialog("Insira o nome do arquivo que você deseja salvar!");
                if(novoNome == null){
                    JOptionPane.showMessageDialog(null, "Fechando o programa!");
                }else {
                    Writer writer = new Writer();
                    writer.writeImage(novoNome, processedImage);
                }
            }else if(opcaoDesejada.equals("2")){
                processedImage = Blackwhite.BlackWhiteFilter(image);
                String novoNome = JOptionPane.showInputDialog("Insira o nome do arquivo que você deseja salvar!");
                if(novoNome == null){
                    JOptionPane.showMessageDialog(null, "Fechando o programa!");
                }else {
                    Writer writer = new Writer();
                    writer.writeImage(novoNome, processedImage);
                }
            }else if(opcaoDesejada.equals("3")){
                processedImage = EdgeDetection.edgeDetectionFilter(image);
                String novoNome = JOptionPane.showInputDialog("Insira o nome do arquivo que você deseja salvar!");
                if(novoNome == null){
                    JOptionPane.showMessageDialog(null, "Fechando o programa!");
                }else {
                    Writer writer = new Writer();
                    writer.writeImage(novoNome, processedImage);
                }
            }else if(opcaoDesejada.equals("4")) {
                processedImage = Sharpen.sharpenFilter(image);
                String novoNome = JOptionPane.showInputDialog("Insira o nome do arquivo que você deseja salvar!");
                if (novoNome == null) {
                    JOptionPane.showMessageDialog(null, "Fechando o programa!");
                } else {
                    Writer writer = new Writer();
                    writer.writeImage(novoNome, processedImage);
                }
            }else if(opcaoDesejada.equals("5")){
                if(image != null) {
                    new Histograma().display(image);
                }
            }
        }
        return processedImage;
    }
}
