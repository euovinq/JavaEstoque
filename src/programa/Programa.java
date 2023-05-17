package programa;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import entidades.Navegacao;

public class Programa {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		Navegacao navegacao = new Navegacao();

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		navegacao.login();
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
				navegacao.editarProduto();
				continue;
			} else if(op == 3) {
				
				navegacao.relatorio();
				navegacao.voltarAoMenu();

				continue;
			} else if(op == 4) {
				navegacao.limparTela();
				navegacao.listarProdutosVencidos();

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
	
	


