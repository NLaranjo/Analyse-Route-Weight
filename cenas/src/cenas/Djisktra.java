package cenas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;


public class Djisktra {
	ArrayList<Nodo> Grafo;
	TreeSet<Nodo> fila;
	int[] distancias;
	int[] pred;
	int size;
	TreeSet<Nodo> done;




	public Djisktra (ArrayList<Nodo> a, int size)
	{
		ArrayList<Nodo> clone = (ArrayList<Nodo>) a.clone();
		Grafo=clone;
		fila= new TreeSet<Nodo>();
		done= new TreeSet<Nodo>();
		distancias= new int[size];
		for(int i =0; i<size; i++)
			distancias[i]=999; 
		pred= new int[size];
		for(int i=0; i<size ; i++)
			pred[i]=9999;
		this.size=size;

	}

	public Nodo getbyid (int id)
	{
		Nodo d=null;
		for (Nodo s: Grafo )
		{
			if(s.id==id){d=new Nodo(s);}
		} 
		return d;	

	}


	public Nodo nexter()
	{
		int ant=9999;
		Nodo res= new Nodo();
		for(Nodo n: fila){
			if (distancias[n.getId()] < ant && !(done.contains(n)))
			{
				ant=distancias[n.getId()];
				res=n;
			}
		}

		return res;

	}
	public void execute(Nodo inicio)
	{
		fila.add(inicio);
		distancias[inicio.getId()]=0;
		pred[inicio.getId()]=inicio.getId();
		for(Link a: inicio.getLinks()){
			distancias[a.getDestino().getId()]=a.getPeso();
			pred[a.getDestino().getId()]= inicio.getId();
		}

		while(!fila.isEmpty())
		{
			Nodo work= nexter();		
			for (Link a:work.getLinks())
			{
				Nodo dest=a.getDestino();
				int peso = a.getPeso();
				int dist= distancias[work.getId()] + peso;
				if( !(done.contains(dest))) fila.add(dest);
				if(dist < distancias[dest.getId()]  )
				{				
					distancias[dest.getId()]= dist;
					pred[dest.getId()]= work.getId();
				}
			}
			fila.remove(work);
			done.add(work);
		}
	}



	@Override
	public String toString() {
		return "Djisktra [Grafo=" + Grafo + ", visitados=" + fila
				+ ", distancias=" + Arrays.toString(distancias) + ", pred="
				+ Arrays.toString(pred) + ", size=" + size + "]";
	}




}
