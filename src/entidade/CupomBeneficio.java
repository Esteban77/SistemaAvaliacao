package entidade;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="cupomBeneficio")
public class CupomBeneficio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	
	@Temporal(TemporalType.DATE)
	private Date dataEfetivacao;
	
	private boolean darBeneficio;
	private boolean beneficioDado;
	private int pontos;
	
	@ManyToOne
	@JoinColumn(name="idConsumidor")
	private Consumidor consumidor;
	
	@ManyToOne
	@JoinColumn(name="idEmpresa")
	private Empresa empresa;

	
	public CupomBeneficio() {
		super();
	}

	public CupomBeneficio(int id, Date dataInicio, Date dataEfetivacao, boolean darBeneficio, boolean beneficioDado,
			int pontos, Consumidor consumidor, Empresa empresa) {
		super();
		this.id = id;
		this.dataInicio = dataInicio;
		this.dataEfetivacao = dataEfetivacao;
		this.darBeneficio = darBeneficio;
		this.beneficioDado = beneficioDado;
		this.pontos = pontos;
		this.consumidor = consumidor;
		this.empresa = empresa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataEfetivacao() {
		return dataEfetivacao;
	}

	public void setDataEfetivacao(Date dataEfetivacao) {
		this.dataEfetivacao = dataEfetivacao;
	}

	public boolean isDarBeneficio() {
		return darBeneficio;
	}

	public void setDarBeneficio(boolean darBeneficio) {
		this.darBeneficio = darBeneficio;
	}

	public boolean isBeneficioDado() {
		return beneficioDado;
	}

	public void setBeneficioDado(boolean beneficioDado) {
		this.beneficioDado = beneficioDado;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public Consumidor getConsumidor() {
		return consumidor;
	}

	public void setConsumidor(Consumidor consumidor) {
		this.consumidor = consumidor;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	

}
