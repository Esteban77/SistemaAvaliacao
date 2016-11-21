package entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="resposta")
public class Resposta implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private Opcao opcao;
	
	@ManyToOne
	@JoinColumn(name="idPergunta")
	private Pergunta pergunta;
	
	@ManyToOne
	@JoinColumn(name="idRespostaFormulario")
	private RespostaFormulario respostaFormulario;
		
	public Resposta() {}
	
	public Resposta(Long id, Opcao opcao, Pergunta pergunta, RespostaFormulario respostaFormulario) {
		super();
		this.id = id;
		this.opcao = opcao;		
		this.pergunta = pergunta;
		this.respostaFormulario = respostaFormulario;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Opcao getOpcao() {
		return opcao;
	}
	public void setOpcao(Opcao opcao) {
		this.opcao = opcao;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public RespostaFormulario getRespostaFormulario() {
		return respostaFormulario;
	}

	public void setRespostaFormulario(RespostaFormulario respostaFormulario) {
		this.respostaFormulario = respostaFormulario;
	}

/*	@Override
	public String toString() {
		return "Resposta [id=" + id + ", opcao=" + opcao + ", pergunta=" +pergunta + ", respostaFormulario="
				+ respostaFormulario + "]";
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resposta other = (Resposta) obj;
		if (id != other.id)
			return false;
		if (opcao != other.opcao)
			return false;
		if (pergunta != other.pergunta)
			return false;
		if (respostaFormulario == null) {
			if (other.respostaFormulario != null)
				return false;
		} else if (!respostaFormulario.equals(other.respostaFormulario))
			return false;
		return true;
	}
	*/

}
