package entidades;

import java.time.LocalDate;


public class Produto {
	
	private String nome;
	private Double valor;
	private int quantidade;
	private LocalDate validade;
	private LocalDate fabricacao;
	private int cod;
	private String marcaDescricao;
	private String gondola;
	
	
	
	
	public String getMarcaDescricao() {
		return marcaDescricao;
	}

	public void setMarcaDescricao(String marcaDescricao) {
		this.marcaDescricao = marcaDescricao;
	}
	
	public Produto(String nome, int quantidade) {
		
		this.nome = nome;
		this.quantidade = quantidade;
		
	}

	public Produto(String nome, Double valor, int quantidade, LocalDate validade, LocalDate fabricacao, int cod, String marcaDescricao, String gondola) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
		this.validade = validade;
		this.fabricacao = fabricacao;
		this.cod = cod;
		this.marcaDescricao = marcaDescricao;
		this.gondola = gondola;
	}

	public String getGondola() {
		return gondola;
	}

	public void setGondola(String gondola) {
		this.gondola = gondola;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

	public LocalDate getFabricacao() {
		return fabricacao;
	}

	public void setFabricacao(LocalDate fabricacao) {
		this.fabricacao = fabricacao;
	}

	public int getCod() {
		return cod;
	}
	
	

	public void setCod(int cod) {
		this.cod = cod;
	}

	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", quantidade=" + quantidade + "]";
	}
	
	

}
