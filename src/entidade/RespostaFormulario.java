package entidade;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="respostaFormulario")
public class RespostaFormulario {
	
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
	
	@OneToMany(mappedBy="respostaFormulario", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Resposta> respostas;
		
	public RespostaFormulario(int id, List<Resposta> respostas, Date data, String comentario, TipoDeFormulario tipoDeFormulario, int numeroPedido, boolean anonimo, Consumidor consumidor) {
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
	public List<Resposta> getRespostas() {
		return respostas;
	}
	public void setRespostas(List<Resposta> respostas) {
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
	
	
	
	

}
