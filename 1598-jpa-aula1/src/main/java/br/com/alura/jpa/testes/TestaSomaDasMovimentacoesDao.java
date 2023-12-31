package br.com.alura.jpa.testes;

import br.com.alura.jpa.dao.MovimentacaoDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaSomaDasMovimentacoesDao {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();

		MovimentacaoDao dao = new MovimentacaoDao(em);
				System.out.println("A soma das movimentações é: " + dao.getSomaDasMovimentacoes());
	}

}
