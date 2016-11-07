package entidade;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="resposta")
public class Resposta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Enumerated(EnumType.STRING)
	private Opcao opcao;
	
	private int ordemResposta;
	
	@ManyToOne
	@JoinColumn(name="idRespostaFormulario")
	private RespostaFormulario respostaFormulario;
		
	public Resposta() {}
	
	public Resposta(int id, Opcao opcao, int ordemResposta, RespostaFormulario respostaFormulario) {
		super();
		this.id = id;
		this.opcao = opcao;		
		this.ordemResposta = ordemResposta;
		this.respostaFormulario = respostaFormulario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Opcao getOpcao() {
		return opcao;
	}
	public void setOpcao(Opcao opcao) {
		this.opcao = opcao;
	}

	public int getOrdemResposta() {
		return ordemResposta;
	}

	public void setOrdemResposta(int ordemResposta) {
		this.ordemResposta = ordemResposta;
	}

	public RespostaFormulario getRespostaFormulario() {
		return respostaFormulario;
	}

	public void setRespostaFormulario(RespostaFormulario respostaFormulario) {
		this.respostaFormulario = respostaFormulario;
	}
	

}
