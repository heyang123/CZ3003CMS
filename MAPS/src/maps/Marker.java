package maps;

public class Marker {
	private double[] loc = {-1000,-1000};
	private String icon;
	
	public Marker(double[]ll, String u){
		loc[0] = ll[0];
		loc[1] = ll[1];
		icon = u;
	}
	
	public double[] getLoc(){return loc;}
	public String getIcon(){return icon;}
	public void setLoc(double lat, double lng){
		loc[0] = lat;
		loc[1] = lng;
	}
}
