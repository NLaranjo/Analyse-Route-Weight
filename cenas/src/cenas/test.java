package cenas;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;


public class test {

	public static void main(String[] args) throws IOException, InterruptedException {
		File gra = new File("/home/mich/outer");
		BufferedReader br = new BufferedReader(new FileReader(gra));
		String line;
		int id =-1;
		Scanner a = new Scanner(gra);
		ArrayList <Nodo> grafo= new ArrayList <Nodo>();
		ArrayList <Mat> mat= new ArrayList<Mat>();
		TreeMap<String,Nodo> dic= new TreeMap<String,Nodo>(); 
		
			
			while ((line = br.readLine()) != null) {
				String[] b= line.split(" ");
				if(b[0].contentEquals("Nodo")){
					id=id+1;
					int ba=Integer.parseInt(b[2]);
					Nodo tmp = new Nodo(id,  ba);
					grafo.add(tmp);
					dic.put(b[1], tmp);}
				else if(b[0].contentEquals("Edge")){
					id=id+1;
					int ba=Integer.parseInt(b[2]);
					Edge tmp = new Edge(id,  ba);
					grafo.add(tmp);
					dic.put(b[1], tmp);
				}
				else if( b[0].contentEquals("Link")){
					String name1=b[1];
					String name2=b[2];
					Nodo n1= dic.get(name1);
					Nodo n2 = dic.get(name2);
					int cap=Integer.parseInt(b[3]);
					int pes=Integer.parseInt(b[4]);
					Link l1= new Link(n1, cap,pes);
					Link l2 = new Link(n2, cap ,pes);
					n1.addlink(l2);
					n2.addlink(l1);
				}
				else if(b[0].contentEquals("Traf")){
					String name1=b[1];
					String name2=b[2];
					Edge n1=(Edge) dic.get(name1);
					Edge n2 = (Edge) dic.get(name2);
					if(n1 instanceof Edge && n2 instanceof Edge){
						int pass=Integer.parseInt(b[3]);
						Mat tmp = new Mat((Edge)n1,(Edge)n2,pass);
						mat.add(tmp);
					}
					
				}

				
			
			
			}
			MatAnalyse anal=new MatAnalyse(grafo,mat);
		br.close();
		anal.calcEnc();
		anal.calcTraf();
		anal.calcwarnlink();
		anal.calcularPerdido();
		//anal.printNodo();
		anal.showTudo();
        //anal.showtraf();
        anal.showperd();
	
	
		
		
		/*
		//nodos
		Nodo a = new Nodo(0);
		Edge b = new Edge(1);
		Nodo c = new Nodo(2);
		Nodo d = new Nodo(3);
		Nodo e = new Nodo(4);
		Nodo f = new Nodo(5);
		Nodo g = new Nodo(6);
		Edge h = new Edge(7);

		Link link1= new Link(c,1,5);
		a.addlink(link1);
		Link link2= new Link(f,1,5);
		a.addlink(link2);
		Link link3= new Link(e,1,5);
		a.addlink(link3);

		Link link10= new Link(a,1,5);
		c.addlink(link10);
		Link link20= new Link(a,8,5);
		f.addlink(link20);
		Link link30= new Link(a,7,5);
		e.addlink(link30);

		Link link4= new Link(b,1,5);
		f.addlink(link4);
		Link link5= new Link(f,1,5);
		b.addlink(link5);

		Link link6= new Link(h,1,5);
		c.addlink(link6);
		Link link7= new Link(c,1,5);
		h.addlink(link7);

		Link link8= new Link(d,1,5);
		g.addlink(link8);
		Link link9= new Link(g,1,5);
		d.addlink(link9);

		Link link22= new Link(h,1,5);
		d.addlink(link22);
		Link link44= new Link(d,1,5);
		h.addlink(link44);

		//criar o grafo no ArrayLISt
		ArrayList <Nodo> cnz = new ArrayList<Nodo>();
		cnz.add(a);
		cnz.add(b);
		cnz.add(c);
		cnz.add(d);
		cnz.add(e);
		cnz.add(f);
		cnz.add(g);
		cnz.add(h);

		Mat q= new Mat(b,h,5);
		Mat r = new Mat(h,b,100);
		ArrayList<Mat> nw= new ArrayList<Mat>();
		nw.add(q);
		nw.add(r);
		MatAnalyse ana=new MatAnalyse(cnz, nw);
		ana.calcEnc();
		ana.calcTraf();
		ana.calcwarnlink();
		ana.printlink();
		ana.printNodo();
		ana.showTudo();
		ana.calcularPerdido();
		System.out.print(ana.perdido);
		*/


		/*
		Edge a = new Edge(0);
		Nodo b = new Nodo(1);
		Edge c = new Edge(2);
		Nodo d = new Nodo(3);

		Link l1= new Link(b,1, 2);
		Link l2= new Link(a,1, 2);
		a.addlink(l1);
		b.addlink(l2);

		Link l3= new Link(c,1, 10);
		Link l4= new Link(a,1, 10);
		a.addlink(l3);
		c.addlink(l4);

		Link l5= new Link(d,1, 3);
		Link l6= new Link(a,1, 3);
		a.addlink(l5);
		d.addlink(l6);

		Link l7= new Link(b,1, 3);
		Link l8= new Link(c,1, 3);
		b.addlink(l8);
		c.addlink(l7);

		Link l9= new Link(b,1, 5);
		Link l10= new Link(d,1, 5);
		b.addlink(l10);
		d.addlink(l9);

		Link l11= new Link(d,1, 2);
		Link l12= new Link(c,1, 2);
		d.addlink(l12);
		c.addlink(l11);
		ArrayList <Nodo> cnz = new ArrayList <Nodo>();
		cnz.add(a);
		cnz.add(b);
		cnz.add(c);
		cnz.add(d);

		Mat q= new Mat(a,c,5);
		Mat r = new Mat(c,a,100);
		ArrayList<Mat> nw= new ArrayList<Mat>();
		nw.add(q);
		nw.add(r);
		MatAnalyse ana=new MatAnalyse(cnz, nw);
		ana.calcEnc();
		ana.calcTraf();
		ana.printlink();
		ana.printNodo();
		System.out.print(a.a.toString()+"\n");
		System.out.print(c.a.toString()+"\n");
		 */







	}}
