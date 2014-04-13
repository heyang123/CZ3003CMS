package maps.test;
import maps.EmergenciesController;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmergenciesControllerTest {
	private EmergenciesController EC; 

	@Before
	public void setUp() throws Exception {
		EC = new EmergenciesController(); 
		// The above instance of EC will fetch emergencies data from the EmergencyFactoryStub
	}

	@Test
	public void testFetchAllEmergencies() {
		EC.fetchAllEmergencies(); // Should perhaps pass an instance of EmergencyFactoryStub??
		int numE = EC.getNumEmergencies();
		for(int i=0; i<numE; i++){ 
			// we test the private method createContent also through this, INDIRECTLY
			// We need to ensure that the data fetched is entered into the private data members: address, correspondingCrisis, correspondingContents
			// This can be done by ensuring that the strings are NOT NULL
			assertNotNull(EC.getAddressAti(i));
			assertNotNull(EC.getCrisisAti(i));
			assertNotNull(EC.getContentAti(i));
			
		}
	}

}
