package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaConta {
	public static void main(String[] args) {
		
		//Criando a conta Managed
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Márcia");
		conta.setNumero(1234);
		conta.setAgencia(4321);
		
		em.getTransaction().begin();
				
		em.persist(conta);
		
		em.getTransaction().commit();
		em.close();
		
		//Após o close a conta deixa de ser Managed e vira Detached
		//Por isso a necessidade de tornar ela Managed com um novo EntityManager
		
		EntityManager em2 = emf.createEntityManager();
		System.out.println("Id da Conta da Márcia: " + conta.getId());
		conta.setSaldo(500.0);
		
		em2.getTransaction().begin();
		
		em2.merge(conta);
		
		em2.merge(conta);
	}

}
