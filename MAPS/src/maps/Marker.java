package maps;
/**
 * Stores location and icon URL on a marker
 * @author Prerna Chikersal
 * @see MapsController
 */
public class Marker {
	/**
	 * A Two element array of doubles whose 1st element (index = 0) is the latitude and 2nd element (index = 1) is the longitude of a marker or location
	 */
	private double[] loc = {-1000,-1000};
	/**
	 * The {@link String} instance representing the URL of the marker's icon.
	 */
	private String icon;
	
	/**
	 * A constructor which creates a {@link Marker} object 
	 * using a two element double array corresponding to the latitude and longitude of the marker (or location)
	 * and a {@link String} instance representing the URL of the marker's icon.
	 */
	public Marker(double[]ll, String u){
		loc[0] = ll[0];
		loc[1] = ll[1];
		icon = u;
	}
	/**
	 * Gets the Two element array of doubles whose 1st element (index = 0) is the latitude and 2nd element (index = 1) is the longitude of a marker or location
	 * @return Two element array of doubles representing the latitude (index = 0) and longitude (index = 1) of a marker or location
	 */
	public double[] getLoc(){return loc;}
	/**
	 * Gets the {@link String} instance representing the URL of the marker's icon.
	 * @return {@link String} instance representing the URL of the marker's icon.
	 */
	public String getIcon(){return icon;}
	/**
	 * Sets the Two element array of doubles representing the latitude (index = 0) and longitude (index = 1) of a marker or location
	 * @param lat latitude of a marker or location
	 * @param lng longitude of a marker or location
	 */
	public void setLoc(double lat, double lng){
		loc[0] = lat;
		loc[1] = lng;
	}
}
