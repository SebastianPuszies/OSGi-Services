package de.leuphana.cosu.messagingosgi.domain.builder;

import de.leuphana.cosu.messagingosgi.domain.message.SMTPMessage;

public class SmtpMessageBuilder extends MessageBuilder {

	public SmtpMessageBuilder() {
		message = new SMTPMessage();
	}

}