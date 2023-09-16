package projects.exception;

//built in the exceptions package with a super class
//added serial to get rid of underline in under DbException
@SuppressWarnings("serial")
public class DbException extends RuntimeException {

	public DbException() {
	}

	public DbException(String message) {
		super(message);
	}

	public DbException(Throwable cause) {
		super(cause);
	}

	public DbException(String message, Throwable cause) {
		super(message, cause);
	}

}
