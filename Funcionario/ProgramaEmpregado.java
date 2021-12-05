import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgramaEmpregado {
	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");
		List<Empregado> empregados = new ArrayList<Empregado>();
		int i = 0;

		// a. Criar três empregados a partir da leitura de dados do teclado e
		// armazená-los em uma Arraylist
		do {
			i++;
			System.out.println("Digite o nome do " + i + "º empregado: ");
			String nome = scn.next();
			scn.nextLine();
			System.out.println("Digite o salário mensal do empregado: ");
			Double salario = scn.nextDouble();
			scn.nextLine();
			empregados.add(new Empregado(nome, salario));
		} while (i != 3);

		// b. Calcular a média dos salários e imprimir na tela
		double soma = 0;
		if (!empregados.isEmpty()) {
			System.out.println("- - - Empregados - - -");
			System.out.println("Nome\tSalario");
			for (int j = 0; j < empregados.size(); j++) {
				if (empregados.get(j) != null) {
					soma += empregados.get(j).getSalarioMensal();
					System.out.println(empregados.get(j).getNome() + "\t R$" + empregados.get(j).getSalarioMensal());
				}
			}
			double mediaSalarial = (soma / empregados.size());
			System.out.println("Média dos salários: R$ " + df.format(mediaSalarial));

			// c. Para cada empregado com salário abaixo da média, aumentar o salário do
			// funcionário em 10%
			for (int j = 0; j < empregados.size(); j++) {
				if (empregados.get(j) != null) {
					if (empregados.get(j).getSalarioMensal() < mediaSalarial)
						empregados.get(j).setSalarioMensal(empregados.get(j).getSalarioMensal() * 1.10);
				}
			}

			// d. Imprimir o menor salário dentre os funcionários.
			double menorSalario = empregados.get(0).getSalarioMensal();
			System.out.println("- - - Empregados - - -");
			System.out.println("Nome\tSalario");
			for (int j = 0; j < empregados.size(); j++) {
				if (empregados.get(j) != null) {
					System.out.println(
							empregados.get(j).getNome() + "\t R$" + df.format(empregados.get(j).getSalarioMensal()));
					if (empregados.get(j).getSalarioMensal() < menorSalario)
						menorSalario = empregados.get(j).getSalarioMensal();
				}
			}
			System.out.println("Menor salário dentro os funcionários: R$ " + df.format(menorSalario));
		} else {
			System.out.println("Nenhum empregado no ArrayList!");
		}

		scn.close();
	}
}
