package entidade;

import java.io.Serializable;
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
public class CupomBeneficio implements Serializable{
	
	private static final long serialVersionUID = 1L;

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
	@Override
	public String toString() {
		return "CupomBeneficio [id=" + id + ", dataInicio=" + dataInicio + ", dataEfetivacao=" + dataEfetivacao
				+ ", darBeneficio=" + darBeneficio + ", beneficioDado=" + beneficioDado + ", pontos=" + pontos
				+ ", consumidor=" + consumidor + ", empresa=" + empresa + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (beneficioDado ? 1231 : 1237);
		result = prime * result + ((consumidor == null) ? 0 : consumidor.hashCode());
		result = prime * result + (darBeneficio ? 1231 : 1237);
		result = prime * result + ((dataEfetivacao == null) ? 0 : dataEfetivacao.hashCode());
		result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + id;
		result = prime * result + pontos;
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
		CupomBeneficio other = (CupomBeneficio) obj;
		if (beneficioDado != other.beneficioDado)
			return false;
		if (consumidor == null) {
			if (other.consumidor != null)
				return false;
		} else if (!consumidor.equals(other.consumidor))
			return false;
		if (darBeneficio != other.darBeneficio)
			return false;
		if (dataEfetivacao == null) {
			if (other.dataEfetivacao != null)
				return false;
		} else if (!dataEfetivacao.equals(other.dataEfetivacao))
			return false;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (id != other.id)
			return false;
		if (pontos != other.pontos)
			return false;
		return true;
	}
	
	

}
