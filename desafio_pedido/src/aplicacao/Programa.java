package aplicacao;
import java.util.Scanner;

import entidade.Produto;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		Produto prod; 
		
		prod = new Produto(); 
		
		System.out.println("digite os dados do produto:");
		
		System.out.println("Nome:");
		prod.nome = sc.nextLine(); 
		
		System.out.println("Preço:");
		prod.preco = sc.nextDouble();
	
		System.out.println("Quantidade:");
		prod.quantidade = sc.nextInt();
		
		
		System.out.println("\nDados do Produto: " + prod);
		System.out.println("\nQuantos novos produtos serão adicionados? ");
		int quantidade = sc.nextInt();
		prod.addProduto(quantidade);
		System.out.println("\nDados Atualizados: " + prod);
		
		System.out.println("\nQuantos produtos serão removidos? ");
		quantidade = sc.nextInt();
		prod.addRemo(quantidade); 
		System.out.println("\nDados Atualizados: " + prod);
		
		sc.close();
	}

}
