package customExceptions;

public class UserExistException extends Exception{

	public UserExistException() {
		super("The user exist in the system");
	}
}
