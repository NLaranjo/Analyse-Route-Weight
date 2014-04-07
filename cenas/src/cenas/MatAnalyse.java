package cenas;

import java.util.ArrayList;

public class MatAnalyse {

	ArrayList<Nodo> grafo;
	ArrayList<Mat> traf;
	ArrayList<Thread> tre;
	int perdido;

	public MatAnalyse( ArrayList<Nodo> a,  ArrayList<Mat> m  ){
		grafo=a;
		traf=m;
		tre= new ArrayList<Thread>();
		perdido=0;
	} 

	public Nodo findbyid(int id){
		Nodo res=null;
		for(Nodo n : grafo){
			if(n.id==id){
				res=n;
			}
		}
		return res;
	}

	public void calcEnc() throws InterruptedException{
		for(Nodo e : grafo){
			if(e instanceof Edge){
				Edge er= (Edge) e;
				((Edge) e).setGrafo(grafo);
				Thread cenas= new Thread(er);
				tre.add(cenas);
				cenas.start();
			}

		}
		for(Thread t: tre)
			t.join();
	}

	public void calcTraf(){
		int ant=0,pos=0;
		for(Nodo e : grafo){
			if(e instanceof Edge){
				Edge er= (Edge) e;
				for(Mat m: traf)
				{
					if(m.In.EqId(e.getId())){
						ant=er.pred[m.Out.id];
						pos=m.Out.id;
						m.Out.uso+=m.traf;

						do
						{												

							Nodo tmp= findbyid(pos);
							tmp.addtraf(ant, m.traf);
							tmp= findbyid(ant);
							tmp.addtraf(pos, m.traf);
							tmp.uso+=m.traf;
							pos=ant;
							ant=er.pred[ant];


						}while(ant!=pos);

					}
				}
			}

		}

	}

	public void printNodo(){
		for(Nodo n: grafo){
			System.out.print(n.show()+"\n");
		}

	} 
	
	public void printlink(){
		for(Nodo n:grafo){
			System.out.print("link de "+n.id+"\n");
			for(Link l:n.links)
			{
				System.out.print(l.toString()+"\n");
			}
		}

	}
	
	public void calcwarnlink(){
		for(Nodo n:grafo){
			for(Link l:n.links)
			{
				if(l.capacidade<= l.uso){l.setdanger(true);}
			}
		}

	}
	
	public void calcwarnnodo(){
		for(Nodo n: grafo){
			if(n.uso>=n.capacidade)n.danger=true; 
		}

	}
	
	public void calcularPerdido(){
		for (Nodo n : grafo){
			for (Link l: n.getLinks()){
				if (l.capacidade<l.uso){
					perdido= perdido+(l.uso-l.capacidade);
				}
			}
		}
		
		
	}
	
	public void showtraf(){
		for(Mat n: traf){System.out.print(n.toString() + "\n");}
	} 
	
	public void showperd(){
		System.out.print("O trafego que está a ser perdido é:"+perdido);
		
		
		
	}
	public void showTudo(){
		System.out.print("graph g{\n");
		for(Nodo n :grafo){
			for(Link l: n.getLinks())
				if (n.getId()<l.destino.id)
					{
						if(l.danger==false)
						System.out.print(n.id+ "--"+ l.destino.getId()+ "[ color = \" "+"green" +"\" label=\""+ (((float)l.uso/l.capacidade)*100) +"\"]"+ ";\n");
						else
						System.out.print(n.id+ "--"+ l.destino.getId()+ "[ color = \" "+"red" +"\" label=\""+ (((float)l.uso/l.capacidade)*100) +"\"]"+ ";\n");

							
					
					}
		}
		System.out.print("}\n");

	}
}






