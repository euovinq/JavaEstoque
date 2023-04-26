package entidades;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import java.util.Scanner;

import javax.xml.transform.sax.SAXSource;

public class Navegacao {

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

	public void menuPrincipal() throws InterruptedException, IOException {
		login();
		limparTela();
		System.out.println("Software de Mercado\n");
		System.out.println("1 - Cadastro de Item");
		System.out.println("2 - Editar Produto");
		System.out.println("3 - Relatório");
		System.out.println("4 - Listar Produtos que vencem em 30 dias ou vencidos");
		System.out.println("5 - Sair");

	}

	public void login() throws InterruptedException, IOException {
		while (true) {
			limparTela();
			Scanner sc = new Scanner(System.in);
			String user = "admin";
			String pass = "123456";
			System.out.println("Login\n");
			System.out.print("Digite seu Usuário: ");
			String usuario = sc.next();
			System.out.print("Digite sua Senha: ");
			String senha = sc.next();

			if (user.equals(usuario) && pass.equals(senha)) {

				
				break;
				

			} else {
				System.out.println();
				System.out.println("Usuário ou Senha incorreta.");
				pressionarTecla();
				continue;
			}
		}
	}

	public void editarProduto() {

		System.out.println("Menu de Edição\n");
		System.out.println("1 - Editar Quantidade");
		System.out.println("2 - Editar Nome");
		System.out.println("3 - Editar Valor");
		System.out.println("4 - Retornar ao Menu");
		System.out.println("5 - Sair");

	}

	public void relatorio() throws InterruptedException, IOException {

		limparTela();
		System.out.println("### Relatório ###");
		System.out.println();
		for (Produto x : produtos) {
			System.out.printf("#000%d / %s / %s / %d un / R$ %.2f / ", x.getCod(), x.getNome(), x.getMarcaDescricao(),
					x.getQuantidade(), x.getValor());
			if (diasValidade(x) > 0) {
				System.out.printf("Produto vence em %d dias, Gondola %s", diasValidade(x), x.getGondola());
				System.out.println();
			} else {
				System.err.print("Produto está vencido, Retirar da Gondola " + x.getGondola());
				System.out.println();
			}
			System.out.println();
		}

	}

	public void listarValidades() {

		System.out.println("Listar Validades\n");
	}

	public boolean sair() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Deseja realmente sair?");
		Character op = sc.next().toLowerCase().charAt(0);
		sc.close();
		if (op == 's') {

			System.out.println("Saindo...");
			return true;
		} else {
			return false;
		}

	}

	public void cadastroDeItem() throws InterruptedException, IOException {

		try {

			while (true) {

				limparTela();

				DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

				System.out.println("Software de Mercado\n");
				Scanner sc = new Scanner(System.in);

				System.out.print("Digite o nome do produto: ");
				String nome = sc.nextLine();

				System.out.print("Digite a Quantidade: ");
				int quantidade = sc.nextInt();

				System.out.print("Digite a Preço: ");
				Double preco = sc.nextDouble();

				System.out.print("Digite a o Código do Produto: ");
				int codigo = sc.nextInt();

				System.out.print("Digite a Validade do Produto: ");
				LocalDate validade = LocalDate.parse(sc.next(), fmt);

				System.out.print("Digite a Fabricacao do Produto: ");
				LocalDate fabricacao = LocalDate.parse(sc.next(), fmt);

				System.out.print("Digite a Marca e Descrição do produto: ");
				String marcaDescricao = sc.nextLine();
				sc.nextLine();

				System.out.print("Digite a Gondola que o produto estará: ");
				String gondola = sc.nextLine();

				Produto prod = new Produto(nome, preco, quantidade, validade, fabricacao, codigo, marcaDescricao,
						gondola);

				cadastrarProduto(prod);

				System.out.println();
				System.out.print("Deseja cadastrar mais um item? ");
				String opcao = sc.next();

				if (opcao.toLowerCase().charAt(0) == 's') {
					continue;
				} else {
					break;
				}

			}

		} catch (java.time.format.DateTimeParseException e) {
			System.out.println("Você digitou a Data errado! Digite certo na próxima.");
			pressionarTecla();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Você digitou algo errado! digite corretamente na próxima.");
			pressionarTecla();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			pressionarTecla();
		}
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

	public void limparTela() throws InterruptedException, IOException {
		if (System.getProperty("os.name").contains("Windows"))
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		else
			Runtime.getRuntime().exec("clear");
	}

	public void voltarAoMenu() throws InterruptedException, IOException {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println();
			System.out.print("Voltar ao Menu Principal ? s/n ");
			String opcao = sc.next();

			if (opcao.toLowerCase().charAt(0) == 's') {

				limparTela();
				menuPrincipal();
				break;
			} else {
				limparTela();
				continue;

			}
		}
	}

	public void pressionarTecla() {

		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.print("Digite qualquer coisa para voltar ao inicio : ");
		String opcao = sc.next();

	}

}
