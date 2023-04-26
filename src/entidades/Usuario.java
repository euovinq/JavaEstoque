package entidades;

public abstract class Usuario {
	
	private String nome;
	private String user;
	private String senha;
	
	
	public abstract void fazerLogin();
	public abstract void fazerLogout();
	
	
	public Usuario(String nome, String user, String senha) {
		

		this.nome = nome;
		this.user = user;
		this.senha = senha;
		
	}
	
	
	

}
