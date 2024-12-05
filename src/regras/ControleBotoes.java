package regras;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;

import telas.EstadoDoBotao;

public class ControleBotoes {
	
	private String nBotao;
	
	private Map<JButton, EstadoDoBotao> botaoDeReferencia;  // Passar a referêncoa do botão e ver se esta selecionado ou não
	
	public ControleBotoes() {
		this.botaoDeReferencia = new HashMap<>();
	}
	
	public void executarAcao(JButton botao, EstadoDoBotao estado) {
		selecionandoBotao(botao, estado);
		if(this.isAllSelect()) {
			alterarTodosBotoes(EstadoDoBotao.PARES);
		} else {
			alterarVisualDoBota(botao);
		}
	}

	private void alterarTodosBotoes(EstadoDoBotao estado) {
		for(JButton botao: this.botaoDeReferencia.keySet()) {
			selecionandoBotao(botao, estado);
			alterarVisualDoBota(botao);
		}
	}
	
	public String getNmBotao() {
		return nBotao;
	}

	public void setNmBotao(String nmBotao) {
		this.nBotao = nmBotao;
	}

	public Map<JButton, EstadoDoBotao> getBotaoDeReferencia() {
		return botaoDeReferencia;
	}

	public void setBotaoDeReferencia(Map<JButton, EstadoDoBotao> botaoDeReferencia) {
		this.botaoDeReferencia = botaoDeReferencia;
	}
	
	
	private void alterarVisualDoBota(JButton botao) {
		EstadoDoBotao selected = this.botaoDeReferencia.get(botao);
		switch(selected) {
		case NORMAL:// Gray, sem exibição
			botao.setBackground(null);
			botao.setText("NORMAL");
			break;
		case SELECTED: // mudar cor e exibir text
			botao.setBackground(Color.BLUE);
			botao.setText(nBotao);
			break;
		case PARES: // mudar cor e mudar texto
			botao.setBackground(Color.GREEN);
			botao.setText(nBotao);
			botao.setEnabled(false);
			break;
		}
	}
	
	public void adicionandoBotao(JButton botao) {
		this.botaoDeReferencia.put(botao, EstadoDoBotao.NORMAL);
	}
	
	public void selecionandoBotao(JButton botao, EstadoDoBotao select) {
		this.botaoDeReferencia.put(botao, select);

	}
	
	public void zerandoSelecao() {
		alterarTodosBotoes(EstadoDoBotao.NORMAL);
	}

	public Boolean isAllSelect() {
		for(EstadoDoBotao b: this.botaoDeReferencia.values()) {
			if(b != EstadoDoBotao.SELECTED) {
				//os que não foram selecionados irão retornar falso
				return false;
			}
		}
		return true;
	}
	
}
