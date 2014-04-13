package maps;

import java.net.URL;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;

/**
 * Returns the geocoding (latitude and longitude) for any address sent by an instance of the {@link MapsController}.
 * Accesses Google's Geocoding API and parses the result obtained for each address.
 * @author Prerna Chikersal
 * @see <a href="https://developers.google.com/maps/documentation/geocoding/">Google's Geocoding API</a>, MapsController
 */
public class GeocodingController {
	/**
	 * First part of the API URL, before the address
	 */
	private String apiUrlprefix;
	
	/**
	 * Second part of the API URL, after the address
	 */
	private String apiUrlsuffix;
	
	/**
	 * Constructor initializing {@link apiUrlprefix} and {@link apiUrlsuffix}
	 * @param p API URL PREFIX / First part of API URL
	 * @param s API URL SUFFIX / Second part of API URL
	 */
	public GeocodingController(String p, String s){
		apiUrlprefix=p;
		apiUrlsuffix=s;
	}
	/**
	 * Constructor initializing {@link apiUrlprefix} and {@link apiUrlsuffix} with hard-coded values
	 */
	public GeocodingController(){
		apiUrlprefix="https://maps.googleapis.com/maps/api/geocode/json?address=";
		//apiUrlsuffix="&sensor=false&key=AIzaSyAN1O3gbgwQTf4UFPfUwZ9y51W6Dq1I9Qc";
		apiUrlsuffix="&sensor=false&key=AIzaSyD5HKHXRWjMpCzgUhQV0Q3hXbtgGOP0wdY";
	}
	
	/**
	 * Builds the URL to be sent to the Geocoding API as a request
	 * @param address Address whose latitude and longitude has to be found.
	 * @return The {@link String} instance representing the URL to be sent to the Geocoding API as a request.
	 */
	private String buildUrl(String address){
		StringBuilder builder = new StringBuilder();
        builder.append(apiUrlprefix);
        builder.append(address.replaceAll(" ", "+"));
        builder.append(apiUrlsuffix);
        return builder.toString();
	}
	
	/**
	 * Gets the {@link String} instance, representing the response returned form the Geocoding API
	 * @param u API URL sent to the Geocoding API.
	 * @return The {@link String} instance representing the response returned form the Geocoding API.
	 */
	private String getResponse(String u){
		try
        {
			URL url = new URL(u);
			//InputStream stream = url.openStream();
			Scanner scan = new Scanner(url.openStream());
			String txt = new String();
			try
            {
				while (scan.hasNext()){
					txt += scan.nextLine();
					txt += "\n";
				}
            }
            finally
            {
            	scan.close();
            }
			return (String) txt.toString();
        }
		catch (IOException e)
        {
            throw new RuntimeException(e);
        }
	}
	
	/**
	 * Gets the double[] array, representing the latitude and longitude of the location specified in the {@param response}
	 * @param response The {@link String} instance representing the response returned form the Geocoding API.
	 * @return The double[] array containing the latitude and longitude, specified in the response. double[0] is latitude, while double[1] is longitude.
	 */
	private double[] parseLocation(String response){
		String[] lines = response.split("\n");
        double lat=-1000, lng=-1000;
        for (int i = 0; i < lines.length; i++)
        {
            if ("\"location\" : {".equals(lines[i].trim()))
            {
                lat = getOrdinate(lines[i+1]);
                lng = getOrdinate(lines[i+2]);
                break;
            }
        }
        double latLng[]={lat,lng};
		return latLng;
	}
	
	/**
	 * Gets the double value, representing either latitude or longitude of the location specified in the {@param response}
	 * @param s The {@link String} instance from within which the double value has to be extracted.
	 * @return The double value extracted which corresponds to either latitude or longitude of the location specified in the {@param response}.
	 */
	private double getOrdinate(String s){
		String[] split = s.trim().split(" ");

        if (split.length < 1)
        {
            return -1000;
        }

        String ord = split[split.length - 1];

        if (ord.endsWith(","))
        {
            ord = ord.substring(0, ord.length() - 1);
        }
        double d = Double.parseDouble(ord);
		return d;
	}
	
	/**
	 * Gets the double[] array, representing the latitude and longitude of the address specified as a parameter
	 * @param address The {@link String} instance, representing the address whose latitude and longitude is to be found.
	 * @return The double[] array, representing the latitude and longitude of the address whose latitude and longitude was to be found.
	 */
	public double[] getLatLng(String address){
		String url = buildUrl(address);
		String response = getResponse(url);
		return parseLocation(response);
	}
}
