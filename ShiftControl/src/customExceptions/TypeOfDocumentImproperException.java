package customExceptions;

public class TypeOfDocumentImproperException extends Exception {
	private String type; 
	public TypeOfDocumentImproperException(String t) {
		super("The type of document is invalid "+ t);
		type=t;
		
	}
}
