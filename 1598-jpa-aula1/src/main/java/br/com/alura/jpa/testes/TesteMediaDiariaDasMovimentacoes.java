package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.MediaComData;

public class TesteMediaDiariaDasMovimentacoes {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();

		String jpql = "select new br.com.alura.jpa.modelo.MediaComData(avg(m.valor), day(m.data), month(m.data)) from Movimentacao m group by day(m.data), month(m.data), year(m.data)";

		TypedQuery<MediaComData> query = em.createQuery(jpql, MediaComData.class);
		java.util.List<MediaComData> mediaDasMovimentacoes = query.getResultList();	
		
		for (MediaComData resultado : mediaDasMovimentacoes) {

			System.out.println("A soma das movimentações do dia " + resultado.getDia() + "/" + resultado.getMes() + "é: " + resultado.getValor());
		}
	}

}
