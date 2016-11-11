package entidade;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="pergunta")
public class Pergunta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Transient  //nao persistir
	private Opcao opcoes;
	
	private String pergunta;
	
	private int ordemPergunta;
	
	@ManyToOne
	@JoinColumn(name="idTipoDeFormulario")
	private TipoDeFormulario tipoDeFormulario;
	
	public Pergunta() {
		super();
	}
	public Pergunta(int id, Opcao opcoes, String pergunta, TipoDeFormulario tipoDeFormulario) {
		super();
		this.id = id;
		this.opcoes = opcoes;
		this.pergunta = pergunta;
		this.tipoDeFormulario = tipoDeFormulario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Opcao getOpcoes() {
		return opcoes;
	}
	public void setOpcoes(Opcao opcoes) {
		this.opcoes = opcoes;
	}
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public int getOrdemPergunta() {
		return ordemPergunta;
	}
	public void setOrdemPergunta(int ordemPergunta) {
		this.ordemPergunta = ordemPergunta;
	}
	public TipoDeFormulario getTipoDeFormulario() {
		return tipoDeFormulario;
	}
	public void setTipoDeFormulario(TipoDeFormulario tipoDeFormulario) {
		this.tipoDeFormulario = tipoDeFormulario;
	}
	
		

}
