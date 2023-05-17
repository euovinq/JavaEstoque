package entidades;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Navegacao {
	
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	
	Estoque estoque = new Estoque(); 

	
	public void menuPrincipal() throws InterruptedException, IOException {
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

	public void editarProduto() throws InterruptedException, IOException {
		
		limparTela();
		Scanner sc = new Scanner(System.in);
		
		for (Produto itemProduto : estoque.getProdutos()) {
			
			System.out.printf("%d - %s \n", itemProduto.getCod(), itemProduto.getNome());
			
		}
		System.out.println("Digite o codigo para editar um produto: ");
		int op = sc.nextInt();
		
		for(Produto item : estoque.getProdutos()) {
			
			if(op == item.getCod()) {
				
				limparTela();
				System.out.println("Menu de Edição\n");
				System.out.println("1 - Editar Quantidade");
				System.out.println("2 - Editar Nome");
				System.out.println("3 - Editar Valor");
				System.out.println("4 - Retornar ao Menu");
				System.out.println("5 - Sair");
				System.out.print("Digite uma opção: ");
				
				int opcao = sc.nextInt();
				
				switch (opcao) {
				case 1:
					limparTela();
					System.out.print("Digite a nova quantidade: ");
					item.setQuantidade(sc.nextInt());
					System.out.println("Quantidade alterada com sucesso");
					System.out.println();
					System.out.println("Digite alguma coisa e aperte enter para voltar ao menu");
					sc.next();
					break;
					
				case 2:
					limparTela();
					System.out.print("Digite o novo nome: ");
					sc.nextLine();
					item.setNome(sc.nextLine());;
					System.out.println("Nome alterado com sucesso");
					System.out.println();
					System.out.println("Digite alguma coisa e aperte enter para voltar ao menu");
					sc.next();
					break;
					
				case 3:
					limparTela();
					System.out.print("Digite o novo valor: ");
					item.setValor(sc.nextDouble());
					System.out.println("Valor alterado com sucesso");
					System.out.println();
					System.out.println("Digite alguma coisa e aperte enter para voltar ao menu");
					sc.next();
					break;
					
				case 4:
					voltarAoMenu();
					break;
				case 5:
					sair();
					break;

				default:
					System.out.println("Opção Inválida");
					
					
				}
				
				
			} 
			
			
			
		}
		
		
		
		


	}



	

	public boolean sair() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Deseja realmente sair?");
		Character op = sc.next().toLowerCase().charAt(0);
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

				
				int codigo = estoque.getProdutos().size() + 1;

				System.out.print("Digite a Validade do Produto: ");
				LocalDate validade = LocalDate.parse(sc.next(), fmt);

				System.out.print("Digite a Fabricacao do Produto: ");
				LocalDate fabricacao = LocalDate.parse(sc.next(), fmt);
				sc.nextLine();
				System.out.print("Digite a Marca e Descrição do produto: ");
				String marcaDescricao = sc.nextLine();

				System.out.print("Digite a Gondola que o produto estará: ");
				String gondola = sc.nextLine();

				Produto prod = new Produto(nome, preco, quantidade, validade, fabricacao, codigo, marcaDescricao,
						gondola);

				estoque.cadastrarProduto(prod);

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

	public void limparTela() throws InterruptedException, IOException {
		if (System.getProperty("os.name").contains("Windows"))
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		else
			Runtime.getRuntime().exec("clear");
	}

	public void voltarAoMenu() throws InterruptedException, IOException {

		

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println();
			System.out.print("Voltar ao Menu Principal ? s/n ");
			String opcao = sc.next();

			if (opcao.toLowerCase().charAt(0) == 's') {

				limparTela();
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
	
	public void relatorio() {
		System.out.println("### Relatório ###");
		System.out.println();
		for (Produto x : estoque.getProdutos()) {
			System.out.printf("#000%d / %s / %s / %d un / R$ %.2f / ", x.getCod(), x.getNome(), x.getMarcaDescricao(),
					x.getQuantidade(), x.getValor());
			if (estoque.diasValidade(x) > 0) {
				System.out.printf("Produto vence em %d dias, Gondola %s", estoque.diasValidade(x), x.getGondola());
				System.out.println();
			} else {
				System.out.print("Produto está vencido, Retirar da Gondola " + x.getGondola());
				System.out.println();
			}
			System.out.println();
		}

	}
	
	public void listarProdutosVencidos() {
		System.out.println("Listar Produtos que vencem em 30 dias ou vencidos");
		System.out.println();
		for(Produto x : estoque.getProdutos()) {

			if(estoque.diasValidade(x) <= 30){

				System.out.println("Nome: " + x.getNome() + " Validade: " + fmt.format(x.getValidade()));
			}
			
		}
	}
	

}
