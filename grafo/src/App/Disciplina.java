package App;

public class Disciplina {
	private String nome;
	private int codigo;
	private int periodo;
	
	public Disciplina(String nome, int codigo, int periodo) {
		this.codigo = codigo;
		this.nome = nome;
		this.periodo = periodo;
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
	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	
	@Override
	public String toString(){
		return this.codigo + "-" + this.nome + ", ";
	}

}
