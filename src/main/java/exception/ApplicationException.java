package exception;

@SuppressWarnings("serial")
public class ApplicationException extends Exception {
	String msg;

	public ApplicationException(String msg) {
		this.msg = msg;
	}

	public String toString() {
		return msg;
	}
}
