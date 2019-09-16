package ds;

public class EmptyException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String dsType;
	
	public EmptyException(String s) {
		dsType = s;
	}
	
	@Override
	public String getMessage() {
		return dsType;
	}
}
