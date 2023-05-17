package entidades;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Estoque {
	
	private ArrayList<Produto> produtos = new ArrayList<>();

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void cadastrarProduto(Produto x) {
		produtos.add(x);
	}

	public void cadastrarProduto(int codigo, String nome, String descricao, double valor, int quantidade,
			LocalDate validade, LocalDate fabricacao, String gondola) {

		Produto prod = new Produto(nome, valor, quantidade, validade, fabricacao, codigo, descricao, gondola);

		produtos.add(prod);
	}
	
	public int testarQtdValidade(Produto x) {

		int cont = 0;
		for (Produto prod : produtos) {

			if (diasValidade(prod) >= 0 && diasValidade(prod) <= 30) {

				cont++;
			}

		}
		return cont;
	}

	public int diasValidade(Produto x) {

		int periodo = (int) ChronoUnit.DAYS.between(LocalDate.now(), x.getValidade());

		return periodo;
	}


}
