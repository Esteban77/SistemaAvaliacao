package entidade;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

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

	private static final long serialVersionUID = 1L;
	
	@Column(unique=true)
	private String cnpj;
	
	@OneToMany(mappedBy="empresa", fetch=FetchType.EAGER)
	private Set<TipoDeBeneficio> tiposDeBeneficio = new TreeSet<>();
//	@OrderColumn(name = "id")
//	@Sort(type = SortType.COMPARATOR)
	
//	@OrderBy(value="id")
//	@Sort(type = SortType.NATURAL)	
	
	@OneToMany(mappedBy="empresa",fetch=FetchType.EAGER)
	private Set<TipoDeFormulario> tiposDeFormulario= new TreeSet<>();
//	@Sort(type = SortType.COMPARATOR)

	
	public Empresa(Long id, String nome, String telefone, String login, String senha, String cnpj) {
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

	public Set<TipoDeBeneficio> getTiposDeBeneficio() {
		return tiposDeBeneficio;
	}

	public void setTiposDeBeneficio(Set<TipoDeBeneficio> tiposDeBeneficio) {
		this.tiposDeBeneficio = tiposDeBeneficio;
	}

	public Set<TipoDeFormulario> getTiposDeFormulario() {
		return tiposDeFormulario;
	}

	public void setTiposDeFormulario(Set<TipoDeFormulario> tiposDeFormulario) {
		this.tiposDeFormulario = tiposDeFormulario;
	}

	@Override
	public String toString() {
		return "Empresa [cnpj=" + cnpj + ", tiposDeBeneficio=" + tiposDeBeneficio + ", tiposDeFormulario="
				+ tiposDeFormulario + "]";
	}
	
	

/*	@Override
	public String toString() {
		return "Empresa [cnpj=" + cnpj + ", tiposDeBeneficio=" + tiposDeBeneficio + ", tiposDeFormulario="
				+ tiposDeFormulario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((tiposDeBeneficio == null) ? 0 : tiposDeBeneficio.hashCode());
		result = prime * result + ((tiposDeFormulario == null) ? 0 : tiposDeFormulario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (tiposDeBeneficio == null) {
			if (other.tiposDeBeneficio != null)
				return false;
		} else if (!tiposDeBeneficio.equals(other.tiposDeBeneficio))
			return false;
		if (tiposDeFormulario == null) {
			if (other.tiposDeFormulario != null)
				return false;
		} else if (!tiposDeFormulario.equals(other.tiposDeFormulario))
			return false;
		return true;
	}	
	*/
	
	
}
