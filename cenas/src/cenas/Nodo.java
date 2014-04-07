package cenas;
import java.util.ArrayList;


public class Nodo implements Comparable<Nodo>{

	ArrayList<Link> links;
	int id;
	int uso;
	int capacidade;
	boolean danger;

	public Nodo(int i) {
		links= new ArrayList<Link>();
		id=i; 
		uso=0;
		capacidade =0;
		danger=false;
	}
	
	public Nodo(int i, int cap) {
		links= new ArrayList<Link>();
		id=i; 
		uso=0;
		capacidade =cap;
		danger=false;
		
	}
	
	public Nodo() {
		links=null;
		id=-1;
		uso=0;
		capacidade =0;
		danger=false;
	}

	public Nodo(Nodo other){
		this.links=(ArrayList<Link>) other.getLinks().clone();
		this.id=other.getId();
		this.capacidade=other.capacidade;
		danger= other.danger;
	}
	
	

	public ArrayList<Link> getLinks() {
		return links;
	}
	
	public void setdanger(boolean b){danger=b;}

	public void addtraf(int dest, int traf){
		Link l;
		l=findlink(dest);
		l.uso+=traf;

	}

	public Link findlink(int id){
		Link res=null;
		for (Link l: links){
			if(l.getDestino().id==id){
				res=l;
			}

		}
		return res;
	}

	public void setLinks(ArrayList<Link> links) {
		this.links = links;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nodo other = (Nodo) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public void addlink( Link l){

		links.add(l);
	}

	@Override
	public int compareTo(Nodo arg0) {
		if (this.id < arg0.getId() ) return -1;
		else if (this.id > arg0.getId()) return 1;
		else return 0;
	}

	public String show() {
		return "Nodo [id=" + id + "]" + capacidade;
	}


	@Override
	public String toString() {
		return "Nodo [id=" + id + "]" ;
	}

	public boolean EqId(int i){
		boolean res=false;
		if (i==this.getId()) res=true;
		return res;

	}


}
