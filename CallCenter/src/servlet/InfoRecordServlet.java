package servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		// Get session
		HttpSession session = request.getSession();
		//
		String operatorName = (String) session.getAttribute("username");
		System.out.print(operatorName);
		String name = request.getParameter("name");
		String phoneNo = request.getParameter("phoneNo");
		String agencyAddress = request.getParameter("agencyAddress");
		String agencyType = request.getParameter("agencyType");
		String postalCode = request.getParameter("postalCode");
		// System.out.println(Integer.parseInt(agencyType));
		this.infoRecord.setOperatorName(operatorName);
		this.infoRecord.setName(name);
		this.infoRecord.setPhoneNo(phoneNo);
		this.infoRecord.setAgencyAddress(agencyAddress);
		this.infoRecord.setAgencyType(Integer.parseInt(agencyType));
		this.infoRecord.setPostalCode(postalCode);
		this.infoRecordController.submitInfoRecord(infoRecord, response, session);
	}
	/**
	 * Default serial id
	 */
	private static final long serialVersionUID = 1L;

}
