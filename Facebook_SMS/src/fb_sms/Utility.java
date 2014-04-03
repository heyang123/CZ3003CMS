package fb_sms;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utility {
	public static String fb_page_id=null;
	public static String fb_access_token=null;
	public static String sms_account_sid=null;
	public static String sms_auth_token=null;
	
	public static void getConfigs() throws IOException {
		InputStream configFile = null;
		configFile = Utility.class.getResourceAsStream("config.ini");
		Properties properties = new Properties();
		properties.load(configFile);
		fb_page_id = properties.getProperty("fb_page_id");
		fb_access_token = properties.getProperty("fb_access_token");
		sms_account_sid = properties.getProperty("sms_account_sid");
		sms_auth_token = properties.getProperty("sms_auth_token");
		} 
	/*
	public static void main(String[] args) throws IOException{
	    Utility.getConfigs();
		System.out.println(Utility.fb_access_token);
		}*/
}
