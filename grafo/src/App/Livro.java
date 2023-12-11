package App;

public class Livro {
	private String nome;
	private int codigo;
	
	public Livro(String nome, int codigo) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	
	@Override
	public String toString(){
		return this.nome;
	}

}
