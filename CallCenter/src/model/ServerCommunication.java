package model;

import server.Server;

public class ServerCommunication {
	public boolean validateUser(User user) {
		return Server.validateUser(user);
	}
	public boolean submitInfoRecord(InfoRecord infoRecord) {
		return Server.recordInfo(infoRecord);
	}
}
