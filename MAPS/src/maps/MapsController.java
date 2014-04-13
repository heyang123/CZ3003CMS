package maps;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import maps.EmergenciesController;
import maps.GeocodingController;
import maps.Marker;
/**
 * Controls an instance of {@link EmergenciesController} and {@link GeocodingController}.
 * Stores an ArrayList of marker locations, whose each element is a double[] storing the latitude and longitude of a map marker
 * Stores an ArrayList of {@link String } instances representing marker icon urls, for each map marker
 * @author Prerna Chikersal
 * @see EmergenciesController
 */
public class MapsController {
	/**
	 * An instance of {@link EmergenciesController} which represents the controller for all the emergencies to be displayed on the map.
	 */
	private EmergenciesController eCtrl;
	/**
	 * An ArrayList of instances of {@link Marker} which each represent a marker, which is to be drawn on the Map.
	 */
	private List<Marker> markers = new ArrayList<Marker>(); 
	
	/**
	 * A Constructor which causes the {@link eCtrl} to fetch data regarding all Emergencies.
	 * Iterates through all emergencies, gets their address and passes them one by one through a method of the {@link geoCtrl}  in order to get their corresponding latitude and longitude locations.
	 * These locations and the Display icons are stored in an instance of {@link Marker}.
	 */
	public MapsController(){
		eCtrl = new EmergenciesController();
		GeocodingController geoCtrl = new GeocodingController();
		eCtrl.fetchAllEmergencies(); /// fetch all emergencies from the server
		for(int i=0; i<eCtrl.getNumEmergencies(); i++){
			String addr = eCtrl.getAddressAti(i);
			double[] latlng = geoCtrl.getLatLng(addr);
			if(latlng[0]>=-90 && latlng[0]<=90 && latlng[1]>=-180 && latlng[1]<=180){ // latitude and longitude of only valid addresses must be added
				String iconUrl = createIconUrl(eCtrl.getCrisisAti(i));
				Marker m = new Marker(latlng, iconUrl);
				markers.add(m);
			}
		}
	}
	
	/**
	 * Gets the {@link String} instance representing URL of the marker icon for a specific type of crisis.
	 * The icons/ folder contains the icons used.
	 * @return The {@link String} instance representing URL of the marker icon for a specific type of crisis 
	 * @param The {@link String} instance representing the type of crisis for which we want to find the map marker icon.
	 */
	private String createIconUrl(String crisis){
		String[] crisisWords = crisis.split(" ");
		String url = "icons/"+crisisWords[0].toLowerCase()+".png";
		return url;
	}
	
	/**
	 * Gets the {@link String} instance representing URL of the marker icon for a specific type of crisis at a particular index of the {@link markers}.
	 * @return The {@link String} instance representing URL of the marker icon 
	 * @param i a particular index {@param i} of {@link markers}
	 */
	public String getIconOfMarkerAti(int i){
		return markers.get(i).getIcon();
	}
	
	/**
	 * Gets the {@link String} instance representing the latitude of a specific crisis or emergency situation at index i of {@link markers}.
	 * @return The {@link String} instance representing the latitude of a specific crisis or emergency situation 
	 * @param i a particular index {@param i} of {@link markers}
	 */
	public double getLatOfMarkerAti(int i){
		//System.out.println("lat");
		//System.out.println(markers.get(i).getLoc()[0]);
		return markers.get(i).getLoc()[0];
	}
	
	/**
	 * Gets the {@link String} instance representing the longitude of a specific crisis or emergency situation at index i of {@link markers}.
	 * @return The {@link String} instance representing the longitude of a specific crisis or emergency situation 
	 * @param i a particular index {@param i} of {@link markers}
	 */
	public double getLngOfMarkerAti(int i){
		return markers.get(i).getLoc()[1];
	}
	
	/**
	 * Gets the {@link String} instance representing the content to displayed for a specific crisis or emergency situation at index i of {@link markers}.
	 * @return The {@link String} instance representing the content to displayed for a specific crisis or emergency situation 
	 * @param i a particular index {@param i} of {@link markers}
	 */
	public String getContentOfMarkerAti(int i){
		return eCtrl.getContentAti(i);
	}
	
	/**
	 * Gets the total number of map markers to be displayed
	 * @return integer value, representing the total number of map markers to be displayed
	 */
	public int getNumOfMarkers(){
		return markers.size();
	}
}
