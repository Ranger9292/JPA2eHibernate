package br.com.alura.jpa.testes;

import java.util.List;

import br.com.alura.jpa.dao.MovimentacaoDao;
import br.com.alura.jpa.modelo.MediaComData;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteMediaDiariaProjecao {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();

		List<MediaComData> mediaDasMovimentacoes = new MovimentacaoDao(em).getMediaDiariaDasMovimentacoes();
		
		for (MediaComData resultado : mediaDasMovimentacoes) {

			System.out.println("A soma das movimentações do dia " + resultado.getDia() + "/" + resultado.getMes() + "é: " + resultado.getValor());
		}
	}

}
