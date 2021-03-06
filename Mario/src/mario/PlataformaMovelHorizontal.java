package mario;

import jge2d.AnimacaoSprite;
import jge2d.Ponto;
import jge2d.Sprite;
import jge2d.jogo.movimentos.MovimentoHorizontalBidireccional;
import jge2d.jogo.movimentos.MovimentoVerticalBidireccional;

public class PlataformaMovelHorizontal {

	public static final String NORMAL = "NORMAL";
	
	private Ponto posicaoInicial;
	private Nivel nivel;
	private Sprite sprite;
	private double deslocamentoX;
	private double velocidade;
	private MovimentoHorizontalBidireccional movimento;
	
	public PlataformaMovelHorizontal(Ponto posicaoInicial, Nivel nivel, double deslocamentoX, double velocidade, long tempo){
		this.posicaoInicial = posicaoInicial;
		this.nivel = nivel;
		this.deslocamentoX = deslocamentoX;
		this.velocidade = velocidade;
		
		movimento = new MovimentoHorizontalBidireccional(posicaoInicial, deslocamentoX, velocidade, tempo);
		
		sprite = new Sprite("PlataformaMoveHorizontal", this, movimento);
		
		sprite.adicionarAnimacao(NORMAL, new AnimacaoSprite(nivel.getTilesPlataformaMovelHorizontal(), new int[] {}, 
				new int [] {1, 2}, new int[] {}, 0, 100, 0));
		
		sprite.setAnimacao(NORMAL, false, tempo);
		
		nivel.getMapa().addSprite(sprite);	
	}
}
