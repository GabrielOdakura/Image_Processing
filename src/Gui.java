
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

public class Gui {

	private JFrame painelImagem = new JFrame();
	
	private JToolBar barraBotoes = new JToolBar();

    private JButton jbEscolhaImagem = new JButton("Escolha a Imagem");
	private JButton jbGreyscale = new JButton("GreyScale");
	private JButton jbBlackWhite = new JButton("Black&White");
	private JButton jbEdge = new JButton("EdgeDetection");
	private JButton jbSharpen = new JButton("Sharpen");
	private JButton jbHistogran = new JButton("Histograma");
	private JButton jbExit = new JButton("Sair");
    private JPanel jpImagemAtual = new JPanel();
    private JPanel jpImagemMod = new JPanel();
    private JLabel jlImagemAtual;
    private JLabel jlImagemMod;
    private BufferedImage imagemAtual;
    private BufferedImage imagemMod;

    private int altura;
    private int largura;

    String nomeArquivo;
	public Gui(int larg, int altu) {
		painelImagem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		painelImagem.setSize(larg, altu);
		painelImagem.setVisible(true);
		painelImagem.setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        painelImagem.setLocation((dim.width / 2) - (larg / 2), (dim.height / 2) - (altu / 2));

        barraBotoes.add(jbEscolhaImagem);
        barraBotoes.add(jbGreyscale);
        barraBotoes.add(jbBlackWhite);
        barraBotoes.add(jbEdge);
        barraBotoes.add(jbSharpen);
        barraBotoes.add(jbHistogran);
        barraBotoes.add(jbExit);
        barraBotoes.setFloatable(false);
        FlowLayout barraLayout = new FlowLayout();
        barraBotoes.setLayout(barraLayout);
        barraBotoes.setAlignmentX(barraLayout.CENTER);

        jbEscolhaImagem.setFont(new Font("arial", Font.PLAIN, 15));
        jbGreyscale.setFont(new Font("arial", Font.PLAIN, 15));
        jbBlackWhite.setFont(new Font("arial", Font.PLAIN, 15));
        jbEdge.setFont(new Font("arial", Font.PLAIN, 15));
        jbSharpen.setFont(new Font("arial", Font.PLAIN, 15));
        jbHistogran.setFont(new Font("arial", Font.PLAIN, 15));
        jbExit.setFont(new Font("arial", Font.PLAIN, 15));

        altura = painelImagem.getHeight() - barraBotoes.getHeight();
        largura = painelImagem.getWidth() / 2;
        Dimension escalaPadrao = new Dimension(largura, altura);
        jpImagemAtual.setBounds(0,43, largura, altura);
        jpImagemMod.setBounds(largura, 43, largura, altura);
        jpImagemAtual.setMaximumSize(escalaPadrao);
        jpImagemMod.setMaximumSize(escalaPadrao);

        painelImagem.add(barraBotoes, BorderLayout.NORTH);
//        painelImagem.add(jpImagemAtual, BorderLayout.WEST);
//        painelImagem.add(jpImagemMod, BorderLayout.EAST);
        painelImagem.add(jpImagemAtual);
        painelImagem.add(jpImagemMod);

        jbEscolhaImagem.addActionListener(w -> {
            nomeArquivo = getFileAdress();
            try{
                imagemAtual = ImageIO.read(new File(nomeArquivo));
            }catch(IOException e){
                System.out.println("Imagem inexistente");
                System.out.println(e);
            }
            if(imagemAtual != null){
                if(jlImagemAtual == null) {
                    jlImagemAtual = new JLabel(new ImageIcon(imagemAtual.getScaledInstance(largura, altura, Image.SCALE_DEFAULT)));
                    jlImagemAtual.setBounds(0, 0, jpImagemAtual.getWidth(), jpImagemAtual.getHeight());
                    jlImagemAtual.setBackground(Color.BLACK);
                    jpImagemAtual.add(jlImagemAtual);
                    jpImagemAtual.setBackground(Color.BLACK);
                }else{
                    jpImagemAtual.remove(jlImagemAtual);
                    jlImagemAtual = new JLabel(new ImageIcon(imagemAtual.getScaledInstance(largura, altura, Image.SCALE_DEFAULT)));
                    jlImagemAtual.setBounds(0, 0, jpImagemAtual.getWidth(), jpImagemAtual.getHeight());
                    jlImagemAtual.setBackground(Color.BLACK);
                    jpImagemAtual.add(jlImagemAtual);
                    jpImagemAtual.setBackground(Color.BLACK);
                    jpImagemAtual.updateUI();
                }
            }
            if(jlImagemMod != null){
                jpImagemMod.remove(jlImagemMod);
                jpImagemMod.setBackground(new Color(255,255,255));
                jpImagemMod.updateUI();
            }
             //nomeArquivo = JOptionPane.showInputDialog("Insira o nome do arquivo que você deseja transformar!");
        });
        
        jbGreyscale.addActionListener(w -> {
            String opcaoDesejada = "1";
        	jbGreyscale.setToolTipText("Transforma as Cores para Cinza");
            if(nomeArquivo != null) {
               imagemMod = Controller.transformImage(nomeArquivo, opcaoDesejada);
                setModifiedImage();
            }
        });

        jbBlackWhite.addActionListener(w -> {
            String opcaoDesejada = "2";
            jbBlackWhite.setToolTipText("Transforma as Cores para Preto e Branco");
            if(nomeArquivo != null) {
                imagemMod = Controller.transformImage(nomeArquivo, opcaoDesejada);
            }
        });

        jbEdge.addActionListener(w -> {
            String opcaoDesejada = "3";
            jbEdge.setToolTipText("Refina as bordas a Imagem");
            if(nomeArquivo != null) {
                imagemMod = Controller.transformImage(nomeArquivo, opcaoDesejada);
            }
        });

        jbSharpen.addActionListener(w -> {
            String opcaoDesejada = "4";
            jbSharpen.setToolTipText("Aumenta a nitidez da Imagem");
            if(nomeArquivo != null) {
                imagemMod = Controller.transformImage(nomeArquivo, opcaoDesejada);
            }
        });

        jbHistogran.addActionListener(w -> {
            jbHistogran.setToolTipText("");

        });
        
        jbExit.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Fechando o programa!");
            System.exit(0);
        });
	}

    private String getFileAdress() {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView());
        jfc.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int returnValue = jfc.showOpenDialog(null);
        String pathString = null;
        if(returnValue == JFileChooser.APPROVE_OPTION) {
            File name = jfc.getSelectedFile();
            pathString = name.toPath().toString();
        }
        return pathString;
    }

    private void setModifiedImage(){
        if(jlImagemMod == null) {
            jlImagemMod = new JLabel(new ImageIcon(imagemMod.getScaledInstance(largura, altura, Image.SCALE_DEFAULT)));
            jlImagemMod.setMaximumSize(new Dimension(largura,altura));
            jlImagemMod.setBounds(largura, 0, jpImagemMod.getWidth(), jpImagemMod.getHeight());
            jlImagemMod.setSize(new Dimension(largura,altura));
            jlImagemMod.setBackground(Color.BLACK);
            jpImagemMod.add(jlImagemMod);
            jpImagemMod.setBackground(Color.BLACK);
            gambiarra();
        }else{
            jpImagemMod.remove(jlImagemMod);
            jlImagemMod = new JLabel(new ImageIcon(imagemMod.getScaledInstance(largura, altura, Image.SCALE_DEFAULT)));
            jlImagemMod.setMaximumSize(new Dimension(largura,altura));
            jlImagemMod.setBounds(0, 0, jpImagemMod.getWidth(), jpImagemMod.getHeight());
            jlImagemMod.setBackground(Color.BLACK);
            jpImagemMod.add(jlImagemMod);
            jpImagemMod.setBackground(Color.BLACK);
            jpImagemMod.updateUI();
            gambiarra();
        }
    }

    private void gambiarra(){
        jpImagemAtual.remove(jlImagemAtual);
        jlImagemAtual = new JLabel(new ImageIcon(imagemAtual.getScaledInstance(largura, altura, Image.SCALE_DEFAULT)));
        jlImagemAtual.setBounds(0, 0, jpImagemAtual.getWidth(), jpImagemAtual.getHeight());
        jlImagemAtual.setBackground(Color.BLACK);
        jpImagemAtual.add(jlImagemAtual);
        jpImagemAtual.setBackground(Color.BLACK);
        jpImagemAtual.updateUI();
    }


}
