package Logger;

public class ConsoleLogger extends Logger {

	public ConsoleLogger() {
		super();
	}

	@Override
	public void log(String info) {
		String formatedInfo = "[" + this.getCurrentDateTime() + "] = " + info;
		System.out.println(formatedInfo);
	}

}
