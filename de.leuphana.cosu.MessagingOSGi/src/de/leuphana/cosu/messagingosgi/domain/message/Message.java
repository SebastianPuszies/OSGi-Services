package de.leuphana.cosu.messagingosgi.domain.message;


public class Message {
	private Header header;
	private Body body;

	public Message() {
		header = new Header();
		body = new Body();
	}

	public Header getHeader() {
		return header;
	}

	public Body getBody() {
		return body;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

}