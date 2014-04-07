package cenas;

import java.util.ArrayList;


public class Edge extends Nodo implements Runnable{

	int distancias[];
	int pred[];
	Djisktra a;


	public Edge (int id, int cap ){
		super(id,cap);
		a= null;
	}

	public void setGrafo(ArrayList<Nodo> x)
	{
		a= new Djisktra(x, x.size());

	}

	@Override
	public void run() {
		a.execute(this);
		this.distancias= a.distancias;
		this.pred= a.pred;

	}

}
