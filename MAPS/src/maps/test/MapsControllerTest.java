package maps.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import maps.MapsController;
public class MapsControllerTest {
	MapsController mapCtrl;

	@Before
	public void setUp() throws Exception {
		mapCtrl = new MapsController();
	}

	@Test
	public void testGetLatOfMarkerAti() {
		// latitude must always be between -90 & +90
		for(int i=0; i<mapCtrl.getNumOfMarkers(); i++){
			assertTrue(mapCtrl.getLatOfMarkerAti(i)>=-90 && mapCtrl.getLatOfMarkerAti(i)<=90);
		}
	}

	@Test
	public void testGetLngOfMarkerAti() {
		// latitude must always be between -180 & +180
		for(int i=0; i<mapCtrl.getNumOfMarkers(); i++){
			assertTrue(mapCtrl.getLngOfMarkerAti(i)>=-180 && mapCtrl.getLngOfMarkerAti(i)<=180);
		}
	}

	@Test
	public void testGetContentOfMarkerAti() {
		// content can never be null
		for(int i=0; i<mapCtrl.getNumOfMarkers(); i++){
			assertNotNull(mapCtrl.getContentOfMarkerAti(i));
		}
	}

}
