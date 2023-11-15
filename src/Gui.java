import java.awt.*;

import javax.swing.*;

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
        
        painelImagem.add(barraBotoes, BorderLayout.NORTH);

        jbEscolhaImagem.addActionListener(w -> {
             nomeArquivo = JOptionPane.showInputDialog("Insira o nome do arquivo que você deseja transformar!");
        });
        
        jbGreyscale.addActionListener(w -> {
            String opcaoDesejada = "1";
        	jbGreyscale.setToolTipText("Transforma as Cores para Cinza");
            Controller.transformImage(nomeArquivo, opcaoDesejada);
        });

        jbBlackWhite.addActionListener(w -> {
            String opcaoDesejada = "2";
            jbBlackWhite.setToolTipText("Transforma as Cores para Preto e Branco");
            Controller.transformImage(nomeArquivo, opcaoDesejada);
        });

        jbEdge.addActionListener(w -> {
            String opcaoDesejada = "3";
            jbEdge.setToolTipText("Refina as bordas a Imagem");
            Controller.transformImage(nomeArquivo, opcaoDesejada);
        });

        jbSharpen.addActionListener(w -> {
            String opcaoDesejada = "4";
            jbSharpen.setToolTipText("Aumenta a nitidez da Imagem");
            Controller.transformImage(nomeArquivo, opcaoDesejada);
        });

        jbHistogran.addActionListener(w -> {
            jbHistogran.setToolTipText("");

        });
        
        jbExit.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Fechando o programa!");
            System.exit(0);
        });
	}
	
	
	
}
