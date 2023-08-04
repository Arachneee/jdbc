package hello.jdbc.repository.ex;

public class MydbException extends RuntimeException {
	public MydbException() {
	}

	public MydbException(String message) {
		super(message);
	}

	public MydbException(String message, Throwable cause) {
		super(message, cause);
	}

	public MydbException(Throwable cause) {
		super(cause);
	}
}
