package exception;

@SuppressWarnings("serial")
public class ReusableComponentException extends Exception {
	String msg;

	public ReusableComponentException(String msg) {
		this.msg = msg;
	}

	public String toString() {
		return msg;
	}
}
