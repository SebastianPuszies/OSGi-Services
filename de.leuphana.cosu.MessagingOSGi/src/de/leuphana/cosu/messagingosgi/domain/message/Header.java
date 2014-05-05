package de.leuphana.cosu.messagingosgi.domain.message;

public class Header {

	private String senderAdress;
	private String receiverAdress;
	private String subject;

	public void setSender(String senderAdress) {
		this.senderAdress = senderAdress;
	}

	public void setReceiver(String receiverAdress) {
		this.receiverAdress = receiverAdress;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSenderAdress() {
		return senderAdress;
	}

	public String getReceiverAdress() {
		return receiverAdress;
	}

	public String getSubject() {
		return subject;
	}

}