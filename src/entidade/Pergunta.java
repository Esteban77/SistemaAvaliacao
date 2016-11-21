package entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="pergunta")
public class Pergunta implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Transient  //nao persistir
	private Opcao opcoes;
	
	private String nomePergunta;
	
	@OneToMany(mappedBy="pergunta",fetch=FetchType.EAGER)
	private List<Resposta> resposta;
	
	@ManyToOne
	@JoinColumn(name="idTipoDeFormulario")
	private TipoDeFormulario tipoDeFormulario;
	

	public Pergunta(Long id, Opcao opcoes, String pergunta, TipoDeFormulario tipoDeFormulario) {
		super();
		this.id = id;
		this.opcoes = opcoes;
		this.nomePergunta = pergunta;
		this.tipoDeFormulario = tipoDeFormulario;
	}
	public Pergunta() {
		super();		
	}
	public long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public void setNomePergunta(String pergunta) {
		this.nomePergunta = pergunta;
	}
	
	public TipoDeFormulario getTipoDeFormulario() {
		return tipoDeFormulario;
	}
	public void setTipoDeFormulario(TipoDeFormulario tipoDeFormulario) {
		this.tipoDeFormulario = tipoDeFormulario;
	}

		

}
