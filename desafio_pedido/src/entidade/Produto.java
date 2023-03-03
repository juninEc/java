package entidade;

public class Produto {
	public String nome; 
	public double preco; 
	public int quantidade; 
	
	public double valorEstoque() {
		return preco * quantidade; 
	}
	
	public void addProduto(int quantidade) {
		
		this.quantidade += quantidade;  
	}
	
	public void addRemo(int quantidade) {
		
		this.quantidade -= quantidade;  
	}
	public String toString(){
		return nome + ", R$" + String.format("%.2f", preco) + ", " + quantidade + " unidade, Total: R$" + String.format("%.2f", valorEstoque());
	}
	
}
