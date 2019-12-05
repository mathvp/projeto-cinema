package br.com.cinema.model;

public class Sala {
	

	int id;
	int numeroSala;
	int limiteReserva;
	int qtdReservada;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumeroSala() {
		return numeroSala;
	}
	public void setNumeroSala(int numeroSala) {
		this.numeroSala = numeroSala;
	}
	public int getLimiteReserva() {
		return limiteReserva;
	}
	public void setLimiteReserva(int limiteReserva) {
		this.limiteReserva = limiteReserva;
	}
	public int getQtdReservada() {
		return qtdReservada;
	}
	public void setQtdReservada(int qtdReservada) {
		this.qtdReservada = qtdReservada;
	}
}
