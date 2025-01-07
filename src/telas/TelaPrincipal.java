package telas;



import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import regras.ControleBotoes;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

	private static final int QUANTIDADE_JOGADAS = 2;
	private int jogadas = 0;
	
	
	private JPanel painel;
			
	
	
	private List<ControleBotoes> listaControle;
	
	private List<ControleBotoes> listaSelecionados;
	
	private ActionListener acaoBotao;
	
	public TelaPrincipal() {
		super("Jogo da Memoria");  // Titulo da Aba
		
		
		listaControle = new ArrayList<>();
		listaSelecionados = new ArrayList<>();
		

		
		painel = new JPanel();
		this.add(painel);
		painel.setLayout(null);
		
		
		
		
		  acaoBotao = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton botao = (JButton) e.getSource();
				

				for(ControleBotoes cont: listaControle) {
					if(cont.getBotaoDeReferencia().get(botao) !=  null) {
						jogadas++;
						cont.executarAcao((JButton)e.getSource() , EstadoDoBotao.SELECTED);
						
						if(!listaSelecionados.contains(cont)) {
							listaSelecionados.add(cont);
						}
						
						
						System.out.println(listaSelecionados.size());
						if(jogadas == QUANTIDADE_JOGADAS) {
							if(listaSelecionados.size() > 1) {
								//deixando os botoes em estado inicial 
								for(ControleBotoes cb: listaSelecionados) {
									cb.zerandoSelecao();
								}
							}
							jogadas = 0;
							listaSelecionados.clear();
						}
						break;
					}
				}
				
				
			}
		};
		
		

		//adaptar o tamanho da tela
		this.setBounds(80, 80, 600, 600);  // 1°xy Aonde a aba vai aparecer, 2°xy o tamanho da aba
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true); 
		criarJogo(10);
	}
	
	private void criarJogo(int QuantidadeDePares) {
		//quantidade de botoes
		ControleBotoes controle = null;
		int posiX = 10;
		int posiY = 10;
		
		List<Rectangle> posicionamentos = new ArrayList<>();
		
		int j = 0;
		int i = 0;
		
		
		//randomizar o posiciamento dos botoes
		Random random = new Random();
		
		for(i = 0; i <(QuantidadeDePares * 2); i++) {
			Rectangle rec = new Rectangle(posiX, posiY, 80, 80);
			posicionamentos.add(rec);
			if(i%5 == 0 && i > 0) {
				posiY += 85;
				posiX = 10;
			}else {
				posiX += 85;
			}
		}
		
		for(i = 0; i< (QuantidadeDePares * 2); i++) {
			if (i % 2 == 0) {
				// quantidade de controles
				j++;
				controle = new ControleBotoes();
				controle.setNmBotao("B" + j);
				this.listaControle.add(controle);
			}
			
			JButton botao = new JButton("Game");
			//colocar os botos na tela
			this.painel.add(botao);
			botao.addActionListener(this.acaoBotao);
			
			//Adicionar Posição
			//randomizar o posiciamento dos botoes
			int pos = random.nextInt(((posicionamentos.size() - 1) > 0) ? posicionamentos.size() - 1 : 1) ;
			botao.setBounds(posicionamentos.get(pos));
			posicionamentos.remove(pos);
			System.out.println(pos);

			controle.adicionandoBotao(botao);
		}
		
		
		
	}
}
