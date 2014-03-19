package control;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import model.InfoRecord;
import model.ServerCommunication;

public class InfoRecordController {
	private ServerCommunication serverCommunication = null;
	public InfoRecordController() {
		this.serverCommunication = new ServerCommunication();
	}
	// TODO 1. error handling 2. alert message
	public void submitInfoRecord(InfoRecord infoRecord, HttpServletResponse response) throws IOException {
		boolean result = this.serverCommunication.submitInfoRecord(infoRecord);
		if (result) {
			System.out.print("Record successful");
		} else {
			System.out.print("Record fail");
		}
		response.sendRedirect("keyInInfo.jsp");
	}
	
}
