package servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.InfoRecordController;
import model.InfoRecord;

/**
 * @author Zhao Yuan
 *
 */
public class InfoRecordServlet extends HttpServlet implements Servlet{

	private InfoRecord infoRecord = null;
	private InfoRecordController infoRecordController = null;
	
	public InfoRecordServlet() {
		infoRecord = new InfoRecord();
		infoRecordController = new InfoRecordController();
	}
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
 
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String mobileNumber = request.getParameter("mobileNumber");
		String location = request.getParameter("location");
		String type = request.getParameter("type");
		this.infoRecord.setName(name);
		this.infoRecord.setMobileNumber(mobileNumber);
		this.infoRecord.setLocation(location);
		this.infoRecord.setTypeOfAssistanceRequest(type);
		this.infoRecordController.submitInfoRecord(infoRecord, response);
	}
	/**
	 * Default serial id
	 */
	private static final long serialVersionUID = 1L;

}
