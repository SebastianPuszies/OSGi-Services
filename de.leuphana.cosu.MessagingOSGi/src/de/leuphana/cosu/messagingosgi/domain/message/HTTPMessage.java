package de.leuphana.cosu.messagingosgi.domain.message;


public class HTTPMessage extends Message {
	public HTTPMessage() {
		super.setHeader(new HttpHeader());
	}
}