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
	private Long id;
	
	@Column(length=100, nullable=false) 
	private String nomeBeneficio;
	
	@ManyToOne
	@JoinColumn(name="idEmpresa")
	private Empresa empresa;
	


	public TipoDeBeneficio(Long id, String nomeBeneficio, Empresa empresa) {
		super();
		this.id = id;
		this.nomeBeneficio = nomeBeneficio;
		this.empresa = empresa;
	}
	
	public TipoDeBeneficio() {
		super();		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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

	
}
