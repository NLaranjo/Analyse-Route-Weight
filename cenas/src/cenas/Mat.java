package cenas;

public class Mat {
	Edge In;
	Edge Out;
	int traf;

	public Mat (Edge idIn, Edge idOut, int traf){
		this.In=idIn;
		this.Out=idOut;
		this.traf=traf;


	}

	@Override
	public String toString() {
		return "Mat [In=" + In + ", Out=" + Out + ", traf=" + traf + "]";
	}
	
}
