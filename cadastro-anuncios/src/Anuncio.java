import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Anuncio {
	private String nome;
	private String cliente;
	private String dataI;
	private String dataT;
	private Double valorInvestido;

	public Anuncio(String nome, String cliente, String dataI, String dataT, Double inves) {
		super();
		this.nome = nome;
		this.cliente = cliente;
		this.dataI = dataI;
		this.dataT = dataT;
		this.valorInvestido = inves;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getDataI() {
		return dataI;
	}

	public void setDataI(String dataI) {
		this.dataI = dataI;
	}

	public String getDataT() {
		return dataT;
	}

	public void setDataT(String dataT) {
		this.dataT = dataT;
	}

	public Double getInves() {
		return valorInvestido;
	}

	public void setInves(Double inves) {
		this.valorInvestido = inves;
	}

	public Double getValorTotalInvestido() {
		try {
			Date inicio = new SimpleDateFormat("dd/MM/yyyy").parse(dataI);
			Date fim = new SimpleDateFormat("dd/MM/yyyy").parse(dataT);
			long mili = fim.getTime() - inicio.getTime();
			long dias = TimeUnit.DAYS.convert(mili, TimeUnit.MILLISECONDS);
			return valorInvestido * dias;
		} catch (ParseException e) {
			e.printStackTrace();
			return 0.0;
		}
	}

	@Override
	public String toString() {
		double qntVisualizacao, qntClique, qntCompartilhamento, qntNovaVisualizacao;
		qntVisualizacao = getValorTotalInvestido() * 30;
		qntClique = 12 * qntVisualizacao / 100;
		qntCompartilhamento = 15 * qntClique / 100;
		qntNovaVisualizacao = qntCompartilhamento * 40;

		return String.format(
				"Nome do anuncio: %s\nNome do cliente: %s\nData de inicio: %s\nData termino: %s\nInvestimento por dia R$: %.2f\nValor total investido R$: %.2f\nQuantidade de visualizações: %.0f\nQuantidade de cliques: %.0f\nQuantidade de compartilhamentos: %.0f\nQuantidade de novas visualizações: %.0f",
				nome, cliente, dataI, dataT, valorInvestido, getValorTotalInvestido(), qntVisualizacao, qntClique,
				qntCompartilhamento, qntNovaVisualizacao);
	}

}
