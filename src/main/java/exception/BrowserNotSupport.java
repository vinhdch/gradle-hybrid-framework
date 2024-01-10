package exception;

public class BrowserNotSupport extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	public BrowserNotSupport(String browserName) {
		super(String.format("BrowserName: %s invalid", browserName.toUpperCase()));

	}
}
