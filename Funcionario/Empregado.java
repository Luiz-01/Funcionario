
public class Empregado {
	private String nome;
	private double salarioMensal;

	public Empregado(Empregado empregado) {
		this.nome = empregado.getNome();
		this.salarioMensal = empregado.getSalarioMensal();
	}

	public Empregado(String nome, double salarioMensal) {
		this.nome = nome;
		if (salarioMensal < 0)
			this.setSalarioMensal(0);
		else
			this.salarioMensal = salarioMensal;
	}

	public Empregado() {
		this.nome = "";
		this.salarioMensal = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalarioMensal() {
		return salarioMensal;
	}

	public void setSalarioMensal(double salarioMensal) {
		this.salarioMensal = salarioMensal;
	}

}
