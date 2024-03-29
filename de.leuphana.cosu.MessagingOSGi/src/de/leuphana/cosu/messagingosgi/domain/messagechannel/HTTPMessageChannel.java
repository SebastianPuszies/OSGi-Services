package de.leuphana.cosu.messagingosgi.domain.messagechannel;

import de.leuphana.cosu.messagingosgi.domain.message.HTTPMessage;
import de.leuphana.cosu.messagingosgi.domain.message.Header;
import de.leuphana.cosu.messagingosgi.domain.message.HttpHeader;
import de.leuphana.cosu.messagingosgi.domain.message.Message;

/**
 * @author Slotos-Admin
 * @version 1.0
 * @created 02-Jun-2013 10:15:15
 */
public class HTTPMessageChannel extends MessageChannel {

	public HTTPMessageChannel() {
	}

	public void open() {
		System.out.println("HTTPMessageChannel.open()");
		// Spezielles open ...
	}

	public void sendMessage(Message message) {
		System.out.println(MessageChannelType.HTTP);
		super.sendMessage(message);
		if (message instanceof HTTPMessage) {
			HTTPMessage httpMessage = (HTTPMessage) message;
			Header header = httpMessage.getHeader();
			if(header instanceof HttpHeader) {
				HttpHeader httpHeader = (HttpHeader)header;
				System.out.println(httpHeader.getCookieId());
			}
		}
	}

	public void close() {
		System.out.println("HTTPMessageChannel.close()");
	}
}