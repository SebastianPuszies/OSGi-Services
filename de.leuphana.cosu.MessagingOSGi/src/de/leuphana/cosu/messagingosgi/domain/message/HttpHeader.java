package de.leuphana.cosu.messagingosgi.domain.message;

public class HttpHeader extends Header {
	private String cookieId;

	public HttpHeader() {
		super();
		// Simulation einer CookieId !!!
		cookieId = "13136751151";
	}
	
	public String getCookieId() {
		return cookieId;
	}
}