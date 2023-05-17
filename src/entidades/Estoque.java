package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Estoque {
	
	 private ArrayList<Produto> produtos = new ArrayList<>();
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
	 
	public Estoque() {
		

		cadastrarProduto(0001, "Café", "Pilão Extra Forte", 3.5, 4, LocalDate.parse("19/12/2021",fmt),  LocalDate.parse("23/11/2021",fmt),"23");
		cadastrarProduto(0002, "Café", "Pilão Fraco", 3, 4, LocalDate.parse("15/12/2021",fmt),  LocalDate.parse("28/11/2021",fmt),"34");
		cadastrarProduto(0003, "Leite", "Parmalat integral", 7, 7, LocalDate.parse("13/10/2021",fmt),  LocalDate.parse("23/12/2021",fmt),"12");
		cadastrarProduto(0004, "Bala FINI", "Jujuba", 2, 16, LocalDate.parse("21/04/2023",fmt),  LocalDate.parse("23/11/2016",fmt),"A");
		cadastrarProduto(0005, "Papel Higienico", "Marca genérica", 8, 9, LocalDate.parse("19/12/2021",fmt),  LocalDate.parse("23/11/2021",fmt),"D");
		cadastrarProduto(0006, "Arroz", "Tio João tipo A", 14, 19, LocalDate.parse("01/12/2024",fmt),  LocalDate.parse("21/10/2021",fmt),"7");
		cadastrarProduto(0007, "Arroz", "Tio João Integral", 9.49, 30, LocalDate.parse("02/05/2024",fmt),  LocalDate.parse("09/08/2025",fmt),"1");
		
		
		
	}

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
