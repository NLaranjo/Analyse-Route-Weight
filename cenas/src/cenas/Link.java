package cenas;


public class Link {

	Nodo destino;
	int capacidade;
	int peso;
	int uso;
	boolean danger;

	public Link (Nodo Des, int cap, int pe){
		this.destino=Des;
		this.capacidade= cap;
		this.peso=pe;
		this.uso=0;
		this.danger=false;

	}

	public Nodo getDestino() {
		return destino;
	}
	public void setDestino(Nodo destino) {
		this.destino = destino;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public void setdanger(boolean b){
		danger=b;}
	@Override
	public String toString() {
		return "Link [destino=" + destino + ", capacidade=" + capacidade
				+ ", peso=" + peso + ", uso=" + uso + "]" + "danger:" + danger;
	}





}
