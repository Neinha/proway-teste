import java.util.ArrayList;
import java.util.Scanner;

public class ControleAnuncio {
	private Scanner scanner = new Scanner(System.in);
	private ArrayList<Anuncio> anuncios = new ArrayList<>();

	private String mostrarMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("Digite a opção: \n");
		sb.append("1 - Cadastrar anuncio: \n");
		sb.append("2 - Imprimir lista de anuncios: \n");
		sb.append("3 - Sair: \n");
		System.out.println(sb.toString());

		return scanner.nextLine();
	}

	public void iniciar() {
		String opcao = mostrarMenu();
		while (!opcao.equals("3")) {
			switch (opcao) {
			case "1":
				System.out.println("Nome do anuncio: ");
				String nome = scanner.nextLine();
				System.out.println("Nome do cliente: ");
				String cliente = scanner.nextLine();
				System.out.println("Data de inicio: ");
				String dataI = scanner.nextLine();
				System.out.println("Data de termino: ");
				String dataT = scanner.nextLine();
				System.out.println("Valor do investimento por dia: R$ ");
				double inves = Double.parseDouble(scanner.nextLine());

				Anuncio anuncio = new Anuncio(nome, cliente, dataI, dataT, inves);
				anuncios.add(anuncio);

				opcao = mostrarMenu();
				break;
			case "2":
				for (Anuncio a : anuncios) {
					System.out.println(a.toString());
				}
				opcao = mostrarMenu();
				break;

			default:
				System.out.println("Opção inválida");
				opcao = mostrarMenu();
				break;

			}
		}
	}
}
