package control;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.InfoRecord;
import model.ServerCommunication;

public class InfoRecordController {
	private ServerCommunication serverCommunication = null;
	public InfoRecordController() {
		this.serverCommunication = new ServerCommunication();
	}
	// TODO 1. error handling 2. alert message
	public void submitInfoRecord(InfoRecord infoRecord, HttpServletResponse response, HttpSession session) throws IOException {
		boolean result = this.serverCommunication.submitInfoRecord(infoRecord);
		String recSucMsg = "S";
		String recFailMsg = "F";
		if (result) {
			session.setAttribute("recMsg", recSucMsg);
		} else {
			session.setAttribute("recMsg", recFailMsg);
		}
		response.sendRedirect("keyInInfo.jsp");
	}
	
}
