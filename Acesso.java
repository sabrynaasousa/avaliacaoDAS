
public class Acesso {

	public static final float VALOR_FRACAO = (float) 2.0;
	public static final float VALOR_HORA = (float) 7.0;
	public static final float VALOR_DIARIA = (float) 30.0;
	
	public String placa;
	public int dia, mes, ano;
	public int horaEntrada, 
	           minutosEntrada;
	public int horaSaida, 
			   minutosSaida;
	
	public Acesso() {}

	
	public Acesso(int dia, int mes, int ano, int horaEntrada, int minutosEntrada) { 
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.horaEntrada = horaEntrada;
		this.minutosEntrada = minutosEntrada;
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
	
	public float calcularValor() { 
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
	
	
	public void setHoraSaida(int horaSaida) {
		this.horaSaida = horaSaida;
	}


	public void setMinutosSaida(int minutosSaida) {
		this.minutosSaida = minutosSaida;
	}
	
	
	
}
