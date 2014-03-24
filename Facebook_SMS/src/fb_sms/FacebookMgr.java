package fb_sms;
import static java.lang.System.out;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;

public class FacebookMgr {
	public FacebookMgr() throws IOException{
		
	}
	
	static FacebookClient facebookClient = null;
	
	//private final FacebookClient facebookClient;
	static {
		try {
			Utility.getConfigs();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacebookMgr.facebookClient = new DefaultFacebookClient(Utility.fb_access_token);
	}
	
	//check with PM if need return value. the return value can be message ID( means post successfully)
	public static String post2FbPage(JSONObject jsonObj) throws JSONException{
		out.println("*Feed publishing*");
		MsgGenerator msgObj = new MsgGenerator();
		String msgBody = msgObj.generateMsg(jsonObj);
		FacebookType publishMessageResponse = facebookClient.publish("415711438563950/feed", FacebookType.class, Parameter.with("message",msgBody));
		
		out.println("Published message ID: " + publishMessageResponse.getId());
		return publishMessageResponse.getId();
		
	}
	
	/*public static void main(String[] args) throws JSONException{
		FacebookMgr testObj = new FacebookMgr();
		testObj.Post2FbPage();
	}*/
	
}
