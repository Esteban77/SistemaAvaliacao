package entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="empresa")
@PrimaryKeyJoinColumn(name="idPessoa")
public class Empresa extends Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(unique=true)
	private String cnpj;
	
	@OneToMany(mappedBy="empresa",fetch=FetchType.EAGER)
	private List<TipoDeBeneficio> tiposDeBeneficio;
	
	@OneToMany(mappedBy="empresa",fetch=FetchType.EAGER)
	private List<TipoDeFormulario> tiposDeFormulario;
	
	public Empresa(Long id, String nome, String email, String telefone, String login, String senha, String cnpj) {
		super(id, nome, telefone, login, senha);
		this.cnpj = cnpj;
	}
	
	public Empresa() {
		super();		
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}	
	
	
	
}
