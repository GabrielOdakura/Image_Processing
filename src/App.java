import javax.swing.*;

/**
 * Classe para iniciar o programa e coletar o nome da imagem a ser aberta
 *
 * @author Breno Rodrigues, Bruno Novo, Gabriel Odakura
 * @version 20231106
 */
public class App {

    public static void main(String args[]){
        String nomeArquivo;
        String opcaoDesejada;
        nomeArquivo = JOptionPane.showInputDialog("Insira o nome do arquivo que você deseja transformar!");
        if(nomeArquivo == null){
            JOptionPane.showMessageDialog(null, "Fechando o programa!");
        }else {
            opcaoDesejada = JOptionPane.showInputDialog("(1) - Grey Scale" +
                                                      "\n(2) - Black and White" +
                                                      "\n(3) - Edge Detection" +
                                                      "\n(4) - Sharpen");
            if(opcaoDesejada == null){
                JOptionPane.showMessageDialog(null, "Fechando o programa!");
            }else{
                if(opcaoDesejada.equals("1") || opcaoDesejada.equals("2")){
                    Controller.transformImage(nomeArquivo, opcaoDesejada);
                }else if(opcaoDesejada.equals("3") || opcaoDesejada.equals("4")){
                    Controller.transformImage(nomeArquivo, opcaoDesejada);
                }else {
                    JOptionPane.showMessageDialog(null, "Escolha uma opção valida!");
                }
            }
        }
    }
}
