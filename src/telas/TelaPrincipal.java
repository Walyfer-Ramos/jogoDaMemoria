package telas;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import regras.ControleBotoes;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

	private JButton botao;
	private JButton botao1;
	private JPanel painel;
	
	private JButton botaoA;
	private JButton botaoB;
			
	private ControleBotoes controle;
	private ControleBotoes controle1;
	
	private List<ControleBotoes> listaControle;
	
	
	public TelaPrincipal() {
		super("Jogo da Memoria");  // Titulo da Aba
		
		listaControle = new ArrayList<>();
		
		controle = new ControleBotoes();
		controle.setNmBotao("BOA");
		
		controle1 = new ControleBotoes();
		controle1.setNmBotao("GOOD");
		
		painel = new JPanel();
		this.add(painel);
		painel.setLayout(null);
		
		
		ActionListener acaoBotao = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton botao = (JButton) e.getSource();
				

				for(ControleBotoes cont: listaControle) {
					if(cont.getBotaoDeReferencia().get(botao) !=  null) {
						cont.executarAcao((JButton)e.getSource() , EstadoDoBotao.SELECTED);
					}
				}
				
				
			}
		};
		
		botao = new JButton("Nigga");
		painel.add(botao);
		botao.setBounds(10, 10, 100, 100);
		botao.addActionListener(acaoBotao);
		
		botao1 = new JButton("Nigga");
		painel.add(botao1);
		botao1.setBounds(120, 10, 100, 100);
		botao1.addActionListener(acaoBotao);
		
		
		botaoA = new JButton("Nigga");
		painel.add(botaoA);
		botaoA.setBounds(10, 110, 100, 100);
		botaoA.addActionListener(acaoBotao);
		
		botaoB = new JButton("Nigga");
		painel.add(botaoB);
		botaoB.setBounds(120, 110, 100, 100);
		botaoB.addActionListener(acaoBotao);

		
		this.setBounds(200, 200, 300, 300);  // 1°xy Aonde a aba vai aparecer, 2°xy o tamanho da aba
		
		this.controle.adicionandoBotao(botao);
		this.controle.adicionandoBotao(botao1);
		
		this.controle1.adicionandoBotao(botaoA);
		this.controle1.adicionandoBotao(botaoB);

		
		this.listaControle.add(controle);
		this.listaControle.add(controle1);
		
		
		this.setVisible(true); 
	}
}
