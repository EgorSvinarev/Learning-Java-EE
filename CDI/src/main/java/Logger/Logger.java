package Logger;

import java.util.Date;

public abstract class Logger {

	protected String getCurrentDateTime() {
		Date date = new Date();
		return date.toString();
	}
	
	abstract public void log(String info);
	
}
