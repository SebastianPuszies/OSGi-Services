package de.leuphana.cosu.messagingosgi.domain.builder;

import de.leuphana.cosu.messagingosgi.domain.message.HTTPMessage;

public class HttpMessageBuilder extends MessageBuilder {

	public HttpMessageBuilder() {
		message = new HTTPMessage();
	}
	
}