package br.com.alura.jpa.testes;

import br.com.alura.jpa.dao.MovimentacaoDao;

public class TestaSomaDasMovimentacoesDao {
	public static void main(String[] args) {

		MovimentacaoDao dao = new MovimentacaoDao();
				System.out.println("A soma das movimentações é: " + dao.getSomaDasMovimentacoes());
	}

}
