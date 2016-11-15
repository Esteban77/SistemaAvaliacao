package entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tipoDeFormulario")
public class TipoDeFormulario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nomeFormulario;
	
	@OneToMany(mappedBy="tipoDeFormulario",cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Pergunta> perguntas;
	
	@ManyToOne
	@JoinColumn(name="idEmpresa")
	private Empresa empresa;
	
			
	public TipoDeFormulario(Long id, List<Pergunta> perguntas, Empresa empresa) {
		super();
		this.id = id;
		this.perguntas = perguntas;	
		this.empresa = empresa;
	}
	
	public TipoDeFormulario() {
		super();		
	}
	
	public String getNomeFormulario() {
		return nomeFormulario;
	}

	public void setNomeFormulario(String nomeFormulario) {
		this.nomeFormulario = nomeFormulario;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Pergunta> getPerguntas() {
		return perguntas;
	}
	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		return "TipoDeFormulario [id=" + id + ", perguntas=" + perguntas + ", empresa=" + empresa + "]";
	}

}
