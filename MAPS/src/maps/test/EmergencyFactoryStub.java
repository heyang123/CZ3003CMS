package maps.test;
import maps.Emergency;

import java.math.*;
import java.util.Random;

public class EmergencyFactoryStub { // Should implement Map Interface?
	private Random random = new Random();
	private String alpha = "abcdefghijklmnopqrstuvwxyz";
	private String nums = "0123456789";
	private String[] crisisOpt = {"Haze", "Dengue", "Fire"};
	private String[] addressOpt = {"36 Nanyang Crescent", "36 Nanyang Drive", "36 Nanyang Avenue", "41 Students Walk", "1 Jurong West Central 2", "2 Jurong Hill", "8 Sentosa Gateway", "2 Jurong East Central 1", "37 Keppel Rd", "21 Lower Kent Ridge Rd"};
	public Emergency[] getEmergencies(){
		int numE = 5 + (int)(Math.random() * ((9 - 5) + 1)); // range [5,9]
		int addrLeft = addressOpt.length-numE;
		int addrStart = random.nextInt(addrLeft);
		//System.out.printf("%d Emergencies Generated", numE);
		Emergency [] emergencies = new Emergency[numE];
		for(int ne=0; ne<numE; ne++){
			String crisis = getRandCrisis();
			String time = getRandString(nums, 1);
			String callerName = getRandString(alpha, 6);
			String phone = getRandString(nums, 8);
			String pincode = getRandString(nums, 6);
			String desc = getRandString(alpha, 6);
			String address = addressOpt[ne+addrStart];
			String status = getRandString(alpha, 4);
			String operator = getRandString(alpha, 6);
			emergencies[ne]= new Emergency(crisis, time, callerName, phone, address, pincode, desc, status, operator);
		}
		return emergencies;
	}
	private String getRandCrisis(){
		int numCrisisTotal = crisisOpt.length;
		return crisisOpt[random.nextInt(numCrisisTotal)];
	}
	private String getRandString(String source, int len){
		char[] chars = source.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		return sb.toString();
	}
}
