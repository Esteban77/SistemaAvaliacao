package entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="respostaFormulario")
public class RespostaFormulario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;	
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	private String comentario;	
	private int numeroPedido;
	private boolean anonimo;
	
	@ManyToOne
	@JoinColumn(name="idConsumidor")
	private Consumidor consumidor;
	
	@ManyToOne
	@JoinColumn(name="idTipoDeFormulario")
	private TipoDeFormulario tipoDeFormulario;
	
//	@Sort(type = SortType.COMPARATOR)
//	@OrderBy(value="id")
	@OneToMany(mappedBy="respostaFormulario", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Resposta> respostas;
		
	public RespostaFormulario(int id, Set<Resposta> respostas, Date data, String comentario, TipoDeFormulario tipoDeFormulario, int numeroPedido, boolean anonimo, Consumidor consumidor) {
		super();
		this.id = id;
		this.respostas = respostas;
		this.data = data;
		this.comentario = comentario;
		this.tipoDeFormulario = tipoDeFormulario;
		this.numeroPedido = numeroPedido;
		this.anonimo = anonimo;
		this.consumidor = consumidor;
	}
	
	public RespostaFormulario() {
		super();
		
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public Set<Resposta> getRespostas() {
		return respostas;
	}
	public void setRespostas(Set<Resposta> respostas) {
		this.respostas = respostas;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public TipoDeFormulario getTipoDeFormulario() {
		return tipoDeFormulario;
	}

	public void setTipoDeFormulario(TipoDeFormulario tipoDeFormulario) {
		this.tipoDeFormulario = tipoDeFormulario;
	}

	public int getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public boolean isAnonimo() {
		return anonimo;
	}

	public void setAnonimo(boolean anonimo) {
		this.anonimo = anonimo;
	}

	public Consumidor getConsumidor() {
		return consumidor;
	}

	public void setConsumidor(Consumidor consumidor) {
		this.consumidor = consumidor;
	}

	@Override
	public String toString() {
		return "RespostaFormulario [id=" + id + ", data=" + data + ", comentario=" + comentario + ", numeroPedido="
				+ numeroPedido + ", anonimo=" + anonimo + ", consumidor=" + consumidor + ", tipoDeFormulario="
				+ tipoDeFormulario + ", respostas=" + respostas + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (anonimo ? 1231 : 1237);
		result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
		result = prime * result + ((consumidor == null) ? 0 : consumidor.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + id;
		result = prime * result + numeroPedido;
		result = prime * result + ((respostas == null) ? 0 : respostas.hashCode());
		result = prime * result + ((tipoDeFormulario == null) ? 0 : tipoDeFormulario.hashCode());
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
		RespostaFormulario other = (RespostaFormulario) obj;
		if (anonimo != other.anonimo)
			return false;
		if (comentario == null) {
			if (other.comentario != null)
				return false;
		} else if (!comentario.equals(other.comentario))
			return false;
		if (consumidor == null) {
			if (other.consumidor != null)
				return false;
		} else if (!consumidor.equals(other.consumidor))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (id != other.id)
			return false;
		if (numeroPedido != other.numeroPedido)
			return false;
		if (respostas == null) {
			if (other.respostas != null)
				return false;
		} else if (!respostas.equals(other.respostas))
			return false;
		if (tipoDeFormulario == null) {
			if (other.tipoDeFormulario != null)
				return false;
		} else if (!tipoDeFormulario.equals(other.tipoDeFormulario))
			return false;
		return true;
	}
	
	
	
	

}
