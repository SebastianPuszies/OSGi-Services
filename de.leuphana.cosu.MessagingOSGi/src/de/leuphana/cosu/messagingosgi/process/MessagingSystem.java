package de.leuphana.cosu.messagingosgi.process;

import org.rribbit.Listener;

import de.leuphana.cosu.toolosgi.Tool;
import de.leuphana.cosu.messagingosgi.domain.Content;
import de.leuphana.cosu.messagingosgi.domain.builder.MessageBuilder;
import de.leuphana.cosu.messagingosgi.domain.message.Message;
import de.leuphana.cosu.messagingosgi.domain.messagechannel.MessageChannel;
import de.leuphana.cosu.messagingosgi.domain.messagechannel.MessageChannelFactory;
import de.leuphana.cosu.messagingosgi.domain.messagechannel.MessageChannelType;

public class MessagingSystem extends Tool {
	private static MessagingSystem messagingSystem;

	public MessagingSystem() {
	}

	public synchronized static MessagingSystem createInstance() {
		if (messagingSystem == null) {
			messagingSystem = new MessagingSystem();
		}

		return messagingSystem;
	}

	@Listener(hint="sendMessage")
	public boolean sendMessage(Message message) {
		MessageChannel messageChannel = MessageChannelFactory.create(message);
		messageChannel.open();
		messageChannel.sendMessage(message);
		messageChannel.close();
		
		System.out.println("MessagingSystem - sendMessage");

		return true;
	}

	public Message createMessage(String senderAdress, String receiverAdress,
			String subject, Content content,
			MessageChannelType messageChannelType) {

		MessageBuilder messageBuilder = MessageBuilder
				.create(messageChannelType);
		messageBuilder.setSender(senderAdress);
		messageBuilder.setReceiver(receiverAdress);
		messageBuilder.setSubject(subject);
		messageBuilder.setContent(content);

		return messageBuilder.getMessage();
	}

	@Override
	public void setName() {
		super.name = "MessagingSystem";
	}

}