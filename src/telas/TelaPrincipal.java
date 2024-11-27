package telas;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import rules.ControleBotoes;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

	private JButton botao;
	private JButton botao1;
	private JPanel painel;
	
			
	private ControleBotoes controle;
	
	public TelaPrincipal() {
		super("Jogo da Memoria");  // Titulo da Aba
		
		controle = new ControleBotoes();
		controle.setNmBotao("OPEN");
		
		painel = new JPanel();
		this.add(painel);
		painel.setLayout(null);
		
		
		ActionListener acaoBotao = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controle.executarAcao((JButton)e.getSource() , EstadoDoBotao.SELECTED);
			}
		};
		
		botao = new JButton("Button");
		painel.add(botao);
		botao.setBounds(10, 10, 100, 100);
		botao.addActionListener(acaoBotao);
		
		
		
		
		botao1 = new JButton("Button");
		painel.add(botao1);
		botao1.setBounds(120, 10, 100, 100);
		botao1.addActionListener(acaoBotao);

		
		this.setBounds(200, 200, 300, 300);  // 1°xy Aonde a aba vai aparecer, 2°xy o tamanho da aba
		
		this.controle.adicionandoBotao(botao);
		this.controle.adicionandoBotao(botao1);
		
		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
