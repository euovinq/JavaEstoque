package programa;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entidades.Navegacao;
import entidades.Produto;

public class Programa {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Navegacao navegacao = new Navegacao();
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		
		// PRODUTOS AVULSOS 
		navegacao.cadastrarProduto(0001, "Café", "Pilão Extra Forte", 3.5, 4, LocalDate.parse("19/12/2021",fmt),  LocalDate.parse("23/11/2021",fmt),"23");
		navegacao.cadastrarProduto(0002, "Café", "Pilão Fraco", 3, 4, LocalDate.parse("15/12/2021",fmt),  LocalDate.parse("28/11/2021",fmt),"34");
		navegacao.cadastrarProduto(0003, "Leite", "Parmalat integral", 7, 7, LocalDate.parse("13/10/2021",fmt),  LocalDate.parse("23/12/2021",fmt),"12");
		navegacao.cadastrarProduto(0004, "Bala FINI", "Jujuba", 2, 16, LocalDate.parse("21/04/2023",fmt),  LocalDate.parse("23/11/2016",fmt),"A");
		navegacao.cadastrarProduto(0005, "Papel Higienico", "Marca genérica", 8, 9, LocalDate.parse("19/12/2021",fmt),  LocalDate.parse("23/11/2021",fmt),"D");
		navegacao.cadastrarProduto(0006, "Arroz", "Tio João tipo A", 14, 19, LocalDate.parse("01/12/2024",fmt),  LocalDate.parse("21/10/2021",fmt),"7");
		navegacao.cadastrarProduto(0007, "Arroz", "Tio João Integral", 9.49, 30, LocalDate.parse("02/05/2024",fmt),  LocalDate.parse("09/08/2025",fmt),"1");
		
		
		
		while(true){
			
			navegacao.limparTela();
			navegacao.menuPrincipal();
			System.out.println();
			System.out.print("Digite uma opção: ");
			int op = sc.nextInt();
			if(op == 1) {		
				navegacao.cadastroDeItem();
				continue;
				
			} else if(op == 2) {
				
				navegacao.limparTela();
				System.out.println("Menu de edição");
				continue;
			} else if(op == 3) {
				navegacao.relatorio();
				navegacao.voltarAoMenu();
				continue;
			} else if(op == 4) {
				navegacao.limparTela();
				System.out.println("Listar Produtos que vencem em 30 dias ou vencidos");
				System.out.println();
				for(Produto x : navegacao.getProdutos()) {

					if(navegacao.diasValidade(x) <= 30){

						System.out.println("Nome: " + x.getNome() + " Validade: " + fmt.format(x.getValidade()));
					}
					
				}
				
				navegacao.voltarAoMenu();
				
			}else if(op == 5){
				navegacao.limparTela();
				System.out.print("Deseja realmente sair? ");
				String opcao = sc.next();
				if(opcao.toLowerCase().charAt(0) == 's') {
					System.out.println("Você saiu do programa");
					break;
				}else {
					continue;
				}

			}else {
				navegacao.limparTela();
				System.out.println("Opção Inválida!");
				continue;
			}
			
			
			
				
			
			
		}
		
		
		sc.close();
		
		
		
	}
		
		
		

		
		
	}
	
	


