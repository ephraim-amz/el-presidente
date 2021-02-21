package exceptions;

/**
 * AccumulationException. Custom exception made to be thrown when two markers cannot be accumulated.
 */
public class AccumulationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Constructor of AccumulationException. Occurs when the aggregation of two markers is superior to 100%.
	 * @param message
	 */
	public AccumulationException(String message) {
		super(message);
	}

}
