package customExceptions;

public class RequiredFieldsException extends Exception {

	public RequiredFieldsException() {
		super("Required fields(name,type of document,id), please enter correct information");
	}
}
