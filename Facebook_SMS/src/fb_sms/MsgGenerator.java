package fb_sms;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.json.*;

public class MsgGenerator {
	public MsgGenerator(){
		
	}
	
	public String generateMsg() throws JSONException{
		IncidentInfo incidentInfoObj = new IncidentInfo();
		JSONObject jsonObj = incidentInfoObj.jsonGenerator();
		String a = incidentInfoObj.getIncidentType(jsonObj);
		String b = incidentInfoObj.getIncidentLocation(jsonObj);
		String c = incidentInfoObj.getIncidentDetails(jsonObj);
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HH:mm:ss").format(Calendar.getInstance().getTime());
		String msgContent = "Message from CMS:\n"+ "Incident Type: "+a+"\nIncident Location: "+b+"\nIncident Details: "+c+"\nUpdated at "+ timeStamp ; 
	
		return msgContent;
	}
	
	/*public static void main(String[] args) throws JSONException{
		MsgGenerator testObj = new MsgGenerator();
		System.out.println(testObj.generateMsg());
	}*/
}