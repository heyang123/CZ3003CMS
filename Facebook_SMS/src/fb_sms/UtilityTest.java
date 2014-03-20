package fb_sms;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class UtilityTest {

	@Test
	public void test() throws IOException {
		Utility.getConfigs();
	    if (Utility.fb_page_id == null){
	    	fail("fb_page_id empty");
	    }
	    if (Utility.fb_access_token==null){
	    	fail("fb_access_token empty");
	    }
	    if (Utility.sms_account_sid == null){
	    	fail ("sms_account_sid empty");
	    }
	    if (Utility.sms_auth_token == null){
	        fail ("sms_auth_token empty");	
	    }
	    
		
	}

}
