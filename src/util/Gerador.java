package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Gerador {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaAvaliacaoPU");
		emf.close();
	}
	

}
