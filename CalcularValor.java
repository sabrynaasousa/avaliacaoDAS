
public class CalcularValor {
	
	public static final float VALOR_FRACAO = (float) 2.0;
	public static final float VALOR_HORA = (float) 7.0;
	public static final float VALOR_DIARIA = (float) 30.0;

	private final Acesso _acesso;
	private int horaSaida;
	private int horaEntrada;
	private int minutosSaida;
	private int minutosEntrada;
	
	//Objeto-Metodo
	
	public CalcularValor (Acesso acesso, int horaFinal, int horaInicial, int minutosInicial, int minutosFinal){
		_acesso = acesso;
		horaSaida = horaFinal;
		horaEntrada = horaInicial;
		minutosSaida = minutosFinal;
		minutosEntrada = minutosInicial;
	}

	public int calculaQuantidadeHoras(int horasS, int horasE, int minutosS, int minutosE){
		final int quantidadeHorasInicial = horaSaida - horaEntrada;

		if (horaSaida > horaEntrada && minutosSaida < minutosEntrada){
			final int quantidadeHorasI = quantidadeHorasInicial - 1;
			return quantidadeHorasI;
		}
		else{
			return quantidadeHorasInicial;
		}		
	}
	
	public int calculaQuantidadeMinutos(int horasS, int horasE, int minutosS, int minutosE){
		final int quantidadeMinutosInicial = minutosSaida - minutosEntrada;

		if (horaSaida > horaEntrada && minutosSaida < minutosEntrada){
			final int quantidadeMinutosI = minutosSaida + (60 - minutosEntrada);
			return quantidadeMinutosI;
		}
		else{
			return quantidadeMinutosInicial;
		}	
	}
	
	public float compute() { 
		float valorTotal = 0; 
		int quantidadeHoras = calculaQuantidadeHoras(horaSaida, horaEntrada, minutosSaida, minutosEntrada);
		valorTotal += quantidadeHoras * VALOR_HORA;
		int quantidadeMinutos = calculaQuantidadeMinutos(horaSaida, horaEntrada, minutosSaida, minutosEntrada);
		valorTotal += Math.ceil(quantidadeMinutos/ 15.0) * VALOR_FRACAO;		
		
		if (quantidadeHoras >=9)
			return VALOR_DIARIA;
		else 
			return valorTotal;
	}

}
