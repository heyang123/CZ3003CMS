package fb_sms;
import static java.lang.System.out;

import org.json.JSONException;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;

public class FacebookMgr {
	public FacebookMgr(){
		
	}
	
	//private final FacebookClient facebookClient;
	public static final String accessToken = "CAAKHYIHeTQEBABki6nl0K8WsT7dAVUd6IzDmceVoBTW5x97MafXdTYLHSlzElS4shSHN1s20i5tqrm8wZCEcnIOgQDvmRHxQfthS0BJnSUVHQZBnhpAD7vmRkLKPCaZCMEIGvrreE9bHB3I46xkE1jfqvl6sptNnSZC0c3RZCCFXp7iASX9TksdhbjEjU3wMZD";
	FacebookClient facebookClient = new DefaultFacebookClient(accessToken);
	
	//check with PM if need return value. the return value can be message ID( means post successfully)
	public void post2FbPage() throws JSONException{
		out.println("*Feed publishing*");
		MsgGenerator msgObj = new MsgGenerator();
		String msgBody = msgObj.generateMsg();
		FacebookType publishMessageResponse = facebookClient.publish("415711438563950/feed", FacebookType.class, Parameter.with("message",msgBody));
		
		out.println("Published message ID: " + publishMessageResponse.getId());
		//return publishMessageResponse.getId();
		
	}
	
	/*public static void main(String[] args) throws JSONException{
		FacebookMgr testObj = new FacebookMgr();
		testObj.Post2FbPage();
	}*/
	
}
