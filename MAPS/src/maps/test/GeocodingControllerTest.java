package maps.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import maps.GeocodingController;
public class GeocodingControllerTest {
	//Below is an array of valid address strings
	private String[] validTestAddresses={"36 Nanyang Crescent", "36 Nanyang Drive", "36 Nanyang Avenue", "41 Students Walk", "1 Jurong West Central 2", "2 Jurong Hill", "8 Sentosa Gateway", "2 Jurong East Central 1", "37 Keppel Rd", "21 Lower Kent Ridge Rd"};
	//Below is an array of invalid address strings
	private String[] invalidTestAddresses={"zzzzzz", "ppppp", "", "wrongaddress", "bfghj", "dgfhgou", "678iouijhgf"};
	//Declaring an instance of GeocodingController
	private GeocodingController geoCtrl;

	@Before
	public void setUp() throws Exception {
		geoCtrl = new GeocodingController(); 
	}

	@Test
	public void testGetLatLng() {
		/// Testing GeocodingController on valid test addresses
		/// lat of valid addresses will always be in the range of -90 to +90
		/// long of valid addresses will always be in the range of -180 to +180
		for(int i =0; i<validTestAddresses.length; i++){
			double[] latlng = geoCtrl.getLatLng(validTestAddresses[i]);
			assertTrue(latInRange(latlng[0])&&lngInRange(latlng[1]));
		}
		
		/// Then, testing GeocodingController on invalid test address
		/// lat of invalid addresses will NOT be in the range of -90 to +90
		/// long of invalid addresses will NOT be in the range of -180 to +180
		for(int i =0; i<invalidTestAddresses.length; i++){
			double[] latlng = geoCtrl.getLatLng(invalidTestAddresses[i]);
			assertFalse(latInRange(latlng[0])&&lngInRange(latlng[1]));
		}
	}
	boolean latInRange(double lat){
		return (lat>=-90)&&(lat<=90);
	}
	boolean lngInRange(double lng){
		return (lng>=-180)&&(lng<=180);
	}
}
