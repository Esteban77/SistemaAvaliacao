package entidade;

public class GraficoPizza {
	
	private Double nOtimo;
	private Double nBom;
	private Double nRuim;
	private Double nPessimo;
	
	private TipoDeFormulario tipoDeFormulario;
	private Pergunta pergunta;
	
	public GraficoPizza( Double nBom, Double nOtimo,Double nPessimo, Double nRuim) {
		super();
		this.nOtimo = nOtimo;
		this.nBom = nBom;
		this.nRuim = nRuim;
		this.nPessimo = nPessimo;
	}
	
	

}
