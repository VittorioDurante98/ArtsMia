package it.polito.tdp.artsmia.model;

public class Adiacenza {
	
	public Integer o1;
	public Integer o2;
	public Integer peso;
	
	public Adiacenza(Integer o1, Integer o2, Integer peso) {
		
		this.o1 = o1;
		this.o2 = o2;
		this.peso = peso;
	}
	
	public Integer getO1() {
		return o1;
	}
	public void setO1(Integer o1) {
		this.o1 = o1;
	}
	public Integer getO2() {
		return o2;
	}
	public void setO2(Integer o2) {
		this.o2 = o2;
	}
	public Integer getPeso() {
		return peso;
	}
	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	
	
}
