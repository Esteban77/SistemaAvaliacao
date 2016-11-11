package entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="pergunta")
public class Pergunta implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Transient  //nao persistir
	private Opcao opcoes;
	
	private String nomePergunta;
	
	@OneToOne(mappedBy="pergunta")
	private Resposta resposta;
	
	@ManyToOne
	@JoinColumn(name="idTipoDeFormulario")
	private TipoDeFormulario tipoDeFormulario;
	

	public Pergunta(int id, Opcao opcoes, String pergunta, TipoDeFormulario tipoDeFormulario) {
		super();
		this.id = id;
		this.opcoes = opcoes;
		this.nomePergunta = pergunta;
		this.tipoDeFormulario = tipoDeFormulario;
	}
	public Pergunta() {
		super();		
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
	public String getNomePergunta() {
		return nomePergunta;
	}
	public void setNpmePergunta(String pergunta) {
		this.nomePergunta = pergunta;
	}
	
	public TipoDeFormulario getTipoDeFormulario() {
		return tipoDeFormulario;
	}
	public void setTipoDeFormulario(TipoDeFormulario tipoDeFormulario) {
		this.tipoDeFormulario = tipoDeFormulario;
	}

		

}
