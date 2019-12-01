package br.com.cinema.model;

public enum StatusFilme {
	breve(0),
	emCartaz(1);
	
	private int status;
	
	private StatusFilme(int status) {
		this.status = status;
	}
	
	public int getValue() {
		return this.status;
	}
}
