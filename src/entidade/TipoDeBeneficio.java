package entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tipoDeBeneficio")
public class TipoDeBeneficio implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(length=100, nullable=false) 
	private String nomeBeneficio;
	
	@ManyToOne
	@JoinColumn(name="idEmpresa")
	private Empresa empresa;
	
	public TipoDeBeneficio(int id, String nomeBeneficio, Empresa empresa) {
		super();
		this.id = id;
		this.nomeBeneficio = nomeBeneficio;
		this.empresa = empresa;
	}
	
	public TipoDeBeneficio() {
		super();		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeBeneficio() {
		return nomeBeneficio;
	}
	public void setNomeBeneficio(String nomeBeneficio) {
		this.nomeBeneficio = nomeBeneficio;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		return "TipoDeBeneficio [id=" + id + ", nomeBeneficio=" + nomeBeneficio + ", empresa=" + empresa + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + id;
		result = prime * result + ((nomeBeneficio == null) ? 0 : nomeBeneficio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoDeBeneficio other = (TipoDeBeneficio) obj;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (id != other.id)
			return false;
		if (nomeBeneficio == null) {
			if (other.nomeBeneficio != null)
				return false;
		} else if (!nomeBeneficio.equals(other.nomeBeneficio))
			return false;
		return true;
	}
	
	
	
	
	
}
