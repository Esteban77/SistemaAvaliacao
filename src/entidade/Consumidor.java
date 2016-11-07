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
@Table(name="consumidor")
@PrimaryKeyJoinColumn(name="idPessoa")
public class Consumidor extends Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Column(unique=true)
	private String cpf;	

	private String email;
	
	@OneToMany(mappedBy="consumidor", fetch=FetchType.EAGER)
	private List<RespostaFormulario> respostasFormulario;
	
	
	public Consumidor() {
		super();
	}
	
	public Consumidor(Long id, String nome, String telefone, String login, String senha, String email, String cpf) {
		super(id, nome, telefone,login,senha);
		this.cpf = cpf;		
		this.email = email;		
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
