package de.leuphana.cosu.messagingosgi.domain.messagechannel;

import de.leuphana.cosu.messagingosgi.domain.message.HTTPMessage;
import de.leuphana.cosu.messagingosgi.domain.message.Message;
import de.leuphana.cosu.messagingosgi.domain.message.SMTPMessage;

/**
 * @author Slotos-Admin
 * @version 1.0
 * @created 02-Jun-2013 10:15:15
 */
public class MessageChannelFactory {

	private MessageChannelFactory() {
	}

	public static MessageChannel create(Message message) {
		MessageChannel messageChannel = null;
		
		if(message instanceof HTTPMessage) {
			messageChannel = new HTTPMessageChannel();
		} else if(message instanceof SMTPMessage) {
			messageChannel = new SMTPMessageChannel();
		}
		
		return messageChannel;
	}
}